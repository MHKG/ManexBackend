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

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SupplierService implements SupplierDAO {

    @Autowired private TbMmDAO tbMmDAO;

    @Autowired private TbCompanyRepository tbCompanyRepository;

    @Autowired private TbAllAddrRepository tbAllAddrRepository;

    @Autowired private TbCompanyAddrRepository tbCompanyAddrRepository;

    @Autowired private TbClientSupplierRepository tbClientSupplierRepository;

    @Autowired private TbProductsRepository tbProductsRepository;

    @Autowired private TbCountryRepository tbCountryRepository;

    @Autowired private TbStateRepository tbStateRepository;

    @Autowired private TbCityRepository tbCityRepository;

    @Autowired private TbClientCustRepository tbClientCustRepository;

    @Autowired private TbMmRepository tbMmRepository;

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
    public XscResponse listSupplier(
            String APP_CLIENT_ID,
            String CURRENT_PAGE,
            String ITEM_PER_PAGE,
            String SEARCH_KEYWORD) {
        int favourite_suppliers = 0;
        int regular_suppliers = 0;

        XscResponse response = new XscResponse();

        JsonObject responseObject = new JsonObject();

        List<TbClientSupplier> tbClientSupplierList =
                tbClientSupplierRepository.findAllByAppClientIdAndSearchKeyword(
                        APP_CLIENT_ID, SEARCH_KEYWORD);

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

        List<TbProducts> tbProducts =
                tbProductsRepository.findAllByClientSupplierId(clientSupplierId);

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
        tbAllAddr = tbAllAddrRepository.save(tbAllAddr);

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
}
