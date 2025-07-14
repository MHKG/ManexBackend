package com.manex.backend.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.manex.backend.DAO.TbCountryDAO;
import com.manex.backend.entities.TbCountry;
import com.manex.backend.repositories.TbCountryRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TbCountryService implements TbCountryDAO {

    @Autowired private TbCountryRepository tbCountryRepository;

    @Override
    public JsonObject getAllByKeyword(String SEARCH_KEYWORD) {
        List<TbCountry> tbCountries = tbCountryRepository.findAllByKeyword(SEARCH_KEYWORD);

        JsonObject countryObject = new JsonObject();
        JsonArray countryArray = new JsonArray();
        for (TbCountry tbCountry : tbCountries) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("COUNTRY", tbCountry.getCOUNTRY());
            jsonObject.addProperty("ID", tbCountry.getID());
            countryArray.add(jsonObject);
        }
        countryObject.add("COUNTRY_NAMES", countryArray);
        countryObject.addProperty("NEXT_PAGE", -1);

        return countryObject;
    }
}
