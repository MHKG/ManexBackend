package com.manex.backend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.manex.backend.DAO.TbLookupCurrencyDAO;
import com.manex.backend.entities.TbLookupCurrency;
import com.manex.backend.repositories.TbLookupCurrencyRepository;
import com.manex.backend.response.XscResponse;

import jakarta.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TbLookupCurrencyService implements TbLookupCurrencyDAO {

    @Autowired private TbLookupCurrencyRepository tbLookupCurrencyRepository;

    @Override
    public XscResponse listCurrencyUnit(JSONObject payload) throws JsonProcessingException {
        XscResponse response = new XscResponse();

        List<TbLookupCurrency> tbLookupCurrencyList =
                tbLookupCurrencyRepository.findAllBySearchKeyword(
                        payload.getString("SEARCH_KEYWORD"));

        JsonArray jsonArray = new JsonArray();

        for (TbLookupCurrency tbLookupCurrency : tbLookupCurrencyList) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("CURRENCY_ID", tbLookupCurrency.getID());
            jsonObject.addProperty("CURRENCY", tbLookupCurrency.getCURRENCY());

            jsonArray.add(jsonObject);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        response.setXscData(objectMapper.readTree(jsonArray.toString()));
        response.setXscMessage("Currency fetched successfully");
        response.setXscStatus(1);
        return response;
    }
}
