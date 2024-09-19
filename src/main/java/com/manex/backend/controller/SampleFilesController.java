package com.manex.backend.controller;

import com.google.gson.JsonObject;
import com.manex.backend.GenericMethods.GenericMethods;
import com.manex.backend.response.XscResponse;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/sample_files_controller")
public class SampleFilesController {

    @GetMapping("/getSupplierTemplate")
    public XscResponse getSupplierTemplate() {
        XscResponse response = new XscResponse();
        JsonObject data = new JsonObject();
        data.addProperty("TEMPLATE_URL", "template/ImportSupplierTemplate.xlsx");

        response.setXscData(GenericMethods.convertGsonToJackson(data));
        response.setXscMessage("Template url.");
        response.setXscStatus(1);
        return response;
    }

    @GetMapping("/getCustomerTemplate")
    public XscResponse getCustomerTemplate() {
        XscResponse response = new XscResponse();
        JsonObject data = new JsonObject();
        data.addProperty("TEMPLATE_URL", "template/ImportCustomerTemplate.xlsx");

        response.setXscData(GenericMethods.convertGsonToJackson(data));
        response.setXscMessage("Template url.");
        response.setXscStatus(1);
        return response;
    }

    @GetMapping("/template/ImportSupplierTemplate.xlsx")
    public ResponseEntity<byte[]> downloadSampleSupplierXlsx() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sample Sheet");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        Row headerRow = sheet.createRow(0);
        String[] headers = {
            "COMPANY_NAME", "EMAIL", "CONTACT_NO", "ALT_CONTACT_NO",
            "WEBSITE", "REG_NO", "COUNTRY_ISO3", "ADDR_LINE_1",
            "ADDR_LINE_2", "PINCODE", "TAX", "FAX"
        };

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerCellStyle);
        }

        int minWidth = 19 * 256;
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
            int currentWidth = sheet.getColumnWidth(i);
            if (currentWidth < minWidth) {
                sheet.setColumnWidth(i, minWidth);
            }
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(
                HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=ImportSupplierTemplate.xlsx");

        return new ResponseEntity<>(out.toByteArray(), responseHeaders, HttpStatus.OK);
    }

    @GetMapping("/template/ImportCustomerTemplate.xlsx")
    public ResponseEntity<byte[]> downloadSampleCustomerXlsx() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sample Sheet");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        Row headerRow = sheet.createRow(0);
        String[] headers = {
            "COMPANY_NAME", "EMAIL", "CONTACT_NO", "ALT_CONTACT_NO",
            "WEBSITE", "REG_NO", "COUNTRY_ISO3", "ADDR_LINE_1",
            "ADDR_LINE_2", "PINCODE", "TAX", "FAX"
        };

        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerCellStyle);
        }

        int minWidth = 19 * 256;
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
            int currentWidth = sheet.getColumnWidth(i);
            if (currentWidth < minWidth) {
                sheet.setColumnWidth(i, minWidth);
            }
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(
                HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=ImportCustomerTemplate.xlsx");

        return new ResponseEntity<>(out.toByteArray(), responseHeaders, HttpStatus.OK);
    }
}
