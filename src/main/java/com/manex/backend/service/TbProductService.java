package com.manex.backend.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.manex.backend.DAO.TbMmDAO;
import com.manex.backend.DAO.TbProductDAO;
import com.manex.backend.GenericMethods.GenericMethods;
import com.manex.backend.entities.*;
import com.manex.backend.enums.SizeUnit;
import com.manex.backend.enums.VolumeUnit;
import com.manex.backend.enums.WeightUnit;
import com.manex.backend.repositories.*;
import com.manex.backend.response.XscResponse;

import jakarta.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class TbProductService implements TbProductDAO {

    @Autowired private TbProductsRepository tbProductsRepository;

    @Autowired private TbAppClientRepository tbAppClientRepository;

    @Autowired private TbLookupCurrencyRepository tbLookupCurrencyRepository;

    @Autowired private TbProductSpecRepository tbProductSpecRepository;

    @Autowired private TbClientSupplierRepository tbClientSupplierRepository;

    @Autowired private TbCompanyProductNumberRepository tbCompanyProductNumberRepository;

    @Autowired private TbCtnRepository tbCtnRepository;

    @Autowired private TbMItemCtnRepository tbMItemCtnRepository;

    @Autowired private TbProductMmRepository tbProductMmRepository;

    @Autowired private TbClientInventoryRepository tbClientInventoryRepository;

    @Autowired private TbMClientSupplierItemRepository tbMClientSupplierItemRepository;

    @Autowired private TbMmRepository tbMmRepository;

    @Autowired private TbMmDAO tbMmDAO;

    @Override
    public XscResponse addProduct(MultipartFile[] files, JSONObject payload) throws IOException {
        TbProducts tbProducts = new TbProducts();
        tbProducts.setCLIENT_SUPPLIER_ID(payload.getInt("CLIENT_SUPPLIER_ID"));
        tbProducts.setDESCRIPTION(payload.get("P_DESC").toString());
        tbProducts.setLENGTH(Float.valueOf(payload.get("P_LENGTH").toString()));
        tbProducts.setWIDTH(Float.valueOf(payload.get("P_WIDTH").toString()));
        tbProducts.setHEIGHT(Float.valueOf(payload.get("P_HEIGHT").toString()));
        tbProducts.setSIZE_UNIT(
                SizeUnit.valueOf(payload.get("SIZE_UNIT").toString().toUpperCase()));
        if (!Objects.equals(payload.get("P_WT").toString(), "")) {
            tbProducts.setWEIGHT(Float.valueOf(payload.get("P_WT").toString()));
            tbProducts.setWEIGHT_UNIT(
                    WeightUnit.valueOf(payload.get("P_WT_UNIT").toString().toUpperCase()));
        }
        tbProducts.setVOLUME(Float.valueOf(payload.get("VOLUME").toString()));
        tbProducts.setVOLUME_UNIT(
                VolumeUnit.valueOf(payload.get("VOLUME_UNIT").toString().toUpperCase()));
        tbProducts = tbProductsRepository.save(tbProducts);

        for (int i = 1; i <= files.length; i++) {
            TbProductMm tbProductMm = new TbProductMm();
            tbProductMm.setPRODUCT_ID(tbProducts.getID());
            TbMm tbMm = new TbMm();
            if (!files[i - 1].isEmpty()) {
                tbMm =
                        tbMmDAO.saveImageFileWithName(
                                "productImages",
                                files[i - 1],
                                payload.getString("P_DESC") + i,
                                null);
            }
            tbProductMm.setMM_FILE(tbMm.getID());
            if (i == payload.getInt("PRIMARY_IMAGE_INDEX")) {
                tbProductMm.setDEFAULT_MM('Y');
            } else {
                tbProductMm.setDEFAULT_MM('N');
            }
            tbProductMm.setPRODUCT_ID(tbProducts.getID());
            tbProductMm.setSTATUS(true);
            tbProductMmRepository.save(tbProductMm);
        }

        TbProductSpec tbProductSpec = new TbProductSpec();
        tbProductSpec.setPRODUCT_ID(tbProducts.getID());
        tbProductSpec.setCOLOUR(payload.get("P_COLOR").toString());
        tbProductSpec.setMATERIAL(payload.get("P_MATERIAL").toString());
        tbProductSpec.setPACKING(payload.get("P_PKG_TYPE").toString());
        tbProductSpec.setPRICE(Float.valueOf(payload.get("PRICE_PER_PCS").toString()));
        tbProductSpec = tbProductSpecRepository.save(tbProductSpec);

        TbCompanyProductNumber tbCompanyProductNumber = new TbCompanyProductNumber();
        TbCompanyProductNumberId tbCompanyProductNumberId = new TbCompanyProductNumberId();

        TbClientSupplier tbClientSupplier =
                tbClientSupplierRepository
                        .findById(payload.getInt("CLIENT_SUPPLIER_ID"))
                        .orElseThrow();

        tbCompanyProductNumberId.setPRODUCT_ID(tbProducts.getID());
        tbCompanyProductNumberId.setCOMPANY_ID(tbClientSupplier.getCOMPANY_ID());
        tbCompanyProductNumberId.setAPP_CLIENT_ID(payload.getInt("APP_CLIENT_ID"));

        tbCompanyProductNumber.setID(tbCompanyProductNumberId);
        tbCompanyProductNumber.setITEM_NO(payload.get("SUPPLIER_PROD_NUM").toString());
        tbCompanyProductNumber.setBAR_CODE(payload.get("CLIENT_P_BAR_CODE").toString());
        tbCompanyProductNumber.setDUN_BAR_CODE(payload.get("CLIENT_DUN_BAR_CODE").toString());
        tbCompanyProductNumber = tbCompanyProductNumberRepository.save(tbCompanyProductNumber);

        List<TbCtn> tbCtnList =
                tbCtnRepository.findByAppClientId(payload.getString("APP_CLIENT_ID"));

        TbMItemCtn tbMItemCtn = new TbMItemCtn();
        TbMItemCtnId tbMItemCtnId = new TbMItemCtnId();
        tbMItemCtnId.setPRODUCT_ID(tbProducts.getID());
        tbMItemCtnId.setCTN_ID(payload.getInt("CTN_ID"));

        tbMItemCtn.setID(tbMItemCtnId);
        tbMItemCtn.setQTY_PER_CTN(payload.getInt("QTY_PER_CTN"));
        tbMItemCtn.setWEIGHT_UNIT(
                WeightUnit.valueOf(payload.get("CTN_WT_UNIT").toString().toUpperCase()));
        tbMItemCtn.setGROSS_WT((float) payload.getInt("CTN_GROSS_WT"));
        tbMItemCtn.setNET_WT((float) payload.getInt("CTN_NET_WT"));
        tbMItemCtn.setPKG_TYPE(payload.get("C_PKG_TYPE").toString());
        tbMItemCtnRepository.save(tbMItemCtn);

        TbClientInventory tbClientInventory = new TbClientInventory();
        tbClientInventory.setPRODUCT_ID(tbProducts.getID());
        tbClientInventory.setAPP_CLIENT_ID(payload.getInt("APP_CLIENT_ID"));
        tbClientInventory.setQTY(payload.getInt("QTY_PER_CTN"));
        tbClientInventory.setLAST_PRICE(payload.getFloat("PRICE_PER_PCS"));
        tbClientInventoryRepository.save(tbClientInventory);

        TbMClientSupplierItem tbMClientSupplierItem = new TbMClientSupplierItem();
        TbMClientSupplierItemId tbMClientSupplierItemId = new TbMClientSupplierItemId();
        tbMClientSupplierItemId.setCLIENT_SUPP_ID(payload.getInt("CLIENT_SUPPLIER_ID"));
        tbMClientSupplierItemId.setPROD_ID(tbProducts.getID());
        tbMClientSupplierItem.setID(tbMClientSupplierItemId);
        tbMClientSupplierItem.setSTATUS(1);
        tbMClientSupplierItem.setIS_PROD_FAV('N');
        tbMClientSupplierItemRepository.save(tbMClientSupplierItem);

        return new XscResponse(1, "Product added successfully");
    }

    @Override
    public XscResponse getProductsList(String clientSupplierId, int APP_CLIENT_ID) {
        XscResponse response = new XscResponse();

        TbClientSupplier tbClientSupplier =
                tbClientSupplierRepository
                        .findById(Integer.valueOf(clientSupplierId))
                        .orElseThrow();

        List<TbProducts> tbProductsList =
                tbProductsRepository.findAllByClientSupplierId(clientSupplierId);

        List<TbCompanyProductNumber> arrayList = new ArrayList<>();

        List<ArrayList<TbCompanyProductNumber>> tbCompanyProductNumberList = new ArrayList<>();

        for (TbProducts tbProducts : tbProductsList) {
            arrayList.clear();
            arrayList.addAll(
                    tbCompanyProductNumberRepository.findByProductIdAndAppClientId(
                            tbProducts.getID(), APP_CLIENT_ID));

            tbCompanyProductNumberList.add(new ArrayList<>(arrayList));
        }

        List<TbProductMm> tbProductMmList = new ArrayList<>();
        for (TbProducts tbProducts : tbProductsList) {
            tbProductMmList.addAll(tbProductMmRepository.findAllByProductId(tbProducts.getID()));
        }

        List<String> defaultMM_FILE_NAME = new ArrayList<>();
        for (TbProductMm tbProductMm : tbProductMmList) {
            TbMm tbMm = tbMmRepository.findById(tbProductMm.getMM_FILE()).orElseThrow();
            if (tbProductMm.getDEFAULT_MM() == 'Y') {
                defaultMM_FILE_NAME.add(tbMm.getMM_FILE_NAME());
            }
        }

        TbAppClient tbAppClient = tbAppClientRepository.findById(APP_CLIENT_ID).orElseThrow();

        TbLookupCurrency tbLookupCurrency =
                tbLookupCurrencyRepository
                        .findById(tbAppClient.getOPERATING_CURRENCY())
                        .orElseThrow();

        List<TbClientInventory> tbClientInventoryList =
                tbClientInventoryRepository.findByAppClientId(APP_CLIENT_ID);

        JsonObject data = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i < tbProductsList.size(); i++) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("MM_FILE_NAME", defaultMM_FILE_NAME.get(i));
            if (Objects.equals(
                            tbCompanyProductNumberList.get(i).get(0).getID().getCOMPANY_ID(),
                            tbClientSupplier.getCOMPANY_ID())
                    && Objects.equals(
                            tbCompanyProductNumberList.get(i).get(0).getID().getPRODUCT_ID(),
                            tbProductsList.get(i).getID())) {
                jsonObject.addProperty(
                        "SUPP_PROD_NUM", tbCompanyProductNumberList.get(i).get(0).getITEM_NO());

                    jsonObject.addProperty(
                            "CLIENT_PROD_NUM",
                            tbCompanyProductNumberList.get(i).get(1).getITEM_NO());

            } else {
                jsonObject.addProperty(
                        "CLIENT_PROD_NUM", tbCompanyProductNumberList.get(i).get(0).getITEM_NO());
                jsonObject.addProperty(
                        "SUPP_PROD_NUM", tbCompanyProductNumberList.get(i).get(1).getITEM_NO());
            }
            jsonObject.addProperty("PRODUCT_NAME", tbProductsList.get(i).getDESCRIPTION());
            jsonObject.addProperty("PROD_ID", tbProductsList.get(i).getID());
            jsonObject.addProperty("CURRENCY_SYMBOL", tbLookupCurrency.getCURRENCY_SYMBOL());
            jsonObject.addProperty("PRICE", tbClientInventoryList.get(i).getLAST_PRICE());
            jsonObject.addProperty("QTY", tbClientInventoryList.get(i).getQTY());

            jsonArray.add(jsonObject);
        }

        data.add("PRODUCTS", jsonArray);

        response.setXscData(GenericMethods.convertGsonToJackson(data));
        response.setXscMessage("Products list");
        response.setXscStatus(1);
        return response;
    }

    @Override
    public XscResponse getProductsDetails(String clientSupplierId, String productId) {
        XscResponse response = new XscResponse();

        TbProducts tbProducts =
                tbProductsRepository.findById(Integer.valueOf(productId)).orElseThrow();

        List<TbProductMm> tbProductMmList =
                tbProductMmRepository.findAllByProductId(Integer.valueOf(productId));

        TbProductSpec tbProductSpec =
                tbProductSpecRepository.findByProductId(Integer.parseInt(productId));

        TbMItemCtn tbMItemCtn = tbMItemCtnRepository.findByProductId(Integer.parseInt(productId));

        List<TbCompanyProductNumber> tbCompanyProductNumberList =
                tbCompanyProductNumberRepository.findByProductIdAndAppClientId(
                        Integer.parseInt(productId),
                        tbClientSupplierRepository
                                .findById(Integer.valueOf(clientSupplierId))
                                .orElseThrow()
                                .getAPP_CLIENT_ID());

        List<TbMm> tbMmList = new ArrayList<>();

        for (TbProductMm tbProductMm : tbProductMmList) {
            tbMmList.add(tbMmRepository.findById(tbProductMm.getMM_FILE()).orElseThrow());
        }

        JsonObject data = new JsonObject();

        JsonArray jsonArray1 = new JsonArray();
        for (int i = 0; i < tbProductMmList.size(); i++) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("is_default", tbProductMmList.get(i).getDEFAULT_MM());
            jsonObject.addProperty("PROD_MEDIA", tbMmList.get(i).getMM_FILE_NAME());
            jsonObject.addProperty("is_default", tbProductMmList.get(i).getDEFAULT_MM());
            jsonObject.addProperty("is_default", tbProductMmList.get(i).getDEFAULT_MM());
            jsonArray1.add(jsonObject);
        }
        data.add("PROD_MEDIA", jsonArray1);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("PACKING", tbProductSpec.getPACKING());
        jsonObject.addProperty("CTN_PKG_TYPE", tbMItemCtn.getPKG_TYPE());
        jsonObject.addProperty("PROD_LENGTH", tbProducts.getLENGTH());
        jsonObject.addProperty("PROD_WIDTH", tbProducts.getWIDTH());
        jsonObject.addProperty("PROD_HEIGHT", tbProducts.getHEIGHT());
        jsonObject.addProperty("PROD_VOLUME", tbProducts.getVOLUME());
        jsonObject.addProperty("PROD_WT", tbProducts.getWEIGHT());
        jsonObject.addProperty("SUPP_BAR_CODE", tbCompanyProductNumberList.get(0).getBAR_CODE());
        jsonObject.addProperty(
                "SUPP_DUN_BAR_CODE", tbCompanyProductNumberList.get(0).getDUN_BAR_CODE());
        jsonObject.addProperty(
                "SUPP_PROD_NUM", Integer.valueOf(tbCompanyProductNumberList.get(0).getITEM_NO()));
        if (tbCompanyProductNumberList.size() == 1) {
            jsonObject.addProperty("CLIENT_BAR_CODE", (String) null);
            jsonObject.addProperty("CLIENT_DUN_BAR_CODE", (String) null);
            jsonObject.addProperty("CLIENT_PROD_NUM", (String) null);
        } else {
            jsonObject.addProperty(
                    "CLIENT_BAR_CODE", tbCompanyProductNumberList.get(1).getBAR_CODE());
            jsonObject.addProperty(
                    "CLIENT_DUN_BAR_CODE", tbCompanyProductNumberList.get(1).getDUN_BAR_CODE());
            jsonObject.addProperty(
                    "CLIENT_PROD_NUM", tbCompanyProductNumberList.get(1).getITEM_NO());
        }
        jsonObject.addProperty("PRICE", tbProductSpec.getPRICE());
        jsonObject.addProperty("QTY_PER_CTN", tbMItemCtn.getQTY_PER_CTN());
        jsonObject.addProperty("DESCRIPTION", tbProducts.getDESCRIPTION());
        jsonObject.addProperty("COLOUR", tbProductSpec.getCOLOUR());
        jsonObject.addProperty("MATERIAL", tbProductSpec.getMATERIAL());

        data.add("PRODUCT_DETAILS", jsonObject);

        response.setXscData(GenericMethods.convertGsonToJackson(data));
        response.setXscMessage("Details of a product.");
        response.setXscStatus(1);
        return response;
    }

	@Override
	public InputStream getImageResource(String fileName) throws FileNotFoundException {
		String fullPath = "productImages" + File.separator + fileName;
		return new FileInputStream(fullPath);
	}
}
