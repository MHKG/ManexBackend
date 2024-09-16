package com.manex.backend.DAO;

import com.manex.backend.response.XscResponse;

import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface TbProductDAO {
    XscResponse getProductsList(String clientSupplierId, int APP_CLIENT_ID);

    XscResponse addProduct(MultipartFile[] file, JSONObject payload) throws IOException;

	XscResponse getProductsDetails(String clientSupplierId, String productId);
}
