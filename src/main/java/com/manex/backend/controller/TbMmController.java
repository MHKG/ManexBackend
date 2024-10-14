package com.manex.backend.controller;

import com.manex.backend.DAO.TbMmDAO;
import com.manex.backend.entities.TbCompany;
import com.manex.backend.repositories.TbCompanyRepository;
import com.manex.backend.response.XscResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/tb_mm_controller")
public class TbMmController {

    @Autowired private TbMmDAO tbMmDAO;

    @Autowired private TbCompanyRepository tbCompanyRepository;

    @PostMapping("/updateSupplierImage")
    private XscResponse updateSupplierImage(
            HttpServletRequest request, @RequestParam("payload") JSONObject payload)
            throws IOException {
        MultipartFile file = ((StandardMultipartHttpServletRequest) request).getFile("file");

        if (file != null) {
            TbCompany tbCompany =
                    tbCompanyRepository.findById(payload.getInt("COMPANY_ID")).orElseThrow();

            tbMmDAO.saveImageFileWithName(
                    "supplierImages", file, tbCompany.getNAME(), tbCompany.getLOGO());

            return new XscResponse(1, "Image updated successfully.");
        } else {
            return new XscResponse(1, "Image not updated by user.");
        }
    }

    @PostMapping("/updateCustomerImage")
    private XscResponse updateCustomerImage(
            HttpServletRequest request, @RequestParam("payload") JSONObject payload)
            throws IOException {
        MultipartFile file = ((StandardMultipartHttpServletRequest) request).getFile("file");

        if (file != null) {
            TbCompany tbCompany =
                    tbCompanyRepository.findById(payload.getInt("COMPANY_ID")).orElseThrow();

            tbMmDAO.saveImageFileWithName(
                    "companyProfileImages", file, tbCompany.getNAME(), tbCompany.getLOGO());

            return new XscResponse(1, "Image updated successfully.");
        } else {
            return new XscResponse(1, "Image not updated by user.");
        }
    }

    @GetMapping(
            value = "/viewImages/{folderName}/{imageName}",
            produces = MediaType.IMAGE_JPEG_VALUE)
    private void getImage(
            @PathVariable("imageName") String imageName,
            @PathVariable("folderName") String folderName,
            HttpServletResponse response)
            throws IOException {
        InputStream is = tbMmDAO.getImageResource(folderName, imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(is, response.getOutputStream());
    }
}
