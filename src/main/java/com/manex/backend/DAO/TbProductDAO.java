package com.manex.backend.DAO;

import com.manex.backend.response.XscResponse;

import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public interface TbProductDAO {
    XscResponse getProductsList(JSONObject payload);

    XscResponse addProduct(MultipartFile[] file, JSONObject payload) throws IOException;

    XscResponse getProductsDetails(String clientSupplierId, String productId);

    InputStream getImageResource(String imageName) throws FileNotFoundException;

    XscResponse productPriceFilter(String appClientId);

    XscResponse productStatusFilter(String appClientId);
}
