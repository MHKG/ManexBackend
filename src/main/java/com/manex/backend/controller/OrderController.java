package com.manex.backend.controller;

import com.manex.backend.DAO.OrderDAO;
import com.manex.backend.response.XscResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order_controller")
public class OrderController {

    @Autowired private OrderDAO orderDAO;

    @PostMapping("/orderStatusFilter")
    private XscResponse orderStatusFilter(@RequestParam("payload") JSONObject payload) {
        return orderDAO.orderStatusFilter(payload);
    }

    @PostMapping("/paymentStatusFilter")
    private XscResponse paymentStatusFilter(@RequestParam("payload") JSONObject payload) {
        return orderDAO.paymentStatusFilter(payload);
    }

    @PostMapping("/getOrderList")
    private XscResponse getOrderList(@RequestParam("payload") JSONObject payload) {
        return orderDAO.getOrderList(payload);
    }
}
