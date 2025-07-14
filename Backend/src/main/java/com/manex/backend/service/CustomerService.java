package com.manex.backend.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.manex.backend.DAO.CustomerDAO;
import com.manex.backend.DAO.TbMmDAO;
import com.manex.backend.GenericMethods.GenericMethods;
import com.manex.backend.entities.*;
import com.manex.backend.entities.ClientCustProjection;
import com.manex.backend.repositories.*;
import com.manex.backend.response.XscResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerService implements CustomerDAO {

    @Autowired private TbMmDAO tbMmDAO;

    @Autowired private TbCompanyRepository tbCompanyRepository;

    @Autowired private TbAllAddrRepository tbAllAddrRepository;

    @Autowired private TbCompanyAddrRepository tbCompanyAddrRepository;

    @Autowired private TbCountryRepository tbCountryRepository;

    @Autowired private TbStateRepository tbStateRepository;

    @Autowired private TbDistrictRepository tbDistrictRepository;

    @Autowired private TbCityRepository tbCityRepository;

    @Autowired private TbClientCustRepository tbClientCustRepository;

    @Autowired private TbMmRepository tbMmRepository;

    @Autowired private TbCustomerPoRepository tbCustomerPoRepository;

    @Autowired private TbCustPoItemsRepository tbCustPoItemsRepository;

    @Override
    public XscResponse addCustomer(HttpServletRequest request, JSONObject payload)
            throws IOException {
        XscResponse response = new XscResponse();

        MultipartFile file = ((StandardMultipartHttpServletRequest) request).getFile("file");

        TbMm tbMm = new TbMm();
        if (file != null) {
            tbMm =
                    tbMmDAO.saveImageFileWithName(
                            "customerImages", file, payload.get("NAME").toString(), null);
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
        tbAllAddr.setCOUNTRY_ID(Integer.valueOf(payload.getString("COUNTRY_ID")));
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

        // TbClientCust
        TbClientCust tbClientCust = new TbClientCust();
        tbClientCust.setCOMPANY_ID(company.getID());
        tbClientCust.setAPP_CLIENT_ID(Integer.valueOf(payload.get("APP_CLIENT_ID").toString()));
        tbClientCust.setIS_CUST_FAV(payload.get("IS_SUPP_FAV").toString().charAt(0));
        tbClientCust.setSTATUS(1);
        tbClientCust.setCUST_NUM("Cust12");
        tbClientCust = tbClientCustRepository.save(tbClientCust);

        JsonObject data = new JsonObject();

        data.addProperty("CLIENT_CUSTOMER_ID", tbClientCust.getID());
        data.addProperty("COMPANY_ID", company.getID());

        JsonNode jsonNode = GenericMethods.convertGsonToJackson(data);
        response.setXscData(jsonNode);
        response.setXscMessage("Customer Added Successfully");
        response.setXscStatus(1);

        return response;
    }

    @Override
    public XscResponse listCustomer(JSONObject payload) {
        int favourite_customers = 0;
        int regular_customers = 0;
        int currentPage = payload.optInt("CURRENT_PAGE", 1);
        int nextPage;
        int itemPerPage = payload.optInt("ITEM_PER_PAGE", 10);
        String search_keyword = payload.optString("SEARCH_KEYWORD", "");

        XscResponse response = new XscResponse();

        JsonObject responseObject = new JsonObject();

        List<ClientCustProjection> clientCustProjectionList =
                tbClientCustRepository.findAllByAppClientIdAndSearchKeyword(
                        payload.getString("APP_CLIENT_ID"), search_keyword);

        int totalRecords = clientCustProjectionList.size();

        int length =
                clientCustProjectionList.size() > currentPage * itemPerPage
                        ? itemPerPage
                        : clientCustProjectionList.size() - ((currentPage - 1) * itemPerPage);

        List<ClientCustProjection> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(clientCustProjectionList.get(i + (currentPage - 1) * itemPerPage));
        }
        if (length == itemPerPage) {
            nextPage = currentPage + 1;
        } else {
            nextPage = -1;
        }

        clientCustProjectionList = list;

        List<TbCompany> tbCompanyList = new ArrayList<>();
        for (ClientCustProjection clientCustProjection : clientCustProjectionList) {
            TbClientCust tbClientCust = clientCustProjection.getTbClientCust();

            tbCompanyList.add(
                    tbCompanyRepository.findById(tbClientCust.getCOMPANY_ID()).orElseThrow());

            if (tbClientCust.getIS_CUST_FAV() == 'Y') {
                favourite_customers++;
            } else {
                regular_customers++;
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
            data.addProperty("CUSTOMER_NAME", tbCompanyList.get(i).getNAME());
            data.addProperty(
                    "CLIENT_CUST_ID", clientCustProjectionList.get(i).getTbClientCust().getID());
            data.addProperty(
                    "CUST_NUM", clientCustProjectionList.get(i).getTbClientCust().getCUST_NUM());
            data.addProperty(
                    "IS_CUST_FAV",
                    clientCustProjectionList.get(i).getTbClientCust().getIS_CUST_FAV());
            data.addProperty("LOCATION", tbCountryList.get(i).getCOUNTRY());
            arrayList.add(data);
        }

        responseObject.add("CUSTOMER_LIST", arrayList);
        responseObject.addProperty("FAVOURITE_CUSTOMER", favourite_customers);
        responseObject.addProperty("REGULAR_CUSTOMER", regular_customers);
        responseObject.addProperty("TOTAL_CUSTOMERS", totalRecords);
        responseObject.addProperty("NEXT_PAGE", nextPage);
        responseObject.addProperty("TOTAL_RECORDS", totalRecords);

        response.setXscData(GenericMethods.convertGsonToJackson(responseObject));
        response.setXscMessage("Customer records fetched successfully !!!");
        response.setXscStatus(1);
        return response;
    }

    @Override
    public XscResponse getCustomerDetails(String clientCustomerId) {
        XscResponse response = new XscResponse();
        TbClientCust tbClientCustomer =
                tbClientCustRepository.findById(Integer.valueOf(clientCustomerId)).orElseThrow();

        TbCompany tbCompany =
                tbCompanyRepository.findById(tbClientCustomer.getCOMPANY_ID()).orElseThrow();

        TbCompanyAddr tbCompanyAddr =
                tbCompanyAddrRepository.findDefaultAddressByCompanyId(tbCompany.getID());

        TbAllAddr tbAllAddr =
                tbAllAddrRepository.findById(tbCompanyAddr.getADDR_ID()).orElseThrow();

        TbCountry tbCountry = tbCountryRepository.findById(tbAllAddr.getCOUNTRY_ID()).orElseThrow();

        TbState tbState = tbStateRepository.findById(tbAllAddr.getSTATE_ID()).orElseThrow();

        TbDistrict tbDistrict =
                tbDistrictRepository.findById(tbAllAddr.getDISTRICT_ID()).orElseThrow();

        TbCity tbCity = tbCityRepository.findById(tbAllAddr.getCITY_ID()).orElseThrow();

        TbMm tbMm = tbMmRepository.findById(tbCompany.getLOGO()).orElseThrow();

        JsonObject data = new JsonObject();
        JsonObject jsonObject1 = new JsonObject();
        JsonObject jsonObject2 = new JsonObject();
        jsonObject1.addProperty("CREATED_ON", tbCompany.getCREATED_DATE().getTime());
        jsonObject1.addProperty("LOGO", tbMm.getMM_FILE_NAME());
        jsonObject1.addProperty("CUST_NAME", tbCompany.getNAME());
        jsonObject1.addProperty("EMAIL", tbCompany.getEMAIL());
        jsonObject1.addProperty("PHONE_NUMBER", tbCompany.getCONTACT_NUMBER());
        jsonObject1.addProperty("WEBSITE", tbCompany.getWEBSITE());
        jsonObject1.addProperty("REG_NUMBER", tbCompany.getREG_NUMBER());
        jsonObject1.addProperty("ADDR_1", tbAllAddr.getADDR_1());
        jsonObject1.addProperty("COUNTRY", tbCountry.getCOUNTRY());
        jsonObject1.addProperty("STATE", tbState.getSTATE());
        jsonObject1.addProperty("CITY", tbCity.getCITY());
        jsonObject1.addProperty("POSTAL_CODE", tbAllAddr.getPOSTAL_CODE());
        jsonObject1.addProperty("TAX_NUMBER", tbCompany.getTAX_NUMBER());
        jsonObject1.addProperty("FAX", tbCompany.getFAX());
        jsonObject1.addProperty("COUNTRY_ID", tbCountry.getID());
        jsonObject1.addProperty("STATE_ID", tbState.getID());
        jsonObject1.addProperty("DISTRICT_ID", tbDistrict.getID());
        jsonObject1.addProperty("CITY_ID", tbCity.getID());
        jsonObject1.addProperty("ADDR_2", tbAllAddr.getADDR_2());
        jsonObject1.addProperty("IS_SUPP_FAV", tbClientCustomer.getIS_CUST_FAV());
        jsonObject1.addProperty("COMPANY_ID", tbCompany.getID());
        jsonObject1.addProperty("STATUS", tbClientCustomer.getSTATUS());

        jsonObject2.addProperty("TOTAL_OPEN_ORDERS", (String) null);
        jsonObject2.addProperty("TOTAL_TRANSACTION_AMOUNT", (String) null);
        jsonObject2.addProperty("OUTSTANDING_PAYMENT_AMOUNT", (String) null);

        data.add("INFO", jsonObject1);
        data.add("ORDER_AND_PAYMENT_DETAILS", jsonObject2);
        response.setXscData(GenericMethods.convertGsonToJackson(data));
        response.setXscMessage("Customer data fetched.");
        response.setXscStatus(1);
        return response;
    }

    @Override
    public XscResponse updateCustomer(JSONObject payload) {
        XscResponse response = new XscResponse();

        TbClientCust tbClientCust =
                tbClientCustRepository.findById(payload.getInt("CLIENT_CUST_ID")).orElseThrow();
        TbCompany tbCompany =
                tbCompanyRepository.findById(tbClientCust.getCOMPANY_ID()).orElseThrow();

        TbCompanyAddr tbCompanyAddr =
                tbCompanyAddrRepository.findDefaultAddressByCompanyId(tbCompany.getID());
        TbAllAddr tbAllAddr =
                tbAllAddrRepository.findById(tbCompanyAddr.getADDR_ID()).orElseThrow();

        // TbClientCustomer
        tbClientCust.setIS_CUST_FAV(payload.get("IS_SUPP_FAV").toString().charAt(0));
        tbClientCust.setSTATUS(payload.getInt("STATUS"));
        tbClientCust = tbClientCustRepository.save(tbClientCust);

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
        tbAllAddrRepository.save(tbAllAddr);

        JsonObject data = new JsonObject();

        data.addProperty("CLIENT_CUSTOMER_ID", tbClientCust.getID());
        data.addProperty("COMPANY_ID", tbCompany.getID());

        JsonNode jsonNode = GenericMethods.convertGsonToJackson(data);
        response.setXscData(jsonNode);
        response.setXscMessage("Customer Added Successfully");
        response.setXscStatus(1);

        return response;
    }

    @Override
    public XscResponse customerNameFilter(JSONObject payload) {
        XscResponse response = new XscResponse();

        List<ClientCustProjection> clientCustProjectionList =
                tbClientCustRepository.findAllByAppClientIdAndSearchKeyword(
                        payload.getString("APP_CLIENT_ID"), payload.getString("SEARCH_KEYWORD"));

        JsonObject data = new JsonObject();

        JsonArray jsonArray = new JsonArray();
        for (ClientCustProjection clientCustProjection : clientCustProjectionList) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(
                    "CLIENT_CUST_ID", clientCustProjection.getTbClientCust().getID());
            jsonObject.addProperty("CUSTOMERS_NAME", clientCustProjection.getTbCompany().getNAME());
            jsonArray.add(jsonObject);
        }
        data.add("CUSTOMER_LIST", jsonArray);

        response.setXscData(GenericMethods.convertGsonToJackson(data));
        response.setXscMessage("Customer filter name");
        response.setXscStatus(1);
        return response;
    }

    @Override
    public XscResponse customerTypeFilter(String appClientId) {
        XscResponse response = new XscResponse();

        List<ClientCustProjection> clientCustProjectionList =
                tbClientCustRepository.findAllByAppClientIdAndSearchKeyword(appClientId, "");

        JsonObject data = new JsonObject();

        JsonArray jsonArray = new JsonArray();
        for (ClientCustProjection clientCustProjection : clientCustProjectionList) {
            TbClientCust tbClientCust = clientCustProjection.getTbClientCust();

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("IS_FAV", tbClientCust.getIS_CUST_FAV());
            if (tbClientCust.getIS_CUST_FAV() == 'Y') {
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
    public XscResponse customerStatusFilter(String appClientId) {
        XscResponse response = new XscResponse();

        List<ClientCustProjection> clientCustProjectionList =
                tbClientCustRepository.findAllByAppClientIdAndSearchKeyword(appClientId, "");
        JsonObject data = new JsonObject();

        JsonArray jsonArray = new JsonArray();
        for (ClientCustProjection clientCustProjection : clientCustProjectionList) {
            TbClientCust tbClientCust = clientCustProjection.getTbClientCust();

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("STATUS", tbClientCust.getSTATUS());
            if (tbClientCust.getSTATUS() == 1) {
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
    public XscResponse markCustomerFavourite(int clientCustId, String isFavourite) {
        TbClientCust tbClientCustomer = tbClientCustRepository.findById(clientCustId).orElseThrow();
        tbClientCustomer.setIS_CUST_FAV(isFavourite.charAt(0));
        tbClientCustRepository.save(tbClientCustomer);
        return new XscResponse(1, "Customer type updated successfully.");
    }

    @Override
    public XscResponse deleteCustomer(String clientCustId) {
        XscResponse response = new XscResponse();

        TbClientCust tbClientCust =
                tbClientCustRepository.findById(Integer.valueOf(clientCustId)).orElseThrow();

        TbCustomerPo tbCustomerPo = tbCustomerPoRepository.findByClientCustId(tbClientCust.getID());

        tbCustPoItemsRepository.findByCustPoId(tbCustomerPo.getID());

        return response;
    }

    @Override
    public XscResponse addAllCustomers(int appClientId, JSONArray list) {
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

            TbClientCust tbClientCust = new TbClientCust();
            tbClientCust.setCOMPANY_ID(tbCompany.getID());
            tbClientCust.setAPP_CLIENT_ID(appClientId);
            tbClientCust.setIS_CUST_FAV('N');
            tbClientCust.setSTATUS(1);
            tbClientCust.setCUST_NUM("Random");
            tbClientCustRepository.save(tbClientCust);
        }

        response.setXscStatus(1);
        response.setXscMessage("Suppliers added successfully.");
        return response;
    }

    @Override
    public XscResponse getCustomersByNames(JSONObject payload) {
        XscResponse response = new XscResponse();

        List<ClientCustProjection> clientCustProjectionList =
                tbClientCustRepository.findAllByAppClientIdAndSearchKeyword(
                        payload.getString("APP_CLIENT_ID"), payload.getString("SEARCH_KEYWORD"));

        JsonObject data = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        for (ClientCustProjection clientCustProjection : clientCustProjectionList) {
            TbClientCust tbClientCust = clientCustProjection.getTbClientCust();
            TbCompany tbCompany = clientCustProjection.getTbCompany();

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("CLIENT_CUST_ID", tbClientCust.getID());
            jsonObject.addProperty("NAME", tbCompany.getNAME());

            jsonArray.add(jsonObject);
        }

        data.add("CUST_NAME_LIST", jsonArray);

        response.setXscData(GenericMethods.convertGsonToJackson(data));
        response.setXscMessage("Customer name list updated");
        response.setXscStatus(1);
        return response;
    }
}
