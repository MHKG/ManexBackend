package com.manex.backend.DAO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.manex.backend.response.XscResponse;

import org.json.JSONObject;

public interface TbLookupCurrencyDAO {
    XscResponse listCurrencyUnit(JSONObject payload) throws JsonProcessingException;
}
