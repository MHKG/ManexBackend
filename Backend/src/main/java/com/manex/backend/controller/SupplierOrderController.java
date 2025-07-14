package com.manex.backend.controller;

import com.manex.backend.DAO.SupplierOrderDAO;
import com.manex.backend.response.XscResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order_controller")
public class SupplierOrderController {

    @Autowired private SupplierOrderDAO supplierOrderDAO;

    @PostMapping("/orderStatusFilter")
    private XscResponse orderStatusFilter(@RequestParam("payload") JSONObject payload) {
        return supplierOrderDAO.orderStatusFilter(payload);
    }

    @PostMapping("/paymentStatusFilter")
    private XscResponse paymentStatusFilter(@RequestParam("payload") JSONObject payload) {
        return supplierOrderDAO.paymentStatusFilter(payload);
    }

    @PostMapping("/getOrderList")
    private XscResponse getOrderList(@RequestParam("payload") JSONObject payload) {
        return supplierOrderDAO.getOrderList(payload);
    }
}
