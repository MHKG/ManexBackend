package com.manex.backend.DAO;

import com.manex.backend.response.XscResponse;

import jakarta.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import java.io.IOException;

public interface SupplierDAO {
    XscResponse addSupplier(HttpServletRequest request, JSONObject payload)
            throws IOException;

	XscResponse listSupplier(String APP_CLIENT_ID);

	XscResponse getSupplierDetails(String clientSupplierId);

	XscResponse updateSupplier(JSONObject payload);
}
