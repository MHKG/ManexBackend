package com.manex.backend.controller;

import com.manex.backend.DAO.SupplierDAO;
import com.manex.backend.response.XscResponse;

import jakarta.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/supplier_controller")
public class SupplierController {

    @Autowired private SupplierDAO supplierDAO;

    @PostMapping("/addSupplier")
    private XscResponse addSupplier(
            HttpServletRequest request, @RequestParam("payload") JSONObject payload)
            throws IOException {
        return supplierDAO.addSupplier(request, payload);
    }

    @PostMapping("/listSupplier")
    private XscResponse listSupplier(
            @RequestParam("APP_CLIENT_ID") String APP_CLIENT_ID,
            @RequestParam("CURRENT_PAGE") String CURRENT_PAGE,
            @RequestParam("ITEM_PER_PAGE") String ITEM_PER_PAGE,
            @RequestParam("SEARCH_KEYWORD") String SEARCH_KEYWORD) {
        return supplierDAO.listSupplier(APP_CLIENT_ID, CURRENT_PAGE, ITEM_PER_PAGE, SEARCH_KEYWORD);
    }

    @PostMapping("/getSupplierDetails")
    private XscResponse getSupplierDetails(
            @RequestParam("CLIENT_SUPPLIER_ID") String CLIENT_SUPPLIER_ID) {
        return supplierDAO.getSupplierDetails(CLIENT_SUPPLIER_ID);
    }

    @PostMapping("/updateSupplier")
    private XscResponse updateSupplier(@RequestParam("payload") JSONObject payload) {
        return supplierDAO.updateSupplier(payload);
    }

    @PostMapping("/supplierNameFilter")
    private XscResponse supplierNameFilter(
            @RequestParam("APP_CLIENT_ID") String APP_CLIENT_ID,
            @RequestParam("SEARCH_KEYWORD") String SEARCH_KEYWORD,
            @RequestParam("CURRENT_PAGE") String CURRENT_PAGE,
            @RequestParam("ITEM_PER_PAGE") String ITEM_PER_PAGE) {
        return supplierDAO.supplierNameFilter(
                APP_CLIENT_ID, SEARCH_KEYWORD, CURRENT_PAGE, ITEM_PER_PAGE);
    }

    @PostMapping("/supplierTypeFilter")
    private XscResponse supplierTypeFilter(@RequestParam("APP_CLIENT_ID") String APP_CLIENT_ID) {
        return supplierDAO.supplierTypeFilter(APP_CLIENT_ID);
    }

    @PostMapping("/supplierStatusFilter")
    private XscResponse supplierStatusFilter(@RequestParam("APP_CLIENT_ID") String APP_CLIENT_ID) {
        return supplierDAO.supplierStatusFilter(APP_CLIENT_ID);
    }

    @PostMapping("/markSupplierFavourite")
    private XscResponse markSupplierFavourite(
            @RequestParam("CLIENT_SUPP_ID") String CLIENT_SUPP_ID,
            @RequestParam("IS_FAVOURITE") String IS_FAVOURITE) {
        return supplierDAO.markSupplierFavourite(CLIENT_SUPP_ID, IS_FAVOURITE);
    }
}
