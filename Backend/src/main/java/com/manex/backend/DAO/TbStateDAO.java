package com.manex.backend.DAO;

import com.google.gson.JsonObject;

public interface TbStateDAO {
    JsonObject getAllStatesByCountry(String SEARCH_KEYWORD, String searchKeyword);
}
