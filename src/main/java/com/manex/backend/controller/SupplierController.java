package com.manex.backend.controller;

import com.manex.backend.DAO.SupplierDAO;
import com.manex.backend.response.XscResponse;

import jakarta.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/supplier_controller")
public class SupplierController {

    @Autowired private SupplierDAO supplierDAO;

    @PostMapping("/addSupplier")
    private XscResponse addSupplier(
            @RequestParam("file") MultipartFile file,
            @RequestParam("payload") JSONObject payload,
            HttpServletRequest request)
            throws IOException {
        return supplierDAO.addSupplier(file, payload);
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
    private XscResponse supplierNameFilter(@RequestParam("payload") JSONObject payload) {
        return supplierDAO.supplierNameFilter(
                payload.getString("APP_CLIENT_ID"),
                payload.getString("SEARCH_KEYWORD"),
                payload.getString("CURRENT_PAGE"),
                payload.getString("ITEM_PER_PAGE"));
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

    @PostMapping("/addAllSuppliers")
    private XscResponse addALLSuppliers(@RequestParam("payload") JSONObject payload) {
        return supplierDAO.addAllSuppliers(
                payload.getInt("APP_CLIENT_ID"), payload.getJSONArray("LIST"));
    }

    @PostMapping("/getReports")
    private XscResponse getReports(@RequestParam("payload") JSONObject payload) {
        return supplierDAO.getReports(payload);
    }

    @PostMapping("/supplierOrderReportDownloadPdf")
    private XscResponse supplierOrderReportDownloadPdf(@RequestParam("payload") JSONObject payload)
            throws IOException {
        return supplierDAO.supplierOrderReportDownloadPdf(payload);
    }

    @GetMapping("/downloadPdfReports")
    private ResponseEntity<byte[]> downloadPdfReports(@RequestParam("fileId") String fileId)
            throws IOException {
        return supplierDAO.downloadPdfReports(fileId);
    }
}
