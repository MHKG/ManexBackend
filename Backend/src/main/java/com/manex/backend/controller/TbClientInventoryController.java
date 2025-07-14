package com.manex.backend.controller;

import com.manex.backend.DAO.TbClientInventoryDAO;
import com.manex.backend.response.XscResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client_inventory_controller")
public class TbClientInventoryController {

    @Autowired private TbClientInventoryDAO tbClientInventoryDAO;

    @PostMapping("/getInventoryDetails")
    private XscResponse getInventoryDetails(@RequestParam("payload") JSONObject payload) {
        return tbClientInventoryDAO.getInventoryDetails(payload);
    }

    @PostMapping("/viewPurchaseHistory")
    private XscResponse viewPurchaseHistory(@RequestParam("payload") JSONObject payload) {
        return tbClientInventoryDAO.viewPurchaseHistory(payload);
    }
}
