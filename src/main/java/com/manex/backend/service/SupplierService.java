package com.manex.backend.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.manex.backend.DAO.SupplierDAO;
import com.manex.backend.DAO.TbMmDAO;
import com.manex.backend.GenericMethods.GenericMethods;
import com.manex.backend.entities.*;
import com.manex.backend.repositories.*;
import com.manex.backend.response.XscResponse;

import jakarta.transaction.Transactional;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.Color;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Transactional
public class SupplierService implements SupplierDAO {

    private static final ConcurrentHashMap<String, Path> tempFilesMap = new ConcurrentHashMap<>();

    @Autowired private TbMmDAO tbMmDAO;

    @Autowired private TbCompanyRepository tbCompanyRepository;

    @Autowired private TbAllAddrRepository tbAllAddrRepository;

    @Autowired private TbCompanyAddrRepository tbCompanyAddrRepository;

    @Autowired private TbClientSupplierRepository tbClientSupplierRepository;

    @Autowired private TbProductsRepository tbProductsRepository;

    @Autowired private TbCountryRepository tbCountryRepository;

    @Autowired private TbStateRepository tbStateRepository;

    @Autowired private TbCityRepository tbCityRepository;

    @Autowired private TbMmRepository tbMmRepository;

    @Autowired private TbSupplierPoRepository tbSupplierPoRepository;

    @Autowired private TbSupplierQuotationRepository tbSupplierQuotationRepository;

    @Autowired private TbSupplierPiRepository tbSupplierPiRepository;

    @Autowired private TbSupplierInvoiceRepository tbSupplierInvoiceRepository;

    @Autowired private TbSupplierPoItemsRepository tbSupplierPoItemsRepository;

    @Autowired private TbAppClientRepository tbAppClientRepository;

    @Autowired private TbSupplierOrderApRepository tbSupplierOrderApRepository;

    @Override
    public XscResponse addSupplier(MultipartFile file, JSONObject payload) throws IOException {
        XscResponse response = new XscResponse();

        TbMm tbMm = new TbMm();
        if (file != null) {
            tbMm =
                    tbMmDAO.saveImageFileWithName(
                            "supplierImages", file, payload.get("NAME").toString(), null);
        }

        // TbCompany
        TbCompany company = new TbCompany();
        company.setNAME(payload.get("NAME").toString());
        company.setREG_NUMBER(payload.get("REG_NUMBER").toString());
        company.setTAX_NUMBER(payload.get("TAX").toString());
        company.setCONTACT_NUMBER(payload.get("CONTACT_NUMBER").toString());
        company.setALT_CONTACT_NUMBER(payload.get("ALT_CONTACT_NUMBER").toString());
        company.setEMAIL(payload.get("EMAIL").toString());
        company.setFAX(payload.get("FAX").toString());
        company.setWEBSITE(payload.get("WEBSITE").toString());
        company.setLOGO(tbMm.getID());
        company.setCREATED_DATE(Date.valueOf(LocalDate.now()));
        company = tbCompanyRepository.save(company);

        // TbAllAddr
        TbAllAddr tbAllAddr = new TbAllAddr();
        tbAllAddr.setAPP_CLIENT_ID(Integer.valueOf(payload.get("APP_CLIENT_ID").toString()));
        tbAllAddr.setADDR_1(payload.get("ADDR_1").toString());
        tbAllAddr.setADDR_2(payload.get("ADDR_2").toString());
        tbAllAddr.setCOUNTRY_ID(Integer.valueOf(payload.get("COUNTRY_ID").toString()));
        tbAllAddr.setSTATE_ID(Integer.valueOf(payload.get("STATE_ID").toString()));
        tbAllAddr.setDISTRICT_ID(Integer.valueOf(payload.get("DISTRICT_ID").toString()));
        tbAllAddr.setCITY_ID(Integer.valueOf(payload.get("CITY_ID").toString()));
        tbAllAddr.setPOSTAL_CODE(payload.get("POSTAL_CODE").toString());
        tbAllAddr = tbAllAddrRepository.save(tbAllAddr);

        // TbCompanyAddr
        TbCompanyAddr tbCompanyAddr = new TbCompanyAddr();
        tbCompanyAddr.setCOMPANY_ID(company.getID());
        tbCompanyAddr.setADDR_ID(tbAllAddr.getID());
        tbCompanyAddr.setSTATUS(1);
        tbCompanyAddr.setDEFAULT_ADDR('Y');
        tbCompanyAddrRepository.save(tbCompanyAddr);

        // TbClientSupplier
        TbClientSupplier tbClientSupplier = new TbClientSupplier();
        tbClientSupplier.setCOMPANY_ID(company.getID());
        tbClientSupplier.setAPP_CLIENT_ID(Integer.valueOf(payload.get("APP_CLIENT_ID").toString()));
        tbClientSupplier.setIS_SUPP_FAV(payload.get("IS_SUPP_FAV").toString().charAt(0));
        tbClientSupplier.setSTATUS(1);
        tbClientSupplier.setSUPP_NUM("Supp12");
        tbClientSupplier = tbClientSupplierRepository.save(tbClientSupplier);

        JsonObject data = new JsonObject();

        data.addProperty("CLIENT_SUPPLIER_ID", tbClientSupplier.getID());
        data.addProperty("COMPANY_ID", company.getID());

        JsonNode jsonNode = GenericMethods.convertGsonToJackson(data);
        response.setXscData(jsonNode);
        response.setXscMessage("Supplier Added Successfully");
        response.setXscStatus(1);

        return response;
    }

    @Override
    public XscResponse listSupplier(JSONObject payload) {
        int favourite_suppliers = 0;
        int regular_suppliers = 0;
        String search_keyword = payload.optString("SEARCH_KEYWORD", "");

        XscResponse response = new XscResponse();

        JsonObject responseObject = new JsonObject();

        List<TbClientSupplier> tbClientSupplierList =
                tbClientSupplierRepository.findAllByAppClientIdAndSearchKeyword(
                        payload.getString("APP_CLIENT_ID"), search_keyword);

        List<TbCompany> tbCompanyList = new ArrayList<>();
        for (TbClientSupplier tbClientSupplier1 : tbClientSupplierList) {
            tbCompanyList.add(
                    tbCompanyRepository.findById(tbClientSupplier1.getCOMPANY_ID()).orElseThrow());

            if (tbClientSupplier1.getIS_SUPP_FAV() == 'Y') {
                favourite_suppliers++;
            } else {
                regular_suppliers++;
            }
        }

        List<TbCountry> tbCountryList = new ArrayList<>();
        for (TbCompany tbCompany : tbCompanyList) {
            TbCompanyAddr tbCompanyAddr =
                    tbCompanyAddrRepository.findDefaultAddressByCompanyId(tbCompany.getID());
            TbAllAddr tbAllAddr =
                    tbAllAddrRepository.findById(tbCompanyAddr.getADDR_ID()).orElseThrow();
            tbCountryList.add(
                    tbCountryRepository.findById(tbAllAddr.getCOUNTRY_ID()).orElseThrow());
        }

        JsonArray arrayList = new JsonArray();
        for (int i = 0; i < tbCompanyList.size(); i++) {
            JsonObject data = new JsonObject();
            data.addProperty("CONTACT_NUMBER", tbCompanyList.get(i).getCONTACT_NUMBER());
            data.addProperty("EMAIL", tbCompanyList.get(i).getEMAIL());
            data.addProperty("SUPPLIER_NAME", tbCompanyList.get(i).getNAME());
            data.addProperty("CLIENT_SUPPLIER_ID", tbClientSupplierList.get(i).getID());
            data.addProperty("SUPP_NUM", tbClientSupplierList.get(i).getSUPP_NUM());
            data.addProperty("IS_SUPP_FAV", tbClientSupplierList.get(i).getIS_SUPP_FAV());
            data.addProperty("LOCATION", tbCountryList.get(i).getCOUNTRY());
            arrayList.add(data);
        }

        responseObject.add("SUPPLIER_LIST", arrayList);
        responseObject.addProperty("FAVOURITE_SUPPLIER", favourite_suppliers);
        responseObject.addProperty("REGULAR_SUPPLIER", regular_suppliers);
        responseObject.addProperty("TOTAL_SUPPLIERS", tbCompanyList.size());

        response.setXscData(GenericMethods.convertGsonToJackson(responseObject));
        response.setXscMessage("Supplier records fetched successfully !!!");
        response.setXscStatus(1);
        return response;
    }

    @Override
    public XscResponse getSupplierDetails(String clientSupplierId) {
        XscResponse response = new XscResponse();
        TbClientSupplier tbClientSupplier =
                tbClientSupplierRepository
                        .findById(Integer.valueOf(clientSupplierId))
                        .orElseThrow();

        TbCompany tbCompany =
                tbCompanyRepository.findById(tbClientSupplier.getCOMPANY_ID()).orElseThrow();

        Pageable pageable = PageRequest.of(0, 1000);

        List<TbProducts> tbProducts =
                tbProductsRepository.findAllByClientSupplierId(clientSupplierId, pageable);

        TbCompanyAddr tbCompanyAddr =
                tbCompanyAddrRepository.findDefaultAddressByCompanyId(tbCompany.getID());

        TbAllAddr tbAllAddr =
                tbAllAddrRepository.findById(tbCompanyAddr.getADDR_ID()).orElseThrow();

        TbCountry tbCountry = tbCountryRepository.findById(tbAllAddr.getCOUNTRY_ID()).orElseThrow();

        TbState tbState = tbStateRepository.findById(tbAllAddr.getSTATE_ID()).orElseThrow();

        TbCity tbCity = tbCityRepository.findById(tbAllAddr.getCITY_ID()).orElseThrow();

        TbMm tbMm = tbMmRepository.findById(tbCompany.getLOGO()).orElseThrow();

        JsonObject data = new JsonObject();
        JsonObject jsonObject1 = new JsonObject();
        JsonObject jsonObject2 = new JsonObject();
        jsonObject1.addProperty("COMPANY_ID", tbCompany.getID());
        jsonObject1.addProperty("CREATED_ON", tbCompany.getCREATED_DATE().getTime());
        jsonObject1.addProperty("LOGO", tbMm.getMM_FILE_NAME());
        jsonObject1.addProperty("SUPP_NAME", tbCompany.getNAME());
        jsonObject1.addProperty("EMAIL", tbCompany.getEMAIL());
        jsonObject1.addProperty("PHONE_NUMBER", tbCompany.getCONTACT_NUMBER());
        jsonObject1.addProperty("WEBSITE", tbCompany.getWEBSITE());
        jsonObject1.addProperty("REG_NUMBER", tbCompany.getREG_NUMBER());
        jsonObject1.addProperty("TAX_NUMBER", tbCompany.getTAX_NUMBER());
        jsonObject1.addProperty("FAX", tbCompany.getFAX());
        jsonObject1.addProperty("REG_NUMBER", tbCompany.getREG_NUMBER());
        jsonObject1.addProperty("ADDR_1", tbAllAddr.getADDR_1());
        jsonObject1.addProperty("ADDR_2", tbAllAddr.getADDR_2());
        jsonObject1.addProperty("POSTAL_CODE", tbAllAddr.getPOSTAL_CODE());
        jsonObject1.addProperty("COUNTRY", tbCountry.getCOUNTRY());
        jsonObject1.addProperty("COUNTRY_ID", tbCountry.getID());
        jsonObject1.addProperty("STATE", tbState.getSTATE());
        jsonObject1.addProperty("STATE_ID", tbState.getID());
        jsonObject1.addProperty("CITY", tbCity.getCITY());
        jsonObject1.addProperty("CITY_ID", tbCity.getID());
        jsonObject1.addProperty("STATUS", tbClientSupplier.getSTATUS());
        jsonObject1.addProperty("IS_SUPP_FAV", tbClientSupplier.getIS_SUPP_FAV());

        jsonObject2.addProperty("TOTAL_PRODUCT", tbProducts.size());

        data.add("INFO", jsonObject1);
        data.add("ORDER_AND_PAYMENT_DETAILS", jsonObject2);
        response.setXscData(GenericMethods.convertGsonToJackson(data));
        response.setXscMessage("Supplier data fetched.");
        response.setXscStatus(1);
        return response;
    }

    @Override
    public XscResponse updateSupplier(JSONObject payload) {
        XscResponse response = new XscResponse();

        TbClientSupplier tbClientSupplier =
                tbClientSupplierRepository
                        .findById(payload.getInt("CLIENT_SUPPLIER_ID"))
                        .orElseThrow();
        TbCompany tbCompany =
                tbCompanyRepository.findById(tbClientSupplier.getCOMPANY_ID()).orElseThrow();

        TbCompanyAddr tbCompanyAddr =
                tbCompanyAddrRepository.findDefaultAddressByCompanyId(tbCompany.getID());
        TbAllAddr tbAllAddr =
                tbAllAddrRepository.findById(tbCompanyAddr.getADDR_ID()).orElseThrow();

        // TbClientSupplier
        tbClientSupplier.setIS_SUPP_FAV(payload.get("IS_SUPP_FAV").toString().charAt(0));
        tbClientSupplier.setSTATUS(payload.getInt("STATUS"));
        tbClientSupplier = tbClientSupplierRepository.save(tbClientSupplier);

        // TbCompany
        tbCompany.setNAME(payload.get("NAME").toString());
        tbCompany.setREG_NUMBER(payload.get("REG_NUMBER").toString());
        tbCompany.setTAX_NUMBER(payload.get("TAX").toString());
        tbCompany.setCONTACT_NUMBER(payload.get("CONTACT_NUMBER").toString());
        tbCompany.setEMAIL(payload.get("EMAIL").toString());
        tbCompany.setFAX(payload.get("FAX").toString());
        tbCompany.setWEBSITE(payload.get("WEBSITE").toString());
        tbCompany = tbCompanyRepository.save(tbCompany);

        // TbAllAddr
        tbAllAddr.setADDR_1(payload.get("ADDR_1").toString());
        tbAllAddr.setADDR_2(payload.get("ADDR_2").toString());
        tbAllAddr.setCOUNTRY_ID(Integer.valueOf(payload.get("COUNTRY_ID").toString()));
        tbAllAddr.setSTATE_ID(Integer.valueOf(payload.get("STATE_ID").toString()));
        tbAllAddr.setCITY_ID(Integer.valueOf(payload.get("CITY_ID").toString()));
        tbAllAddr.setPOSTAL_CODE(payload.get("POSTAL_CODE").toString());
        tbAllAddrRepository.save(tbAllAddr);

        JsonObject data = new JsonObject();

        data.addProperty("CLIENT_SUPPLIER_ID", tbClientSupplier.getID());
        data.addProperty("COMPANY_ID", tbCompany.getID());

        JsonNode jsonNode = GenericMethods.convertGsonToJackson(data);
        response.setXscData(jsonNode);
        response.setXscMessage("Supplier Added Successfully");
        response.setXscStatus(1);

        return response;
    }

    @Override
    public XscResponse supplierNameFilter(
            String appClientId, String searchKeyword, String currentPage, String itemPerPage) {
        XscResponse response = new XscResponse();

        List<TbClientSupplier> tbClientSupplierList =
                tbClientSupplierRepository.findAllByAppClientIdAndSearchKeyword(
                        appClientId, searchKeyword);

        List<TbCompany> tbCompanyList = new ArrayList<>();

        for (TbClientSupplier tbClientSupplier : tbClientSupplierList) {
            tbCompanyList.add(
                    tbCompanyRepository.findById(tbClientSupplier.getCOMPANY_ID()).orElseThrow());
        }

        JsonObject data = new JsonObject();

        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i < tbCompanyList.size(); i++) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("CLIENT_SUPPLIER_ID", tbClientSupplierList.get(i).getID());
            jsonObject.addProperty("NAME", tbCompanyList.get(i).getNAME());
            jsonArray.add(jsonObject);
        }
        data.add("SUPPLIER_LIST", jsonArray);

        response.setXscData(GenericMethods.convertGsonToJackson(data));
        response.setXscMessage("Supplier filter name");
        response.setXscStatus(1);
        return response;
    }

    @Override
    public XscResponse supplierTypeFilter(String appClientId) {
        XscResponse response = new XscResponse();

        List<TbClientSupplier> tbClientSupplierList =
                tbClientSupplierRepository.findAllByAppClientIdAndSearchKeyword(appClientId, "");

        JsonObject data = new JsonObject();

        JsonArray jsonArray = new JsonArray();
        for (TbClientSupplier tbClientSupplier : tbClientSupplierList) {

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("IS_FAV", tbClientSupplier.getIS_SUPP_FAV());
            if (tbClientSupplier.getIS_SUPP_FAV() == 'Y') {
                jsonObject.addProperty("TYPE", "Favourite");
            } else {
                jsonObject.addProperty("TYPE", "Regular");
            }

            jsonArray.add(jsonObject);
        }
        data.add("FAV_FILTER", jsonArray);

        response.setXscData(GenericMethods.convertGsonToJackson(data));
        response.setXscMessage("Favourite filter.");
        response.setXscStatus(1);
        return response;
    }

    @Override
    public XscResponse supplierStatusFilter(String appClientId) {
        XscResponse response = new XscResponse();

        List<TbClientSupplier> tbClientSupplierList =
                tbClientSupplierRepository.findAllByAppClientIdAndSearchKeyword(appClientId, "");
        JsonObject data = new JsonObject();

        JsonArray jsonArray = new JsonArray();
        for (TbClientSupplier tbClientSupplier : tbClientSupplierList) {

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("STATUS", tbClientSupplier.getSTATUS());
            if (tbClientSupplier.getSTATUS() == 1) {
                jsonObject.addProperty("TYPE", "Active");
            } else {
                jsonObject.addProperty("TYPE", "Inactive");
            }

            if (!jsonArray.contains(jsonObject)) {
                jsonArray.add(jsonObject);
            }
        }
        data.add("STATUS_FILTER", jsonArray);

        response.setXscData(GenericMethods.convertGsonToJackson(data));
        response.setXscMessage("Status filter.");
        response.setXscStatus(1);
        return response;
    }

    @Override
    public XscResponse markSupplierFavourite(String clientSuppId, String isFavourite) {
        TbClientSupplier tbClientSupplier =
                tbClientSupplierRepository.findById(Integer.valueOf(clientSuppId)).orElseThrow();
        tbClientSupplier.setIS_SUPP_FAV(isFavourite.charAt(0));
        tbClientSupplierRepository.save(tbClientSupplier);
        return new XscResponse(1, "Supplier type updated successfully.");
    }

    @Override
    public XscResponse addAllSuppliers(int appClientId, JSONArray list) {
        XscResponse response = new XscResponse();

        for (int i = 0; i < list.length(); i++) {
            JSONObject jsonObject = list.getJSONObject(i);

            TbCountry tbCountry =
                    tbCountryRepository.findByISO3(jsonObject.getString("COUNTRY_ISO3"));

            TbCompany tbCompany = new TbCompany();
            tbCompany.setNAME(jsonObject.getString("COMPANY_NAME"));
            tbCompany.setEMAIL(jsonObject.getString("EMAIL"));
            tbCompany.setCONTACT_NUMBER(jsonObject.getString("CONTACT_NO"));
            tbCompany.setALT_CONTACT_NUMBER(jsonObject.getString("ALT_CONTACT_NO"));
            tbCompany.setWEBSITE(jsonObject.getString("WEBSITE"));
            tbCompany.setREG_NUMBER(jsonObject.getString("REG_NO"));
            tbCompany.setTAX_NUMBER(jsonObject.getString("TAX").replace(".0", ""));
            tbCompany.setFAX(jsonObject.getString("FAX").replace(".0", ""));
            tbCompany.setCREATED_DATE(Date.valueOf(LocalDate.now()));
            tbCompany = tbCompanyRepository.save(tbCompany);

            TbAllAddr tbAllAddr = new TbAllAddr();
            tbAllAddr.setAPP_CLIENT_ID(appClientId);
            tbAllAddr.setADDR_1(jsonObject.getString("ADDR_LINE_1"));
            tbAllAddr.setADDR_2(jsonObject.getString("ADDR_LINE_2"));
            tbAllAddr.setCOUNTRY_ID(tbCountry.getID());
            tbAllAddr.setPOSTAL_CODE(jsonObject.getString("PINCODE").replace(".0", ""));
            tbAllAddr = tbAllAddrRepository.save(tbAllAddr);

            TbCompanyAddr tbCompanyAddr = new TbCompanyAddr();
            tbCompanyAddr.setCOMPANY_ID(tbCompany.getID());
            tbCompanyAddr.setADDR_ID(tbAllAddr.getID());
            tbCompanyAddr.setSTATUS(1);
            tbCompanyAddr.setDEFAULT_ADDR('Y');
            tbCompanyAddrRepository.save(tbCompanyAddr);

            TbClientSupplier tbClientSupplier = new TbClientSupplier();
            tbClientSupplier.setCOMPANY_ID(tbCompany.getID());
            tbClientSupplier.setAPP_CLIENT_ID(appClientId);
            tbClientSupplier.setIS_SUPP_FAV('N');
            tbClientSupplier.setSTATUS(1);
            tbClientSupplier.setSUPP_NUM("Random");
            tbClientSupplierRepository.save(tbClientSupplier);
        }

        response.setXscStatus(1);
        response.setXscMessage("Suppliers added successfully.");
        return response;
    }

    @Override
    public XscResponse getReports(JSONObject payload) {
        XscResponse response = new XscResponse();

        List<TbSupplierPo> tbSupplierPoList =
                tbSupplierPoRepository.findByAppClientIdAndClientSupplierId(
                        payload.getInt("APP_CLIENT_ID"), payload.getInt("CLIENT_SUPPLIER_ID"));

        List<TbSupplierQuotation> tbSupplierQuotationList =
                tbSupplierPoList.stream()
                        .flatMap(
                                tbSupplierPo ->
                                        tbSupplierQuotationRepository
                                                .findAllBySuppPoId(tbSupplierPo.getID())
                                                .stream())
                        .toList();

        List<TbSupplierPi> tbSupplierPiList =
                tbSupplierQuotationList.stream()
                        .flatMap(
                                tbSupplierQuotation ->
                                        tbSupplierPiRepository
                                                .findAllBySuppQuotId(tbSupplierQuotation.getID())
                                                .stream())
                        .toList();

        List<TbSupplierInvoice> tbSupplierInvoiceList =
                tbSupplierPiList.stream()
                        .flatMap(
                                tbSupplierPi ->
                                        tbSupplierInvoiceRepository
                                                .findAllBySuppPiId(tbSupplierPi.getID())
                                                .stream())
                        .toList();

        List<TbSupplierPoItems> tbSupplierPoItemsList =
                tbSupplierPoList.stream()
                        .flatMap(
                                tbSupplierPo ->
                                        tbSupplierPoItemsRepository
                                                .findAllBySupplierPoId(tbSupplierPo.getID())
                                                .stream())
                        .toList();

        List<TbSupplierOrderAp> tbSupplierOrderApList =
                tbSupplierInvoiceList.stream()
                        .flatMap(
                                tbSupplierInvoice ->
                                        tbSupplierOrderApRepository
                                                .findBySupplierInvoiceId(tbSupplierInvoice.getID())
                                                .stream())
                        .toList();

        JsonObject data = new JsonObject();

        JsonArray jsonArray = new JsonArray();

        for (int i = 0; i < tbSupplierInvoiceList.size(); i++) {
            JsonObject jsonObject = new JsonObject();

            jsonObject.addProperty("INVOICE_ID", tbSupplierInvoiceList.get(i).getID());
            jsonObject.addProperty("ORDER_NUMBER", tbSupplierInvoiceList.get(i).getSUPP_INV_NUM());
            jsonObject.addProperty("TOTAL_ITEM", tbSupplierPoItemsList.get(i).getQTY());
            jsonObject.addProperty("TOTAL_CTN", tbSupplierPoItemsList.get(i).getQTY());
            jsonObject.addProperty(
                    "CREATED_ON",
                    String.valueOf(tbSupplierInvoiceList.get(i).getTIMESTAMP()).split(" ")[0]);
            jsonObject.addProperty("TOTAL_AMOUNT", tbSupplierInvoiceList.get(i).getGRAND_TOTAL());
            jsonObject.addProperty(
                    "DUE_AMOUNT",
                    tbSupplierInvoiceList.get(i).getGRAND_TOTAL()
                            - tbSupplierOrderApList.get(i).getAMOUNT_PAID());
            jsonObject.addProperty(
                    "PAYMENT_STATUS", tbSupplierInvoiceList.get(i).getSUPP_INV_NUM());
            jsonObject.addProperty("TOTAL_ORDERS", tbSupplierInvoiceList.size());

            jsonArray.add(jsonObject);
        }

        data.add("ORDER_LIST", jsonArray);

        response.setXscData(GenericMethods.convertGsonToJackson(data));
        response.setXscMessage("Data fetched successfully");
        response.setXscStatus(1);
        return response;
    }

    @Override
    public XscResponse supplierOrderReportDownloadPdf(JSONObject payload) throws IOException {
        XscResponse response = new XscResponse();

        List<TbSupplierInvoice> tbSupplierInvoiceList = new ArrayList<>();

        for (int i = 0; i < payload.getJSONArray("CLIENT_SUPP_INV_ID").length(); i++) {
            int tb_supplier_invoice = payload.getJSONArray("CLIENT_SUPP_INV_ID").getInt(i);
            tbSupplierInvoiceList.add(
                    tbSupplierInvoiceRepository.findById(tb_supplier_invoice).orElseThrow());
        }

        List<TbSupplierPi> tbSupplierPiList = new ArrayList<>();

        for (TbSupplierInvoice tbSupplierInvoice : tbSupplierInvoiceList) {
            tbSupplierPiList.add(
                    tbSupplierPiRepository
                            .findById(tbSupplierInvoice.getSUPP_PI_ID())
                            .orElseThrow());
        }

        List<TbSupplierQuotation> tbSupplierQuotationList = new ArrayList<>();

        for (TbSupplierPi tbSupplierPi : tbSupplierPiList) {
            tbSupplierQuotationList.add(
                    tbSupplierQuotationRepository
                            .findById(tbSupplierPi.getSUPP_QUOT_ID())
                            .orElseThrow());
        }

        List<TbSupplierPo> tbSupplierPoList = new ArrayList<>();

        for (TbSupplierQuotation tbSupplierQuotation : tbSupplierQuotationList) {
            tbSupplierPoList.add(
                    tbSupplierPoRepository
                            .findById(tbSupplierQuotation.getSUPP_PO_ID())
                            .orElseThrow());
        }

        List<TbClientSupplier> tbClientSupplierList = new ArrayList<>();

        List<Integer> tbClientSupplierIdList = new ArrayList<>();

        for (TbSupplierPo tbSupplierPo : tbSupplierPoList) {
            if (!tbClientSupplierIdList.contains(tbSupplierPo.getCLIENT_SUPPLIER_ID())) {
                tbClientSupplierList.add(
                        tbClientSupplierRepository
                                .findById(tbSupplierPo.getCLIENT_SUPPLIER_ID())
                                .orElseThrow());
                tbClientSupplierIdList.add(tbSupplierPo.getCLIENT_SUPPLIER_ID());
            }
        }

        List<TbCompany> tbCompanyList = new ArrayList<>();

        for (TbClientSupplier tbClientSupplier : tbClientSupplierList) {
            tbCompanyList.add(
                    tbCompanyRepository.findById(tbClientSupplier.getCOMPANY_ID()).orElseThrow());
        }

        List<TbCompanyAddr> tbCompanyAddrList = new ArrayList<>();

        for (TbCompany tbCompany : tbCompanyList) {
            tbCompanyAddrList.add(
                    tbCompanyAddrRepository.findDefaultAddressByCompanyId(tbCompany.getID()));
        }

        List<TbAllAddr> tbAllAddrList = new ArrayList<>();

        for (TbCompanyAddr tbCompanyAddr : tbCompanyAddrList) {
            tbAllAddrList.add(
                    tbAllAddrRepository.findById(tbCompanyAddr.getADDR_ID()).orElseThrow());
        }

        List<TbCity> tbCityList = new ArrayList<>();

        for (TbAllAddr tbAllAddr : tbAllAddrList) {
            tbCityList.add(tbCityRepository.findById(tbAllAddr.getCITY_ID()).orElseThrow());
        }

        Path tempDirectory = Files.createTempDirectory("tempFolder");
        Path tempFile = Files.createTempFile(tempDirectory, "pdfFile", ".pdf");

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            PDTrueTypeFont arialBoldFont =
                    PDTrueTypeFont.loadTTF(
                            document, new File("D:\\Manex\\ManexBackend\\arial\\ARIALBD.TTF"));

            PDTrueTypeFont arialFont =
                    PDTrueTypeFont.loadTTF(
                            document, new File("D:\\Manex\\ManexBackend\\arial\\ARIAL.TTF"));

            File imageFile = new File("D:\\Manex\\manex-fe\\src\\assets\\Manex Logo.png");
            PDImageXObject pdImageXObject =
                    PDImageXObject.createFromFileByContent(imageFile, document);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                float pageWidth = page.getMediaBox().getWidth();
                contentStream.drawImage(pdImageXObject, (pageWidth - 215) / 2, 635.5F, 215, 115);

                // Heading
                contentStream.beginText();
                contentStream.setFont(arialBoldFont, 25);
                String text = "MANEX EXPORTS (H.K.) LTD.";
                float titleWidth = arialBoldFont.getStringWidth(text) / 1000 * 25;
                float xPosition = (pageWidth - titleWidth) / 2;
                contentStream.newLineAtOffset(xPosition, 637);
                contentStream.showText(text);
                contentStream.endText();

                // Date
                contentStream.beginText();
                contentStream.setFont(arialFont, 12);
                LocalDate localDate = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                String date = "DATE: " + localDate.format(formatter);
                float dateWidth = arialFont.getStringWidth(date) / 1000 * 12;
                xPosition = (pageWidth - dateWidth) / 2;
                contentStream.newLineAtOffset(xPosition, 619.5F);
                contentStream.showText(date);
                contentStream.endText();

                // Report Heading
                contentStream.beginText();
                contentStream.setFont(arialBoldFont, 18);
                text = "Suppliers Report";
                float textWidth = arialBoldFont.getStringWidth(text) / 1000 * 18;
                xPosition = (pageWidth - textWidth) / 2;
                contentStream.newLineAtOffset(xPosition, 589.5F);
                contentStream.showText(text);
                contentStream.endText();

                // Report
                contentStream.setStrokingColor(Color.DARK_GRAY);
                contentStream.setLineWidth(1);
                float cellWidth = 97.5F;
                int colCount = tbCompanyList.size() + 1;
                int rowCount = 5;

                int initX = (int) ((pageWidth - (cellWidth * rowCount)) / 2);
                float initY = 567.5F;

                for (int i = 0; i < colCount; i++) {
                    float cellHeight = (i == 0) ? 27.5F : 17.5F;

                    for (int j = 0; j < rowCount; j++) {
                        if (i == 0) {
                            contentStream.setNonStrokingColor(Color.decode("#635bff"));
                            contentStream.addRect(initX, initY, cellWidth, -cellHeight);
                            contentStream.fill();
                        }

                        contentStream.setStrokingColor(Color.DARK_GRAY);
                        contentStream.addRect(initX, initY, cellWidth, -cellHeight);
                        contentStream.stroke();

                        contentStream.beginText();

                        if (i == 0) {
                            if (j == 0) text = "SUPPLIER NUM";
                            else if (j == 1) text = "SUPPLIER NAME";
                            else if (j == 2) text = "EMAIL";
                            else if (j == 3) text = "PHONE NUMBER";
                            else text = "LOCATION";
                            textWidth = arialBoldFont.getStringWidth(text) / 1000 * 10;
                            contentStream.setNonStrokingColor(Color.WHITE);
                            contentStream.newLineAtOffset(
                                    initX + ((cellWidth - textWidth) / 2), initY - 13);
                            contentStream.setFont(arialBoldFont, 10);
                        } else {
                            if (j == 0) text = tbCompanyList.get(i - 1).getREG_NUMBER();
                            else if (j == 1) text = tbCompanyList.get(i - 1).getNAME();
                            else if (j == 2) text = tbCompanyList.get(i - 1).getEMAIL();
                            else if (j == 3) text = tbCompanyList.get(i - 1).getCONTACT_NUMBER();
                            else text = tbCityList.get(i - 1).getCITY();
                            textWidth = arialFont.getStringWidth(text) / 1000 * 10;
                            contentStream.setNonStrokingColor(Color.BLACK);
                            contentStream.newLineAtOffset(
                                    initX + ((cellWidth - textWidth) / 2), initY - 12.5F);
                            contentStream.setFont(arialFont, 10);
                        }
                        contentStream.showText(text);
                        contentStream.endText();

                        initX += (int) cellWidth;
                    }

                    initX = (int) ((pageWidth - (cellWidth * rowCount)) / 2);
                    initY -= cellHeight;
                }
            }
            document.save(tempFile.toFile());
        }

        String fileId = tempFile.getFileName().toString();
        tempFilesMap.put(fileId, tempFile);

        JsonObject data = new JsonObject();
        data.addProperty("URL", "downloadPdfReports?fileId=" + fileId);
        response.setXscData(GenericMethods.convertGsonToJackson(data));
        response.setXscMessage("Download pdf");
        response.setXscStatus(1);
        return response;
    }

    @Override
    public XscResponse supplierOrderReportDownloadExcel(JSONObject payload) throws IOException {
        XscResponse response = new XscResponse();

        int fav_supplier = 0, reg_supplier = 0;
        List<TbSupplierInvoice> tbSupplierInvoiceList = new ArrayList<>();

        for (int i = 0; i < payload.getJSONArray("CLIENT_SUPP_INV_ID").length(); i++) {
            int tb_supplier_invoice = payload.getJSONArray("CLIENT_SUPP_INV_ID").getInt(i);
            tbSupplierInvoiceList.add(
                    tbSupplierInvoiceRepository.findById(tb_supplier_invoice).orElseThrow());
        }

        List<TbSupplierPi> tbSupplierPiList = new ArrayList<>();

        for (TbSupplierInvoice tbSupplierInvoice : tbSupplierInvoiceList) {
            tbSupplierPiList.add(
                    tbSupplierPiRepository
                            .findById(tbSupplierInvoice.getSUPP_PI_ID())
                            .orElseThrow());
        }

        List<TbSupplierQuotation> tbSupplierQuotationList = new ArrayList<>();

        for (TbSupplierPi tbSupplierPi : tbSupplierPiList) {
            tbSupplierQuotationList.add(
                    tbSupplierQuotationRepository
                            .findById(tbSupplierPi.getSUPP_QUOT_ID())
                            .orElseThrow());
        }

        List<TbSupplierPo> tbSupplierPoList = new ArrayList<>();

        for (TbSupplierQuotation tbSupplierQuotation : tbSupplierQuotationList) {
            tbSupplierPoList.add(
                    tbSupplierPoRepository
                            .findById(tbSupplierQuotation.getSUPP_PO_ID())
                            .orElseThrow());
        }

        List<TbClientSupplier> tbClientSupplierList = new ArrayList<>();

        List<Integer> tbClientSupplierIdList = new ArrayList<>();

        for (TbSupplierPo tbSupplierPo : tbSupplierPoList) {
            if (!tbClientSupplierIdList.contains(tbSupplierPo.getCLIENT_SUPPLIER_ID())) {
                tbClientSupplierList.add(
                        tbClientSupplierRepository
                                .findById(tbSupplierPo.getCLIENT_SUPPLIER_ID())
                                .orElseThrow());
                tbClientSupplierIdList.add(tbSupplierPo.getCLIENT_SUPPLIER_ID());
            }
        }

        List<TbCompany> tbCompanyList = new ArrayList<>();

        for (TbClientSupplier tbClientSupplier : tbClientSupplierList) {
            tbCompanyList.add(
                    tbCompanyRepository.findById(tbClientSupplier.getCOMPANY_ID()).orElseThrow());
            if (tbClientSupplier.getIS_SUPP_FAV() == 'Y') {
                fav_supplier++;
            } else {
                reg_supplier++;
            }
        }

        List<TbCompanyAddr> tbCompanyAddrList = new ArrayList<>();

        for (TbCompany tbCompany : tbCompanyList) {
            tbCompanyAddrList.add(
                    tbCompanyAddrRepository.findDefaultAddressByCompanyId(tbCompany.getID()));
        }

        List<TbAllAddr> tbAllAddrList = new ArrayList<>();

        for (TbCompanyAddr tbCompanyAddr : tbCompanyAddrList) {
            tbAllAddrList.add(
                    tbAllAddrRepository.findById(tbCompanyAddr.getADDR_ID()).orElseThrow());
        }

        List<TbCity> tbCityList = new ArrayList<>();

        for (TbAllAddr tbAllAddr : tbAllAddrList) {
            tbCityList.add(tbCityRepository.findById(tbAllAddr.getCITY_ID()).orElseThrow());
        }

        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");
        sheet.setDefaultRowHeightInPoints(36);

        sheet.addMergedRegion(new CellRangeAddress(0, 3, 0, 3));
        sheet.addMergedRegion(new CellRangeAddress(1, 2, 4, 6));
        sheet.addMergedRegion(new CellRangeAddress(6, 6, 0, 1));
        sheet.addMergedRegion(new CellRangeAddress(6, 6, 2, 3));
        sheet.addMergedRegion(new CellRangeAddress(6, 6, 4, 5));
        sheet.addMergedRegion(new CellRangeAddress(7, 7, 0, 1));
        sheet.addMergedRegion(new CellRangeAddress(7, 7, 2, 3));
        sheet.addMergedRegion(new CellRangeAddress(7, 7, 4, 5));

        XSSFFont headerFont = workbook.createFont();
        headerFont.setFontName("Inter");
        headerFont.setColor(new XSSFColor(Color.WHITE, null));
        headerFont.setFontHeight(12);
        headerFont.setBold(true);

        XSSFColor backgroundColor = new XSSFColor(new Color(99, 91, 255), null);

        XSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        headerStyle.setAlignment(HorizontalAlignment.LEFT);
        headerStyle.setFillForegroundColor(backgroundColor);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStyle.setBorderTop(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setIndention((short) 1);

        Row headerRow = sheet.createRow(9);
        headerRow.setHeightInPoints(36);

        Row row0 = sheet.createRow(0);
        row0.setHeightInPoints(13.5F);

        Row row1 = sheet.createRow(1);
        row1.setHeightInPoints(36);
        Row row3 = sheet.createRow(3);
        row3.setHeightInPoints(13.5F);

        Row row4 = sheet.createRow(4);
        row4.setHeightInPoints(0);

        Row row6 = sheet.createRow(6);
        row6.setHeightInPoints(36);

        Row row7 = sheet.createRow(7);
        row7.setHeightInPoints(36);

        Row row8 = sheet.createRow(11);
        row8.setHeightInPoints(13.5F);

        String[] headers =
                new String[] {
                    "Supplier ID", "Supplier Type", "Supplier Name", "Email", "Phone Number",
                    "Website", "Registration No", "Country", "Address Line 1", "Address Line 2",
                    "State/Province", "City", "ZIP/Postal Code", "Tax No", "Fax No"
                };

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }

        for (int i = 0; i < headers.length + 1; i++) {
            sheet.setColumnWidth(i, 22 * 256);
        }

        InputStream is = new FileInputStream("D:\\Manex\\ManexBackend\\assets\\Logo.png");
        byte[] bytes = IOUtils.toByteArray(is);
        int pictureIndex = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
        is.close();

        Drawing<?> drawing = sheet.createDrawingPatriarch();

        ClientAnchor anchor = workbook.getCreationHelper().createClientAnchor();
        anchor.setCol1(0); // Starting column for the image
        anchor.setRow1(0); // Starting row for the image
        anchor.setCol2(3); // Ending column for the image
        anchor.setRow2(3); // Ending row for the image

        Picture picture = drawing.createPicture(anchor, pictureIndex);
        picture.resize();

        XSSFFont row1Font = workbook.createFont();
        row1Font.setFontName("Inter");
        row1Font.setFontHeight(22);
        row1Font.setBold(true);

        Cell cell1 = row1.createCell(4);
        cell1.setCellValue("Supplier Report");
        CellStyle cellStyle1 = workbook.createCellStyle();
        cellStyle1.setFont(row1Font);
        cellStyle1.setAlignment(HorizontalAlignment.RIGHT);
        cellStyle1.setVerticalAlignment(VerticalAlignment.CENTER);
        cell1.setCellStyle(cellStyle1);

        XSSFFont row3Font = workbook.createFont();
        row3Font.setFontName("Inter");
        row3Font.setFontHeight(12);
        row3Font.setBold(true);

        Cell cell2 = row3.createCell(5);
        cell2.setCellValue("Date:");
        CellStyle cellStyle2 = workbook.createCellStyle();
        cellStyle2.setFont(row3Font);
        cellStyle2.setAlignment(HorizontalAlignment.RIGHT);
        cellStyle2.setVerticalAlignment(VerticalAlignment.CENTER);
        cell2.setCellStyle(cellStyle2);

        XSSFFont row4Font = workbook.createFont();
        row4Font.setFontName("Inter");
        row4Font.setFontHeight(12);
        row4Font.setColor(new XSSFColor(new Color(128, 128, 128), null));

        Cell cell3 = row3.createCell(6);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        cell3.setCellValue(LocalDate.now().format(formatter));
        XSSFCellStyle cellStyle3 = workbook.createCellStyle();
        cellStyle3.setFont(row4Font);
        cellStyle3.setAlignment(HorizontalAlignment.LEFT);
        cellStyle3.setVerticalAlignment(VerticalAlignment.CENTER);
        cell3.setCellStyle(cellStyle3);

        XSSFCellStyle cellStyle4 = workbook.createCellStyle();
        cellStyle4.setFont(row3Font);
        cellStyle4.setAlignment(HorizontalAlignment.LEFT);
        cellStyle4.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle4.setIndention((short) 1);

        Cell cell4 = row6.createCell(0);
        cell4.setCellValue("Total Supplier");
        cell4.setCellStyle(cellStyle4);

        Cell cell5 = row6.createCell(2);
        cell5.setCellValue("Regular Supplier");
        cell5.setCellStyle(cellStyle4);

        Cell cell6 = row6.createCell(4);
        cell6.setCellValue("Favourite Supplier");
        cell6.setCellStyle(cellStyle4);

        XSSFFont row5Font = workbook.createFont();
        row5Font.setFontName("Inter");
        row5Font.setFontHeight(12);

        XSSFCellStyle cellStyle5 = workbook.createCellStyle();
        cellStyle5.setFont(row5Font);
        cellStyle5.setAlignment(HorizontalAlignment.LEFT);
        cellStyle5.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle5.setIndention((short) 1);

        Cell cell7 = row7.createCell(0);
        cell7.setCellValue(tbClientSupplierList.size());
        cell7.setCellStyle(cellStyle5);

        Cell cell8 = row7.createCell(2);
        cell8.setCellValue(fav_supplier);
        cell8.setCellStyle(cellStyle5);

        Cell cell9 = row7.createCell(4);
        cell9.setCellValue(reg_supplier);
        cell9.setCellStyle(cellStyle5);

        XSSFFont valuesFont = workbook.createFont();
        valuesFont.setFontName("Inter");
        valuesFont.setFontHeight(12);

        XSSFCellStyle valuesStyle = workbook.createCellStyle();
        valuesStyle.setFont(valuesFont);
        valuesStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        valuesStyle.setAlignment(HorizontalAlignment.CENTER);
        valuesStyle.setBorderTop(BorderStyle.THIN);
        valuesStyle.setBorderRight(BorderStyle.THIN);
        valuesStyle.setBorderBottom(BorderStyle.THIN);
        valuesStyle.setBorderLeft(BorderStyle.THIN);

        for (int i = 0; i < tbCompanyList.size(); i++) {
            Row valuesRow = sheet.createRow(10 + i);
            valuesRow.setHeightInPoints(36);

            Cell cell = valuesRow.createCell(0);
            cell.setCellValue(tbClientSupplierList.get(i).getSUPP_NUM());
            cell.setCellStyle(valuesStyle);

            cell = valuesRow.createCell(1);
            cell.setCellValue(tbClientSupplierList.get(i).getIS_SUPP_FAV());
            cell.setCellStyle(valuesStyle);

            cell = valuesRow.createCell(2);
            cell.setCellValue(tbCompanyList.get(i).getNAME());
            cell.setCellStyle(valuesStyle);

            cell = valuesRow.createCell(3);
            cell.setCellValue(tbCompanyList.get(i).getEMAIL());
            cell.setCellStyle(valuesStyle);

            cell = valuesRow.createCell(4);
            cell.setCellValue(tbCompanyList.get(i).getCONTACT_NUMBER());
            cell.setCellStyle(valuesStyle);

            cell = valuesRow.createCell(5);
            cell.setCellValue(tbCompanyList.get(i).getWEBSITE());
            cell.setCellStyle(valuesStyle);

            cell = valuesRow.createCell(6);
            cell.setCellValue(tbCompanyList.get(i).getREG_NUMBER());
            cell.setCellStyle(valuesStyle);

            cell = valuesRow.createCell(7);
            cell.setCellValue(
                    tbCountryRepository
                            .findById(tbAllAddrList.get(i).getCOUNTRY_ID())
                            .orElseThrow()
                            .getCOUNTRY());
            cell.setCellStyle(valuesStyle);

            cell = valuesRow.createCell(8);
            cell.setCellValue(tbAllAddrList.get(i).getADDR_1());
            cell.setCellStyle(valuesStyle);

            cell = valuesRow.createCell(9);
            cell.setCellValue(tbAllAddrList.get(i).getADDR_2());
            cell.setCellStyle(valuesStyle);

            cell = valuesRow.createCell(10);
            cell.setCellValue(
                    tbStateRepository
                            .findById(tbAllAddrList.get(0).getSTATE_ID())
                            .orElseThrow()
                            .getSTATE());
            cell.setCellStyle(valuesStyle);

            cell = valuesRow.createCell(11);
            cell.setCellValue(
                    tbCityRepository
                            .findById(tbAllAddrList.get(0).getCITY_ID())
                            .orElseThrow()
                            .getCITY());
            cell.setCellStyle(valuesStyle);

            cell = valuesRow.createCell(12);
            cell.setCellValue(tbAllAddrList.get(i).getPOSTAL_CODE());
            cell.setCellStyle(valuesStyle);

            cell = valuesRow.createCell(13);
            cell.setCellValue(tbCompanyList.get(i).getTAX_NUMBER());
            cell.setCellStyle(valuesStyle);

            cell = valuesRow.createCell(14);
            cell.setCellValue(tbCompanyList.get(i).getFAX());
            cell.setCellStyle(valuesStyle);
        }

        Path tempDirectory = Files.createTempDirectory("tempFolder");
        Path tempFile = Files.createTempFile(tempDirectory, "supplier_order_report_", ".xlsx");

        try (FileOutputStream fileOut = new FileOutputStream(tempFile.toFile())) {
            workbook.write(fileOut);
        } finally {
            workbook.close();
        }

        String fileId = tempFile.getFileName().toString();
        tempFilesMap.put(fileId, tempFile);

        JsonObject data = new JsonObject();
        data.addProperty("URL", "downloadExcelReports?fileId=" + fileId);
        response.setXscData(GenericMethods.convertGsonToJackson(data));
        response.setXscStatus(1);
        response.setXscMessage("File created at: " + tempFile);
        return response;
    }

    @Override
    public ResponseEntity<byte[]> downloadPdfReports(String fileId) throws IOException {
        Path tempFile = tempFilesMap.get(fileId);
        if (tempFile == null || !Files.exists(tempFile)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        byte[] fileContent = Files.readAllBytes(tempFile);

        HttpHeaders headers = new HttpHeaders();
        headers.add(
                HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=" + tempFile.getFileName().toString());
        headers.add(HttpHeaders.CONTENT_TYPE, "application/pdf");

        ResponseEntity<byte[]> responseEntity =
                new ResponseEntity<>(fileContent, headers, HttpStatus.OK);

        Files.delete(tempFile);
        Files.deleteIfExists(tempFile.getParent());
        tempFilesMap.remove(fileId);

        return responseEntity;
    }

    @Override
    public ResponseEntity<byte[]> downloadExcelReports(String fileId) throws IOException {
        Path tempFile = tempFilesMap.get(fileId);
        if (tempFile == null || !Files.exists(tempFile)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        byte[] fileContent = Files.readAllBytes(tempFile);

        HttpHeaders headers = new HttpHeaders();
        headers.add(
                HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=" + tempFile.getFileName().toString());

        ResponseEntity<byte[]> responseEntity =
                new ResponseEntity<>(fileContent, headers, HttpStatus.OK);

        Files.delete(tempFile);
        Files.deleteIfExists(tempFile.getParent());
        tempFilesMap.remove(fileId);

        return responseEntity;
    }
}
