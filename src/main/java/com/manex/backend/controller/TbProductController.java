package com.manex.backend.controller;

import com.manex.backend.DAO.TbProductDAO;
import com.manex.backend.response.XscResponse;

import jakarta.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

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
    private XscResponse getProductsList(
            @RequestParam("CLIENT_SUPPLIER_ID") String CLIENT_SUPPLIER_ID,
            @RequestParam("CURRENT_PAGE") String CURRENT_PAGE,
            @RequestParam("APP_CLIENT_ID") String APP_CLIENT_ID) {
        return tbProductDAO.getProductsList(CLIENT_SUPPLIER_ID, Integer.parseInt(APP_CLIENT_ID));
    }

    @PostMapping("/getProductsDetails")
    private XscResponse getProductsDetails(
            @RequestParam("CLIENT_SUPPLIER_ID") String CLIENT_SUPPLIER_ID,
            @RequestParam("PRODUCT_ID") String PRODUCT_ID) {
        return tbProductDAO.getProductsDetails(CLIENT_SUPPLIER_ID, PRODUCT_ID);
    }

    @GetMapping(value = "/productImages/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void getImage(@PathVariable("imageName") String imageName, HttpServletResponse response)
            throws IOException {
		InputStream is = tbProductDAO.getImageResource(imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(is, response.getOutputStream());
    }
}
