package com.manex.backend.DAO;

import com.google.gson.JsonObject;

public interface TbCountryDAO {
	JsonObject getAllByKeyword(String SEARCH_KEYWORD);
}
