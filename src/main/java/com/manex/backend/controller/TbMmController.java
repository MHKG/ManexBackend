package com.manex.backend.controller;

import com.manex.backend.DAO.TbMmDAO;
import com.manex.backend.entities.TbCompany;
import com.manex.backend.entities.TbMm;
import com.manex.backend.repositories.TbCompanyRepository;
import com.manex.backend.response.XscResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/tb_mm_controller")
public class TbMmController {

    @Autowired private TbMmDAO tbMmDAO;

    @Autowired private TbCompanyRepository tbCompanyRepository;

    @PostMapping("/updateCompanyImage")
    private XscResponse uploadImage(
            @RequestParam("file") MultipartFile file, @RequestParam("payload") JSONObject payload)
            throws IOException {
        TbCompany tbCompany = tbCompanyRepository.findById(1).orElseThrow();
        TbMm tbMm =
                tbMmDAO.saveImageFileWithName(
                        "companyProfileImages", file, tbCompany.getNAME(), tbCompany.getLOGO());

        return new XscResponse(1, "Image updated successfully.");
    }
}
