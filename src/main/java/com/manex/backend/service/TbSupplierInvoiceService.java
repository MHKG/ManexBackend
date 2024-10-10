package com.manex.backend.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.manex.backend.DAO.TbSupplierInvoiceDAO;
import com.manex.backend.GenericMethods.GenericMethods;
import com.manex.backend.entities.*;
import com.manex.backend.repositories.*;
import com.manex.backend.response.XscResponse;

import jakarta.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TbSupplierInvoiceService implements TbSupplierInvoiceDAO {

    @Autowired private TbSupplierInvoiceRepository tbSupplierInvoiceRepository;

    @Autowired private TbSupplierOrderApRepository tbSupplierOrderApRepository;

    @Autowired private TbSupplierPoRepository tbSupplierPoRepository;

    @Autowired private TbSupplierQuotationRepository tbSupplierQuotationRepository;

    @Autowired private TbSupplierPiRepository tbSupplierPiRepository;

    @Autowired private TbProductsRepository tbProductsRepository;

    @Autowired private TbSupplierPoItemsRepository tbSupplierPoItemsRepository;

    private static JsonObject getJsonObject(
            TbSupplierInvoice tbSupplierInvoice, List<TbSupplierOrderAp> tbSupplierOrderApList) {
        JsonObject data = new JsonObject();

        JsonArray jsonArray = new JsonArray();
        for (TbSupplierOrderAp tbSupplierOrderAp : tbSupplierOrderApList) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("INVOICE_NO", tbSupplierInvoice.getSUPP_INV_NUM());
            jsonObject.addProperty("INVOICE_AMOUNT", tbSupplierInvoice.getGRAND_TOTAL());
            jsonObject.addProperty(
                    "DUE_AMOUNT",
                    tbSupplierInvoice.getGRAND_TOTAL() - tbSupplierOrderAp.getAMOUNT_PAID());
            jsonArray.add(jsonObject);
        }

        data.add("INVOICE_DETAILS", jsonArray);
        return data;
    }

    @Override
    public XscResponse paySupplierDisplay(JSONObject payload) {
        XscResponse response = new XscResponse();

        TbSupplierInvoice tbSupplierInvoice =
                tbSupplierInvoiceRepository
                        .findById(payload.getInt("SUPP_INVOICE_ID"))
                        .orElseThrow();

        List<TbSupplierOrderAp> tbSupplierOrderApList =
                tbSupplierOrderApRepository.findBySupplierInvoiceId(tbSupplierInvoice.getID());

        JsonObject data = getJsonObject(tbSupplierInvoice, tbSupplierOrderApList);

        response.setXscData(GenericMethods.convertGsonToJackson(data));
        response.setXscMessage("Invoice details fetched successfully");
        response.setXscStatus(1);
        return response;
    }

    @Override
    public XscResponse supplierInvoiceList(JSONObject payload) {
        XscResponse response = new XscResponse();

        List<TbSupplierPo> tbSupplierPoList =
                tbSupplierPoRepository.findAllByClientSupplierId(
                        payload.getString("CLIENT_SUPP_ID"));

        List<TbSupplierQuotation> tbSupplierQuotationList = new ArrayList<>();

        for (TbSupplierPo tbSupplierPo : tbSupplierPoList) {
            tbSupplierQuotationList.add(
                    tbSupplierQuotationRepository.findLatestBySuppPoId(tbSupplierPo.getID()));
        }

        List<TbSupplierPi> tbSupplierPiList = new ArrayList<>();

        for (TbSupplierQuotation tbSupplierQuotation : tbSupplierQuotationList) {
            tbSupplierPiList.add(
                    tbSupplierPiRepository.findLatestBySuppQuotId(tbSupplierQuotation.getID()));
        }

        List<TbSupplierInvoice> tbSupplierInvoiceList = new ArrayList<>();

        for (TbSupplierPi tbSupplierPi : tbSupplierPiList) {
            tbSupplierInvoiceList.add(
                    tbSupplierInvoiceRepository.findLatestBySuppPiId(tbSupplierPi.getID()));
        }

        List<TbSupplierOrderAp> tbSupplierOrderApList = new ArrayList<>();

        for (TbSupplierInvoice tbSupplierInvoice : tbSupplierInvoiceList) {
            tbSupplierOrderApList.addAll(
                    tbSupplierOrderApRepository.findBySupplierInvoiceId(tbSupplierInvoice.getID()));
        }

        JsonObject data = new JsonObject();

        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i < tbSupplierInvoiceList.size(); i++) {
            Instant timestamp = tbSupplierInvoiceList.get(i).getTIMESTAMP().toInstant();
            Date date = Date.from(timestamp);

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("INV_ID", tbSupplierInvoiceList.get(i).getID());
            jsonObject.addProperty("ORDER_NO", tbSupplierInvoiceList.get(i).getSUPP_INV_NUM());
            jsonObject.addProperty("TOTAL_ITEM", 0);
            jsonObject.addProperty("TOTAL_CTN", 0);
            jsonObject.addProperty("CREATED_ON", String.valueOf(date.getTime() / 1000));
            jsonObject.addProperty("TOTAL_AMOUNT", tbSupplierInvoiceList.get(i).getGRAND_TOTAL());
            jsonObject.addProperty(
                    "DUE_AMOUNT",
                    tbSupplierInvoiceList.get(i).getGRAND_TOTAL()
                            - tbSupplierOrderApList.get(i).getAMOUNT_PAID());
            jsonObject.addProperty("PAYMENT_STATUS", tbSupplierPiList.get(i).getSTATUS());
            jsonObject.addProperty("INVOICE_STATUS", tbSupplierInvoiceList.get(i).getSTATUS());

            jsonArray.add(jsonObject);
        }

        data.add("SUPPLIER_INVOICE", jsonArray);
        response.setXscData(GenericMethods.convertGsonToJackson(data));
        response.setXscMessage("Supplier invoice details");
        response.setXscStatus(1);
        return response;
    }

    @Override
    public XscResponse viewSupplierInvoice(JSONObject payload) {
        float totalInvoiceAmount = 0;

        XscResponse response = new XscResponse();

        TbSupplierInvoice tbSupplierInvoice =
                tbSupplierInvoiceRepository.findById(payload.getInt("INVOICE_ID")).orElseThrow();

        Pageable pageable = PageRequest.of(0, 1000);

        List<TbProducts> tbProductsList =
                tbProductsRepository.findAllByClientSupplierId(
                        payload.getString("CLIENT_SUPPLIER_ID"), "", pageable);

        TbSupplierPi tbSupplierPi =
                tbSupplierPiRepository.findById(tbSupplierInvoice.getSUPP_PI_ID()).orElseThrow();

        TbSupplierQuotation tbSupplierQuotation =
                tbSupplierQuotationRepository
                        .findById(tbSupplierPi.getSUPP_QUOT_ID())
                        .orElseThrow();

        List<TbSupplierPoItems> tbSupplierPoItemsList =
                tbSupplierPoItemsRepository.findAllBySupplierPoId(
                        tbSupplierQuotation.getSUPP_PO_ID());

        JsonObject data = new JsonObject();

        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i < tbSupplierPoItemsList.size(); i++) {
            float total_cost =
                    tbSupplierPoItemsList.get(i).getQTY()
                            * tbSupplierPoItemsList.get(i).getPRICE_PER_ITEM();
            totalInvoiceAmount += total_cost;
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("CLIENT_PROD_ID", tbProductsList.get(i).getID());
            jsonObject.addProperty("SUPP_PROD_ID", tbProductsList.get(i).getID());
            jsonObject.addProperty("DESCRIPTION", tbProductsList.get(i).getDESCRIPTION());
            jsonObject.addProperty("TOTAL_QTY", tbSupplierPoItemsList.get(i).getQTY());
            jsonObject.addProperty(
                    "PRICE_PER_ITEM", tbSupplierPoItemsList.get(i).getPRICE_PER_ITEM());
            jsonObject.addProperty("TOTAL_COST", total_cost);

            jsonArray.add(jsonObject);
        }

        data.add("INV_ITEMS", jsonArray);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("TOTAL_COST", totalInvoiceAmount);
        jsonObject.addProperty(
                "INVOICE_CURRENCY_RATE", tbSupplierInvoice.getINVOICE_CURRENCY_RATE());
        jsonObject.addProperty("TOTAL_INVOICE_VALUE", totalInvoiceAmount);

        data.add("SUMMARY", jsonObject);

        response.setXscData(GenericMethods.convertGsonToJackson(data));
        response.setXscMessage("Data fetched successfully");
        response.setXscStatus(1);
        return response;
    }
}
