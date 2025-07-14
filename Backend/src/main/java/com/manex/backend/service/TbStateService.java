package com.manex.backend.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.manex.backend.DAO.TbStateDAO;
import com.manex.backend.entities.TbState;
import com.manex.backend.repositories.TbStateRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TbStateService implements TbStateDAO {

    @Autowired private TbStateRepository tbStateRepository;

    @Override
    public JsonObject getAllStatesByCountry(String COUNTRY_ID, String SEARCH_KEYWORD) {
        List<TbState> tbStates =
                tbStateRepository.findAllByCountryIdAndKeyword(
                        Integer.parseInt(COUNTRY_ID), SEARCH_KEYWORD);

        JsonObject stateObject = new JsonObject();
        JsonArray stateArray = new JsonArray();
        for (TbState tbState : tbStates) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("STATE", tbState.getSTATE());
            jsonObject.addProperty("ID", tbState.getID());
            stateArray.add(jsonObject);
        }
        stateObject.add("STATE_NAMES", stateArray);
        stateObject.addProperty("NEXT_PAGE", -1);

        return stateObject;
    }
}
