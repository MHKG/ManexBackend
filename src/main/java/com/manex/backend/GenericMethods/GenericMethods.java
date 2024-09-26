package com.manex.backend.GenericMethods;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;

public class GenericMethods {

    public static JsonNode convertGsonToJackson(JsonObject gsonObject) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readTree(gsonObject.toString());
        } catch (Exception e) {
            throw new RuntimeException("Error converting Gson JsonObject to Jackson JsonNode", e);
        }
    }
}
