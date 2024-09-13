package com.manex.backend.controller;

import com.google.gson.JsonObject;
import com.manex.backend.DAO.TbCountryDAO;
import com.manex.backend.GenericMethods.GenericMethods;
import com.manex.backend.response.XscResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/country_controller")
public class TbCountryController {

    @Autowired private TbCountryDAO countryDAO;

    @PostMapping("/getCountries")
    private XscResponse getCountries(
            @RequestParam("CURRENT_PAGE") String CURRENT_PAGE,
            @RequestParam("SEARCH_KEYWORD") String SEARCH_KEYWORD) {
        XscResponse response = new XscResponse();

        JsonObject countries = countryDAO.getAllByKeyword(SEARCH_KEYWORD);

        response.setXscData(GenericMethods.convertGsonToJackson(countries));
        response.setXscStatus(1);
        response.setXscMessage("Countries listed successfully");
        return response;
    }
}
