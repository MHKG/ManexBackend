package com.manex.backend.GenericMethods;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GenericMethods {

    public static JsonNode convertGsonToJackson(JsonObject gsonObject) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonElement jsonElement = JsonParser.parseString(gsonObject.toString());
            return mapper.readTree(jsonElement.toString());
        } catch (Exception e) {
            throw new RuntimeException("Error converting Gson JsonObject to Jackson JsonNode", e);
        }
    }
}
