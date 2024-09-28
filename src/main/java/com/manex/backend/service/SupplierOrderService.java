package com.manex.backend.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.manex.backend.DAO.SupplierOrderDAO;
import com.manex.backend.GenericMethods.GenericMethods;
import com.manex.backend.entities.*;
import com.manex.backend.repositories.*;
import com.manex.backend.response.XscResponse;

import jakarta.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SupplierOrderService implements SupplierOrderDAO {

    @Autowired private TbClientSupplierRepository tbClientSupplierRepository;

    @Autowired private TbSupplierPoRepository tbSupplierPoRepository;

    @Autowired private TbSupplierQuotationRepository tbSupplierQuotationRepository;

    @Autowired private TbSupplierPiRepository tbSupplierPiRepository;

    @Autowired private TbSupplierInvoiceRepository tbSupplierInvoiceRepository;

    @Override
    public XscResponse orderStatusFilter(JSONObject payload) {
        XscResponse response = new XscResponse();

        JsonObject data = new JsonObject();

        JsonArray jsonArray = new JsonArray();

        int[] statuses = {1, 2, 3, 4};
        String[] types = {"Pending Approval", "Payment Due", "Completed", "Reject"};

        for (int i = 0; i < statuses.length; i++) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("STATUS", statuses[i]);
            jsonObject.addProperty("TYPE", types[i]);
            jsonArray.add(jsonObject);
        }

        data.add("ORDER_STATUS", jsonArray);

        response.setXscData(GenericMethods.convertGsonToJackson(data));
        response.setXscMessage("Status Listed Successfully");
        response.setXscStatus(1);
        return response;
    }

    @Override
    public XscResponse paymentStatusFilter(JSONObject payload) {
        XscResponse response = new XscResponse();

        JsonObject data = new JsonObject();

        JsonArray jsonArray = new JsonArray();

        int[] statuses = {0, 1};
        String[] types = {"Unpaid", "Paid"};

        for (int i = 0; i < statuses.length; i++) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("STATUS", statuses[i]);
            jsonObject.addProperty("TYPE", types[i]);
            jsonArray.add(jsonObject);
        }

        data.add("PAYMENT_STATUS", jsonArray);

        response.setXscData(GenericMethods.convertGsonToJackson(data));
        response.setXscMessage("Status Listed Successfully");
        response.setXscStatus(1);
        return response;
    }

    @Override
    public XscResponse getOrderList(JSONObject payload) {
        XscResponse response = new XscResponse();

        TbClientSupplier tbClientSupplier =
                tbClientSupplierRepository
                        .findById(payload.getInt("CLIENT_SUPPLIER_ID"))
                        .orElseThrow();

        List<TbSupplierPo> tbSupplierPoList =
                tbSupplierPoRepository.findByAppClientIdAndClientSupplierId(
                        payload.getInt("CLIENT_SUPPLIER_ID"), tbClientSupplier.getAPP_CLIENT_ID());

        JsonObject data = new JsonObject();

        JsonArray jsonArray = new JsonArray();
        for (TbSupplierPo tbSupplierPo : tbSupplierPoList) {
            TbSupplierQuotation tbSupplierQuotation =
                    tbSupplierQuotationRepository.findLatestBySuppPoId(tbSupplierPo.getID());

            TbSupplierPi tbSupplierPi =
                    tbSupplierPiRepository.findLatestBySuppQuotId(tbSupplierQuotation.getID());

            TbSupplierInvoice tbSupplierInvoice =
                    tbSupplierInvoiceRepository.findLatestBySuppPiId(tbSupplierPi.getID());

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("SUPP_PO_ID", tbSupplierPo.getID());
            jsonObject.addProperty("PO_NUM", tbSupplierPo.getPO_NUM());
            jsonObject.addProperty(
                    "CREATED_ON", String.valueOf(tbSupplierPo.getTIMESTAMP()).split(" ")[0]);
            jsonObject.addProperty("TOTAL_AMOUNT", tbSupplierInvoice.getGRAND_TOTAL());
            jsonArray.add(jsonObject);
        }
        data.add("PO_LIST", jsonArray);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("COUNT", tbSupplierPoList.size());

        data.add("TOTAL_PO_COUNT", jsonObject);

        response.setXscData(GenericMethods.convertGsonToJackson(data));
        response.setXscMessage("Order list fetched successfully");
        response.setXscStatus(1);
        return response;
    }
}
