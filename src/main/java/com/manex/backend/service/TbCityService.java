package com.manex.backend.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.manex.backend.DAO.TbCityDAO;
import com.manex.backend.entities.TbCity;
import com.manex.backend.repositories.TbCityRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TbCityService implements TbCityDAO {

    @Autowired private TbCityRepository tbCityRepository;

    @Override
    public JsonObject getAllByDistrict(String DISTRICT_ID, String SEARCH_KEYWORD) {
        List<TbCity> tbCities =
                tbCityRepository.findAllByDistrictIdAndKeyword(
                        Integer.parseInt(DISTRICT_ID), SEARCH_KEYWORD);

        JsonObject cityObject = new JsonObject();
        JsonArray cityArray = new JsonArray();
        for (TbCity tbCity : tbCities) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("CITY", tbCity.getCITY());
            jsonObject.addProperty("ID", tbCity.getID());
            cityArray.add(jsonObject);
        }
        cityObject.add("CITY_NAMES", cityArray);
        cityObject.addProperty("NEXT_PAGE", 2);

        return cityObject;
    }
}
