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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SupplierOrderService implements SupplierOrderDAO {

    @Autowired private TbClientSupplierRepository tbClientSupplierRepository;

    @Autowired private TbSupplierPoRepository tbSupplierPoRepository;

    @Autowired private TbSupplierQuotationRepository tbSupplierQuotationRepository;

    @Autowired private TbSupplierPiRepository tbSupplierPiRepository;

    @Autowired private TbSupplierInvoiceRepository tbSupplierInvoiceRepository;

    @Autowired private TbProductMmRepository tbProductMmRepository;

    @Autowired private TbMmRepository tbMmRepository;

    @Autowired private TbProductsRepository tbProductsRepository;

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

        Pageable pageable = PageRequest.of(0, 1000);
        List<TbProducts> tbProductsList =
                tbProductsRepository.findAllByClientSupplierId(
                        payload.get("CLIENT_SUPPLIER_ID").toString(), pageable);

        List<TbProductMm> tbProductMmList = new ArrayList<>();

        for (TbProducts tbProducts : tbProductsList) {
            TbProductMm tbProductMm =
                    tbProductMmRepository.findDefaultByProductId(tbProducts.getID());
            if (tbProductMm != null) {
                tbProductMmList.add(tbProductMm);
            }
        }

        List<TbMm> tbMmList = new ArrayList<>();

        for (TbProductMm tbProductMm : tbProductMmList) {
            tbMmList.add(tbMmRepository.findById(tbProductMm.getMM_FILE()).orElseThrow());
        }

        JsonObject data = new JsonObject();

        JsonArray jsonArray = new JsonArray();
        for (int i = 0; i < tbSupplierPoList.size(); i++) {
            TbSupplierQuotation tbSupplierQuotation =
                    tbSupplierQuotationRepository.findLatestBySuppPoId(
                            tbSupplierPoList.get(i).getID());

            TbSupplierPi tbSupplierPi =
                    tbSupplierPiRepository.findLatestBySuppQuotId(tbSupplierQuotation.getID());

            TbSupplierInvoice tbSupplierInvoice =
                    tbSupplierInvoiceRepository.findLatestBySuppPiId(tbSupplierPi.getID());

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("SUPP_PO_ID", tbSupplierPoList.get(i).getID());
            jsonObject.addProperty("ORDER_NUM", tbSupplierPoList.get(i).getPO_NUM());
            jsonObject.addProperty(
                    "MANAGER_APPROVAL_STATUS",
                    tbSupplierPoList.get(i).getMANAGER_APPROVAL_STATUS());
            jsonObject.addProperty(
                    "CREATED_ON",
                    String.valueOf(tbSupplierPoList.get(i).getTIMESTAMP()).split(" ")[0]);
            jsonObject.addProperty("TOTAL_AMOUNT", tbSupplierInvoice.getGRAND_TOTAL());
            jsonObject.addProperty("MM_FILE_NAME", tbMmList.get(i).getMM_FILE_NAME());
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
