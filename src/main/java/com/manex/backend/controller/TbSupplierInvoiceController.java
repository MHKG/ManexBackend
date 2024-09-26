package com.manex.backend.controller;

import com.manex.backend.DAO.TbSupplierInvoiceDAO;
import com.manex.backend.response.XscResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier_invoice_controller")
public class TbSupplierInvoiceController {

    @Autowired private TbSupplierInvoiceDAO tbSupplierInvoiceDAO;

    @PostMapping("/paySupplierDisplay")
    private XscResponse paySupplierDisplay(@RequestParam("payload") JSONObject payload) {
        return tbSupplierInvoiceDAO.paySupplierDisplay(payload);
    }

    @PostMapping("/supplierInvoiceList")
    private XscResponse supplierInvoiceList(@RequestParam("payload") JSONObject payload) {
        return tbSupplierInvoiceDAO.supplierInvoiceList(payload);
    }
}
