package com.manex.backend.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.manex.backend.DAO.TbSupplierPoDAO;
import com.manex.backend.GenericMethods.GenericMethods;
import com.manex.backend.entities.*;
import com.manex.backend.repositories.*;
import com.manex.backend.response.XscResponse;

import jakarta.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TbSupplierPoService implements TbSupplierPoDAO {

    @Autowired private TbSupplierPoRepository tbSupplierPoRepository;

    @Autowired private TbSupplierPoItemsRepository tbSupplierPoItemsRepository;

    @Autowired private TbClientSupplierRepository tbClientSupplierRepository;

    @Autowired private TbCompanyRepository tbCompanyRepository;

    @Autowired private TbCompanyAddrRepository tbCompanyAddrRepository;

    @Autowired private TbAllAddrRepository tbAllAddrRepository;

    @Override
    public XscResponse selectPO(JSONObject payload) {
        int totalItems = 0;
        float totalAmount = 0;
        XscResponse response = new XscResponse();

        List<TbSupplierPo> tbSupplierPoList =
                tbSupplierPoRepository.findAllByAppClientId(payload.getInt("APP_CLIENT_ID"));

        List<TbSupplierPoItems> tbSupplierPoItemsList = new ArrayList<>();

        for (TbSupplierPo tbSupplierPo : tbSupplierPoList) {
            tbSupplierPoItemsList.addAll(
                    tbSupplierPoItemsRepository.findAllBySupplierPoId(tbSupplierPo.getID()));
        }

        for (TbSupplierPoItems tbSupplierPoItems : tbSupplierPoItemsList) {
            totalItems += tbSupplierPoItems.getQTY();
            totalAmount =
                    totalAmount
                            + (tbSupplierPoItems.getQTY() * tbSupplierPoItems.getPRICE_PER_ITEM());
        }

        JsonObject data = new JsonObject();

        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i < tbSupplierPoItemsList.size(); i++) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("ORDER_ID", tbSupplierPoList.get(i).getID());
            jsonObject.addProperty("ORDER_NUM", tbSupplierPoList.get(i).getPO_NUM());
            jsonObject.addProperty("TOTAL_ITEMS", totalItems);
            jsonObject.addProperty("TOTAL_CTNS", tbSupplierPoItemsList.size());
            jsonObject.addProperty("TOTAL_AMOUNT", totalAmount);
            jsonObject.addProperty(
                    "CREATED_ON",
                    String.valueOf(tbSupplierPoList.get(i).getTIMESTAMP()).split(" ")[0]);

            jsonArray.add(jsonObject);
        }

        data.add("PURCHASE_ORDER_DETAILS", jsonArray);

        response.setXscData(GenericMethods.convertGsonToJackson(data));
        response.setXscMessage("Purchase order details fetched successfully");
        response.setXscStatus(1);
        return response;
    }

    @Override
    public XscResponse getClientSupplierDetails(JSONObject payload) {
        XscResponse response = new XscResponse();

        TbClientSupplier tbClientSupplier =
                tbClientSupplierRepository.findById(payload.getInt("CLIENT_SUPP_ID")).orElseThrow();
        JsonObject data = new JsonObject();

        response.setXscData(GenericMethods.convertGsonToJackson(data));
        response.setXscMessage("Client supplier details fetched successfully");
        response.setXscStatus(1);
        return response;
    }

    @Override
    public XscResponse getSupplierPo(JSONObject payload) {
        XscResponse response = new XscResponse();

        List<TbSupplierPoItems> tbSupplierPoItemsList =
                tbSupplierPoItemsRepository.findAllBySupplierPoId(payload.getInt("SUPP_PO_ID"));

        TbClientSupplier tbClientSupplier =
                tbClientSupplierRepository.findById(payload.getInt("CLIENT_SUPP_ID")).orElseThrow();

        TbCompany tbCompany =
                tbCompanyRepository.findById(tbClientSupplier.getCOMPANY_ID()).orElseThrow();

        TbCompanyAddr tbCompanyAddr =
                tbCompanyAddrRepository.findDefaultAddressByCompanyId(tbCompany.getID());

        TbAllAddr tbAllAddr =
                tbAllAddrRepository.findById(tbCompanyAddr.getADDR_ID()).orElseThrow();

        JsonObject data = new JsonObject();

        JsonArray jsonArray = new JsonArray();
        for (TbSupplierPoItems tbSupplierPoItems : tbSupplierPoItemsList) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("PRICE", tbSupplierPoItems.getPRICE_PER_ITEM());
            jsonObject.addProperty("TOTAL_QTY", tbSupplierPoItems.getQTY());
            jsonObject.addProperty("DESCRIPTION", tbSupplierPoItems.getDESCRIPTION());
            jsonObject.addProperty("PRODUCT_ID", tbSupplierPoItems.getPRODUCT_ID());
            jsonObject.addProperty("SUPP_ITEM_NUM", (String) null);
            jsonObject.addProperty("CLIENT_ITEM_NUM", (String) null);

            jsonArray.add(jsonObject);
        }

        JsonArray jsonArray1 = new JsonArray();

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("NAME", tbCompany.getNAME());
        jsonObject.addProperty("CONTACT_NUMBER", tbCompany.getCONTACT_NUMBER());
        jsonObject.addProperty("FAX", tbCompany.getFAX());
        jsonObject.addProperty("ADDR_1", tbAllAddr.getADDR_1());
        jsonObject.addProperty("ADDR_2", tbAllAddr.getADDR_2());

        jsonArray1.add(jsonObject);

        data.add("PO_DETAILS", jsonArray);
        data.add("SUPP_DATA", jsonArray1);
        response.setXscData(GenericMethods.convertGsonToJackson(data));
        response.setXscMessage("Data fetched successfully.");
        response.setXscStatus(1);
        return response;
    }

    @Override
    public XscResponse listSupplierPo(JSONObject payload) {
        XscResponse response = new XscResponse();

        List<TbSupplierPo> tbSupplierPoList =
                tbSupplierPoRepository.findAllByClientSupplierId(
                        payload.getString("CLIENT_SUPPLIER_ID"));

        JsonObject data = new JsonObject();

        JsonArray jsonArray = new JsonArray();
        for (TbSupplierPo tbSupplierPo : tbSupplierPoList) {
            JsonObject jsonObject = new JsonObject();

            jsonObject.addProperty("PO_ID", tbSupplierPo.getID());
            jsonObject.addProperty("PO_NUM", tbSupplierPo.getPO_NUM());

            jsonArray.add(jsonObject);
        }

        data.add("PO_LIST", jsonArray);

        response.setXscData(GenericMethods.convertGsonToJackson(data));
        response.setXscMessage("Data fetched successfully.");
        response.setXscStatus(1);
        return response;
    }
}
