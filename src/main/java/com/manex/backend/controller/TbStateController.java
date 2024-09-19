package com.manex.backend.controller;

import com.google.gson.JsonObject;
import com.manex.backend.DAO.TbStateDAO;
import com.manex.backend.GenericMethods.GenericMethods;
import com.manex.backend.response.XscResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/state_controller")
public class TbStateController {

    @Autowired private TbStateDAO stateDAO;

    @PostMapping("/getAllStatesByCountry")
    private XscResponse getAllStatesByCountry(
            @RequestParam("COUNTRY_ID") String COUNTRY_ID,
            @RequestParam("CURRENT_PAGE") String CURRENT_PAGE,
            @RequestParam("SEARCH_KEYWORD") String SEARCH_KEYWORD) {
        XscResponse response = new XscResponse();

        JsonObject countries = stateDAO.getAllStatesByCountry(COUNTRY_ID, SEARCH_KEYWORD);

        response.setXscData(GenericMethods.convertGsonToJackson(countries));
        response.setXscStatus(1);
        response.setXscMessage("States listed successfully");
        return response;
    }
}
