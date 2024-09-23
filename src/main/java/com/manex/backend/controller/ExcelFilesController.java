package com.manex.backend.controller;

import com.manex.backend.DAO.ExcelFilesDAO;
import com.manex.backend.response.XscResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/sample_files_controller")
public class ExcelFilesController {

    @Autowired private ExcelFilesDAO excelFilesDAO;

    @GetMapping("/getTemplates/{templateName}")
    public XscResponse getTemplates(@PathVariable("templateName") String templateName) {
        return excelFilesDAO.getTemplates(templateName);
    }

    @GetMapping("/template/{filename}")
    public ResponseEntity<byte[]> downloadSampleExcelFile(@PathVariable("filename") String filename)
            throws IOException {
        return excelFilesDAO.downloadSampleExcelFile(filename);
    }

    @PostMapping("/uploadExcelFile")
    private XscResponse uploadExcelFile(
            @RequestParam("file") MultipartFile file, @RequestParam("payload") JSONObject payload) {
        return excelFilesDAO.uploadExcelFile(file, payload);
    }

    @PostMapping("/uploadProductExcelFile")
    private XscResponse uploadProductExcelFile(
            @RequestParam("file") MultipartFile file, @RequestParam("payload") JSONObject payload) {
        return excelFilesDAO.uploadProductExcelFile(file, payload);
    }
}
