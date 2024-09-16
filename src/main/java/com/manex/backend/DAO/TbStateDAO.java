package com.manex.backend.DAO;

import com.google.gson.JsonObject;

public interface TbStateDAO {
    JsonObject getAllByCountry(String SEARCH_KEYWORD, String searchKeyword);
}
