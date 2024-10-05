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
    private XscResponse listSupplier(@RequestParam("payload") JSONObject payload) {

        return supplierDAO.listSupplier(payload);
    }

    @PostMapping("/getSupplierDetails")
    private XscResponse getSupplierDetails(@RequestParam("payload") JSONObject payload) {
        return supplierDAO.getSupplierDetails(payload.getString("CLIENT_SUPPLIER_ID"));
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
                payload.get("CURRENT_PAGE").toString(),
                payload.get("ITEM_PER_PAGE").toString());
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
    private XscResponse markSupplierFavourite(@RequestParam("payload") JSONObject payload) {
        return supplierDAO.markSupplierFavourite(
                payload.get("CLIENT_SUPP_ID").toString(), payload.getString("IS_FAVOURITE"));
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

    @PostMapping("/supplierOrderReportDownloadExcel")
    private XscResponse supplierOrderReportDownloadExcel(
            @RequestParam("payload") JSONObject payload) throws IOException {
        return supplierDAO.supplierOrderReportDownloadExcel(payload);
    }

    @GetMapping("/downloadPdfReports")
    private ResponseEntity<byte[]> downloadPdfReports(@RequestParam("fileId") String fileId)
            throws IOException {
        return supplierDAO.downloadPdfReports(fileId);
    }

    @GetMapping("/downloadExcelReports")
    private ResponseEntity<byte[]> downloadExcelReports(@RequestParam("fileId") String fileId)
            throws IOException {
        return supplierDAO.downloadExcelReports(fileId);
    }
}
