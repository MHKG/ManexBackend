package com.manex.backend.controller;

import com.google.gson.JsonObject;
import com.manex.backend.DAO.TbCountryDAO;
import com.manex.backend.GenericMethods.GenericMethods;
import com.manex.backend.response.XscResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/country_controller")
public class TbCountryController {

    @Autowired private TbCountryDAO countryDAO;

    @PostMapping("/getCountries")
    private XscResponse getCountries(@RequestParam("payload") JSONObject payload) {
        XscResponse response = new XscResponse();

        JsonObject countries = countryDAO.getAllByKeyword(payload.getString("SEARCH_KEYWORD"));

        response.setXscData(GenericMethods.convertGsonToJackson(countries));
        response.setXscStatus(1);
        response.setXscMessage("Countries listed successfully");
        return response;
    }
}
