package com.manex.backend.DAO;

import com.manex.backend.response.XscResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface TbProductDAO {
    XscResponse getProductsList(JSONObject payload);

    XscResponse addProduct(MultipartFile[] file, JSONObject payload) throws IOException;

    XscResponse getProductsDetails(String clientSupplierId, String productId);

    XscResponse productPriceFilter(String appClientId);

    XscResponse productStatusFilter(String appClientId);

    XscResponse updateProduct(JSONObject payload);

    XscResponse removeProductImage(JSONObject payload) throws IOException;

    XscResponse addAllProduct(int appClientId, JSONArray list);
}
