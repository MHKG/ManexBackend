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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TbSupplierInvoiceService implements TbSupplierInvoiceDAO {

    @Autowired private TbSupplierInvoiceRepository tbSupplierInvoiceRepository;

    @Autowired private TbSupplierOrderApRepository tbSupplierOrderApRepository;

    @Autowired private TbSupplierPoRepository tbSupplierPoRepository;

    @Autowired private TbSupplierQuotationRepository tbSupplierQuotationRepository;

    @Autowired private TbSupplierPiRepository tbSupplierPiRepository;

    @Override
    public XscResponse paySupplierDisplay(JSONObject payload) {
        XscResponse response = new XscResponse();

        TbSupplierInvoice tbSupplierInvoice =
                tbSupplierInvoiceRepository
                        .findById(payload.getInt("SUPP_INVOICE_ID"))
                        .orElseThrow();

        TbSupplierOrderAp tbSupplierOrderAp =
                tbSupplierOrderApRepository.findBySupplierInvoiceId(tbSupplierInvoice.getID());

        JsonObject data = getJsonObject(tbSupplierInvoice, tbSupplierOrderAp);

        response.setXscData(GenericMethods.convertGsonToJackson(data));
        response.setXscMessage("Invoice details fetched successfully");
        response.setXscStatus(1);
        return response;
    }

    private static JsonObject getJsonObject(
            TbSupplierInvoice tbSupplierInvoice, TbSupplierOrderAp tbSupplierOrderAp) {
        JsonObject data = new JsonObject();

        JsonArray jsonArray = new JsonArray();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("INVOICE_NO", tbSupplierInvoice.getSUPP_INV_NUM());
        jsonObject.addProperty("INVOICE_AMOUNT", tbSupplierInvoice.getGRAND_TOTAL());
        jsonObject.addProperty(
                "DUE_AMOUNT",
                tbSupplierInvoice.getGRAND_TOTAL() - tbSupplierOrderAp.getAMOUNT_PAID());
        jsonArray.add(jsonObject);

        data.add("INVOICE_DETAILS", jsonArray);
        return data;
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
            tbSupplierOrderApList.add(
                    tbSupplierOrderApRepository.findBySupplierInvoiceId(tbSupplierInvoice.getID()));
        }

        JsonObject data = new JsonObject();

        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i < tbSupplierInvoiceList.size(); i++) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("INV_ID", tbSupplierInvoiceList.get(i).getID());
            jsonObject.addProperty("ORDER_NO", tbSupplierInvoiceList.get(i).getSUPP_INV_NUM());
            jsonObject.addProperty("TOTAL_ITEM", 0);
            jsonObject.addProperty("TOTAL_CTN", 0);
            jsonObject.addProperty(
                    "CREATED_ON",
                    String.valueOf(tbSupplierInvoiceList.get(i).getTIMESTAMP()).split(" ")[0]);
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
}
