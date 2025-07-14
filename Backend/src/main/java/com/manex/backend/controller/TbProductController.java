package com.manex.backend.controller;

import com.manex.backend.DAO.TbProductDAO;
import com.manex.backend.response.XscResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/product_controller")
public class TbProductController {

    @Autowired private TbProductDAO tbProductDAO;

    @PostMapping("/addProduct")
    private XscResponse addProduct(
            @RequestParam("files") MultipartFile[] files,
            @RequestParam("payload") JSONObject payload)
            throws IOException {
        return tbProductDAO.addProduct(files, payload);
    }

    @PostMapping("/getProductsList")
    private XscResponse getProductsList(@RequestParam("payload") JSONObject payload) {
        return tbProductDAO.getProductsList(payload);
    }

    @PostMapping("/getProductsDetails")
    private XscResponse getProductsDetails(@RequestParam("payload") JSONObject payload) {
        return tbProductDAO.getProductsDetails(
                payload.getString("CLIENT_SUPPLIER_ID"), payload.getString("PRODUCT_ID"));
    }

    @PostMapping("/productPriceFilter")
    public XscResponse productPriceFilter(@RequestParam("APP_CLIENT_ID") String APP_CLIENT_ID)
            throws IOException {
        return tbProductDAO.productPriceFilter(APP_CLIENT_ID);
    }

    @PostMapping("/productStatusFilter")
    public XscResponse productStatusFilter(@RequestParam("APP_CLIENT_ID") String APP_CLIENT_ID)
            throws IOException {
        return tbProductDAO.productStatusFilter(APP_CLIENT_ID);
    }

    @PostMapping("/updateProduct")
    private XscResponse updateProduct(@RequestParam("payload") JSONObject payload) {
        return tbProductDAO.updateProduct(payload);
    }

    @PostMapping("/removeProductImage")
    private XscResponse removeProductImage(@RequestParam("payload") JSONObject payload)
            throws IOException {
        return tbProductDAO.removeProductImage(payload);
    }

    @PostMapping("/addAllProduct")
    private XscResponse addAllProduct(@RequestParam("payload") JSONObject payload) {
        return tbProductDAO.addAllProduct(
                payload.getInt("CLIENT_SUPP_ID"), payload.getJSONArray("LIST"));
    }
}
