package com.manex.backend.DAO;

import com.manex.backend.response.XscResponse;

import jakarta.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface SupplierDAO {
    XscResponse addSupplier(HttpServletRequest request, JSONObject payload) throws IOException;

    XscResponse listSupplier(JSONObject payload);

    XscResponse getSupplierDetails(String clientSupplierId);

    XscResponse updateSupplier(JSONObject payload);

    XscResponse supplierNameFilter(
            String appClientId, String searchKeyword, int currentPage, int itemPerPage);

    XscResponse supplierTypeFilter(String appClientId);

    XscResponse supplierStatusFilter(String appClientId);

    XscResponse markSupplierFavourite(String clientSuppId, String isFavourite);

    XscResponse addAllSuppliers(int appClientId, JSONArray list);

    XscResponse getReports(JSONObject payload);

    XscResponse supplierOrderReportDownloadPdf(JSONObject payload) throws IOException;

    ResponseEntity<byte[]> downloadPdfReports(String fileId) throws IOException;

    XscResponse supplierOrderReportDownloadExcel(JSONObject payload) throws IOException;

    ResponseEntity<byte[]> downloadExcelReports(String fileId) throws IOException;
}
