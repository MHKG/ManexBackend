package com.manex.backend.controller;

import com.manex.backend.DAO.TbSupplierPoDAO;
import com.manex.backend.response.XscResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplier_po_controller")
public class TbSupplierPoController {

    @Autowired private TbSupplierPoDAO tbSupplierPoDAO;

    @PostMapping("/selectPO")
    private XscResponse selectPO(@RequestParam("payload") JSONObject payload) {
        return tbSupplierPoDAO.selectPO(payload);
    }

    @PostMapping("/getClientSupplierDetails")
    private XscResponse getClientSupplierDetails(@RequestParam("payload") JSONObject payload) {
        return tbSupplierPoDAO.getClientSupplierDetails(payload);
    }

    @PostMapping("/getSupplierPo")
    private XscResponse getSupplierPo(@RequestParam("payload") JSONObject payload) {
        return tbSupplierPoDAO.getSupplierPo(payload);
    }

    @PostMapping("/listSupplierPo")
    private XscResponse listSupplierPo(@RequestParam("payload") JSONObject payload) {
        return tbSupplierPoDAO.listSupplierPo(payload);
    }
}
