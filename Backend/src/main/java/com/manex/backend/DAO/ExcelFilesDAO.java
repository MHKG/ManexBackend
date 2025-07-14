package com.manex.backend.DAO;

import com.manex.backend.response.XscResponse;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ExcelFilesDAO {
    XscResponse getTemplates(String templateName);

    ResponseEntity<byte[]> downloadSampleExcelFile(String filename) throws IOException;

    XscResponse uploadExcelFile(MultipartFile file, JSONObject payload);

    XscResponse uploadProductExcelFile(MultipartFile file, JSONObject payload);
}
