package com.manex.backend.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.manex.backend.DAO.ExcelFilesDAO;
import com.manex.backend.GenericMethods.GenericMethods;
import com.manex.backend.response.XscResponse;

import jakarta.transaction.Transactional;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;

@Service
@Transactional
public class ExcelFilesService implements ExcelFilesDAO {

    @Override
    public XscResponse getTemplates(String templateName) {
        XscResponse response = new XscResponse();
        JsonObject data = new JsonObject();
        if (templateName.contains("Supplier")) {
            data.addProperty("TEMPLATE_URL", "template/ImportSupplierTemplate.xlsx");
        } else if (templateName.contains("Customer")) {
            data.addProperty("TEMPLATE_URL", "template/ImportCustomerTemplate.xlsx");
        } else if (templateName.contains("Product")) {
            data.addProperty("TEMPLATE_URL", "template/ImportProductTemplate.xlsx");
        }

        response.setXscData(GenericMethods.convertGsonToJackson(data));
        response.setXscMessage("Template url.");
        response.setXscStatus(1);
        return response;
    }

    @Override
    public ResponseEntity<byte[]> downloadSampleExcelFile(String filename) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sample Sheet");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        Row headerRow = sheet.createRow(0);

        String[] headers;
        if (filename.contains("Product")) {
            headers =
                    new String[] {
                        "Product_ID",
                        "Product_Name",
                        "Product_Description",
                        "Product_Price_Per_Piece",
                        "Pieces_Per_CTN",
                        "Packaging",
                        "Product_Barcode_Number",
                        "Product_Length",
                        "Product_Width",
                        "Product_Height",
                        "Product_CBM",
                        "Product_Material",
                        "Package_Type",
                        "CTN_Type",
                        "Net_Weight",
                        "Gross_Weight",
                        "Outer_Barcode_Number"
                    };
        } else {
            headers =
                    new String[] {
                        "COMPANY_NAME", "EMAIL", "CONTACT_NO", "ALT_CONTACT_NO",
                        "WEBSITE", "REG_NO", "COUNTRY_ISO3", "ADDR_LINE_1",
                        "ADDR_LINE_2", "PINCODE", "TAX", "FAX"
                    };
        }

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
        if (filename.contains("Supplier")) {
            responseHeaders.add(
                    HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=ImportSupplierTemplate.xlsx");
        } else if (filename.contains("Customer")) {
            responseHeaders.add(
                    HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=ImportCustomerTemplate.xlsx");
        } else if (filename.contains("Product")) {
            responseHeaders.add(
                    HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=ImportProductTemplate.xlsx");
        }

        return new ResponseEntity<>(out.toByteArray(), responseHeaders, HttpStatus.OK);
    }

    @Override
    public XscResponse uploadExcelFile(MultipartFile file, JSONObject payload) {
        XscResponse response = new XscResponse();

        if (file.isEmpty()) {
            response.setXscStatus(0);
            response.setXscMessage("Error fetching data from file.");
            return response;
        }

        try (XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);
            boolean firstRow = true;

            JsonObject data = new JsonObject();

            JsonArray jsonArray = new JsonArray();
            for (Row row : sheet) {
                if (firstRow) {
                    firstRow = false;
                    continue;
                }

                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("COMPANY_NAME", row.getCell(0).toString());
                jsonObject.addProperty("EMAIL", row.getCell(1).toString());
                jsonObject.addProperty("CONTACT_NO", getCellValueAsString(row.getCell(2)));
                jsonObject.addProperty("ALT_CONTACT_NO", getCellValueAsString(row.getCell(3)));
                jsonObject.addProperty("WEBSITE", row.getCell(4).toString());
                jsonObject.addProperty("REG_NO", row.getCell(5).toString());
                jsonObject.addProperty("COUNTRY_ISO3", row.getCell(6).toString());
                jsonObject.addProperty("ADDR_LINE_1", row.getCell(7).toString());
                jsonObject.addProperty("ADDR_LINE_2", row.getCell(8).toString());
                jsonObject.addProperty("PINCODE", getCellValueAsString(row.getCell(9)));
                jsonObject.addProperty("TAX", row.getCell(10).toString());
                jsonObject.addProperty("FAX", row.getCell(11).toString());

                jsonArray.add(jsonObject);
            }

            data.add("LIST", jsonArray);

            response.setXscData(GenericMethods.convertGsonToJackson(data));
            response.setXscMessage("Data imported successfully.");
            response.setXscStatus(1);
        } catch (IOException e) {
            response.setXscMessage("Error processing file " + e);
            response.setXscStatus(0);
        }
        return response;
    }

    @Override
    public XscResponse uploadProductExcelFile(MultipartFile file, JSONObject payload) {
        XscResponse response = new XscResponse();

        if (file.isEmpty()) {
            response.setXscStatus(0);
            response.setXscMessage("Error fetching data from file.");
            return response;
        }

        try (XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);
            boolean firstRow = true;

            JsonObject data = new JsonObject();

            JsonArray jsonArray = new JsonArray();
            for (Row row : sheet) {
                if (firstRow) {
                    firstRow = false;
                    continue;
                }

                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("SUPP_PROD_ID", row.getCell(0).toString().replace(".0", ""));
                jsonObject.addProperty("PRODUCT_NAME", row.getCell(1).toString());
                jsonObject.addProperty("P_DESC", row.getCell(2).toString());
                jsonObject.addProperty(
                        "PRICE_PER_PCS", row.getCell(3).toString().replace(".0", ""));
                jsonObject.addProperty("QTY_PER_CTN", row.getCell(4).toString().replace(".0", ""));
                jsonObject.addProperty("PACKAGING", row.getCell(5).toString());
                jsonObject.addProperty("PRODUCT_BARCODE_NUMBER", row.getCell(6).toString());
                jsonObject.addProperty("PRODUCT_LENGTH", row.getCell(7).toString());
                jsonObject.addProperty("PRODUCT_WIDTH", row.getCell(8).toString());
                jsonObject.addProperty("PRODUCT_HEIGHT", row.getCell(9).toString());
                jsonObject.addProperty("PRODUCT_CBM", row.getCell(10).toString());
                jsonObject.addProperty("PRODUCT_MATERIAL", row.getCell(11).toString());
                jsonObject.addProperty("PACKAGE_TYPE", row.getCell(12).toString());
                jsonObject.addProperty("CTN_TYPE", row.getCell(13).toString());
                jsonObject.addProperty("NET_WEIGHT", row.getCell(14).toString());
                jsonObject.addProperty("GROSS_WEIGHT", row.getCell(15).toString());
                jsonObject.addProperty("OUTER_BARCODE_NUMBER", row.getCell(16).toString());

                jsonArray.add(jsonObject);
            }

            data.add("LIST", jsonArray);

            response.setXscData(GenericMethods.convertGsonToJackson(data));
            response.setXscMessage("Data imported successfully.");
            response.setXscStatus(1);
        } catch (IOException e) {
            response.setXscMessage("Error processing file " + e);
            response.setXscStatus(0);
        }
        return response;
    }

    private String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }

        return BigDecimal.valueOf(cell.getNumericCellValue()).toPlainString();
    }
}
