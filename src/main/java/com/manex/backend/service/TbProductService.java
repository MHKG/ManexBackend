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

import java.io.IOException;
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

        List<TbCompanyProductNumber> tbCompanyProductNumberList = new ArrayList<>();

        for (TbProducts tbProducts : tbProductsList) {
            tbCompanyProductNumberList.add(
                    tbCompanyProductNumberRepository.findByProductIdAppClientIdAndCompanyId(
                            tbProducts.getID(), APP_CLIENT_ID, tbClientSupplier.getCOMPANY_ID()));
        }

        List<TbProductMm> tbProductMmList = new ArrayList<>();
        for (TbProducts tbProducts : tbProductsList) {
            tbProductMmList.addAll(tbProductMmRepository.findAllByProductId(tbProducts.getID()));
        }

        String defaultMM_FILE_NAME = null;
        for (TbProductMm tbProductMm : tbProductMmList) {
            TbMm tbMm = tbMmRepository.findById(tbProductMm.getMM_FILE()).orElseThrow();
            if (tbProductMm.getDEFAULT_MM() == 'Y') {
                defaultMM_FILE_NAME = tbMm.getMM_FILE_NAME();
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
            jsonObject.addProperty("MM_FILE_NAME", defaultMM_FILE_NAME);
            jsonObject.addProperty("SUPP_PROD_NUM", tbCompanyProductNumberList.get(i).getITEM_NO());
            jsonObject.addProperty("CLIENT_PROD_NUM", (String) null);
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
        return null;
    }
}
