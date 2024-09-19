package com.manex.backend.DAO;

import com.manex.backend.response.XscResponse;

import jakarta.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import java.io.IOException;

public interface SupplierDAO {
    XscResponse addSupplier(HttpServletRequest request, JSONObject payload) throws IOException;

    XscResponse listSupplier(
            String APP_CLIENT_ID, String CURRENT_PAGE, String ITEM_PER_PAGE, String SEARCH_KEYWORD);

    XscResponse getSupplierDetails(String clientSupplierId);

    XscResponse updateSupplier(JSONObject payload);

    XscResponse supplierNameFilter(
            String appClientId, String searchKeyword, String currentPage, String itemPerPage);

    XscResponse supplierTypeFilter(String appClientId);

    XscResponse supplierStatusFilter(String appClientId);

    XscResponse markSupplierFavourite(String clientSuppId, String isFavourite);
}
