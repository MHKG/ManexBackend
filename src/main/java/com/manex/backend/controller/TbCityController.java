package com.manex.backend.controller;

import com.google.gson.JsonObject;
import com.manex.backend.DAO.TbCityDAO;
import com.manex.backend.GenericMethods.GenericMethods;
import com.manex.backend.response.XscResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/city_controller")
public class TbCityController {

    @Autowired private TbCityDAO cityDAO;

    @PostMapping("/getAllByDistrict")
    private XscResponse getAllByDistrict(
            @RequestParam("DISTRICT_ID") String DISTRICT_ID,
            @RequestParam("CURRENT_PAGE") String CURRENT_PAGE,
            @RequestParam("SEARCH_KEYWORD") String SEARCH_KEYWORD) {
        XscResponse response = new XscResponse();

        JsonObject countries = cityDAO.getAllByDistrict(DISTRICT_ID, SEARCH_KEYWORD);

        response.setXscData(GenericMethods.convertGsonToJackson(countries));
        response.setXscStatus(1);
        response.setXscMessage("Cities listed successfully");
        return response;
    }
}
