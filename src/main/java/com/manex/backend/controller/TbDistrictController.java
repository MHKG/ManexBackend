package com.manex.backend.controller;

import com.google.gson.JsonObject;
import com.manex.backend.DAO.TbDistrictDAO;
import com.manex.backend.GenericMethods.GenericMethods;
import com.manex.backend.response.XscResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/district_controller")
public class TbDistrictController {

    @Autowired private TbDistrictDAO districtDAO;

    @PostMapping("/getAllByState")
    private XscResponse getAllByState(
            @RequestParam("STATE_ID") String STATE_ID,
            @RequestParam("CURRENT_PAGE") String CURRENT_PAGE,
            @RequestParam("SEARCH_KEYWORD") String SEARCH_KEYWORD) {
        XscResponse response = new XscResponse();

        JsonObject countries = districtDAO.getAllByState(STATE_ID, SEARCH_KEYWORD);

        response.setXscData(GenericMethods.convertGsonToJackson(countries));
        response.setXscStatus(1);
        response.setXscMessage("Districts listed successfully");
        return response;
    }
}
