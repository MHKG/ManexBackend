package com.manex.backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.manex.backend.DAO.TbLookupCurrencyDAO;
import com.manex.backend.response.XscResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/currency_controller")
public class TbLookupCurrencyController {

    @Autowired private TbLookupCurrencyDAO tbLookupCurrencyDAO;

    @PostMapping("/listCurrencyUnit")
    private XscResponse listCurrencyUnit(@RequestParam("payload") JSONObject payload)
            throws JsonProcessingException {
        return tbLookupCurrencyDAO.listCurrencyUnit(payload);
    }
}
