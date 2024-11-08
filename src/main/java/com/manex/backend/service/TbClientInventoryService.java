package com.manex.backend.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.manex.backend.DAO.TbClientInventoryDAO;
import com.manex.backend.GenericMethods.GenericMethods;
import com.manex.backend.entities.TbClientInventory;
import com.manex.backend.entities.TbClientSupplier;
import com.manex.backend.entities.TbProductSpec;
import com.manex.backend.entities.TbProducts;
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
public class TbClientInventoryService implements TbClientInventoryDAO {

    @Autowired private TbClientInventoryRepository tbClientInventoryRepository;

    @Autowired private TbProductsRepository tbProductsRepository;

    @Autowired private TbProductSpecRepository tbProductSpecRepository;

    @Autowired private TbClientSupplierRepository tbClientSupplierRepository;

    @Autowired private TbCompanyRepository tbCompanyRepository;

    @Override
    public XscResponse getInventoryDetails(JSONObject payload) {
        XscResponse response = new XscResponse();
        int currentPage = payload.optInt("CURRENT_PAGE", 1);
        int nextPage = 1;
        int itemPerPage = payload.optInt("ITEM_PER_PAGE", 10);

        List<TbClientInventory> tbClientInventoryList =
                tbClientInventoryRepository.findByAppClientId(payload.getInt("APP_CLIENT_ID"));

        List<TbClientSupplier> tbClientSupplierList =
                tbClientSupplierRepository.findAllByAppClientIdAndSearchKeyword(
                        payload.getString("APP_CLIENT_ID"), payload.getString("SEARCH_KEYWORD"));

        int totalRecords = tbClientSupplierList.size();

        List<TbClientSupplier> list = new ArrayList<>();
        if (totalRecords > (currentPage * itemPerPage)) {
            for (int i = (currentPage - 1) * 10; i < currentPage * 10; i++) {
                list.add(tbClientSupplierList.get(i));
            }
            nextPage = ++currentPage;
        }

        tbClientSupplierList = list;

        int totalStock = 0, toShip = 0, toReceive = 0;
        JsonObject data = new JsonObject();

        List<TbProducts> tbProductsList = new ArrayList<>();
        List<TbProductSpec> tbProductSpecList = new ArrayList<>();

        for (TbClientInventory tbClientInventor : tbClientInventoryList) {
            tbProductsList.add(
                    tbProductsRepository.findById(tbClientInventor.getPRODUCT_ID()).orElseThrow());
            totalStock = totalStock + tbClientInventor.getQTY();
        }
        data.addProperty("TOTAL_STOCK_PRODUCTS", totalStock);
        data.addProperty("TO_SHIP", toShip);
        data.addProperty("TO_RECEIVE", toReceive);

        JsonArray jsonArray = new JsonArray();
        Integer totalInStock = 0;
        int totalToShip = 0;
        int totalToReceive = 0;
        for (int i = 0; i < tbProductsList.size(); i++) {
            JsonObject jsonObject = new JsonObject();

            tbProductSpecList.add(
                    tbProductSpecRepository.findByProductId(tbProductsList.get(i).getID()));
            jsonObject.addProperty("PRODUCT_ID", tbProductsList.get(i).getID());
            jsonObject.addProperty("CLIENT_SUPP_ID", tbProductsList.get(i).getCLIENT_SUPPLIER_ID());
            jsonObject.addProperty("MNX_PRODUCT_NO", "MNX_PRODUCT_NO");
            jsonObject.addProperty("PRODUCT_NAME", tbProductsList.get(i).getNAME());
            jsonObject.addProperty(
                    "SUPPLIER",
                    tbCompanyRepository
                            .findById(tbClientSupplierList.get(0).getCOMPANY_ID())
                            .orElseThrow()
                            .getNAME());
            jsonObject.addProperty("IN_STOCK", tbClientInventoryList.get(i).getQTY());
            jsonObject.addProperty("TO_SHIP", toShip);
            jsonObject.addProperty("TO_RECEIVE", toReceive);
            jsonObject.addProperty("LAST_PRICE", tbProductSpecList.get(i).getPRICE());
            totalInStock += tbClientInventoryList.get(i).getQTY();
            totalToShip += toShip;
            totalToReceive += toReceive;

            jsonArray.add(jsonObject);
        }

        data.add("INVENTORY_LIST", jsonArray);
        data.addProperty("NEXT_PAGE", nextPage);
        data.addProperty("INVENTORY_LIST_COUNT", totalRecords);
        data.addProperty("TOTAL_STOCK_PRODUCTS", totalInStock);
        data.addProperty("TO_RECEIVE", totalToReceive);
        data.addProperty("TO_SHIP", totalToShip);

        response.setXscData(GenericMethods.convertGsonToJackson(data));
        response.setXscMessage("Inventory fetch successful.");
        response.setXscStatus(1);
        return response;
    }

    @Override
    public XscResponse viewPurchaseHistory(JSONObject payload) {
        XscResponse response = new XscResponse();
        return response;
    }
}
