package com.manex.backend.DAO;

import com.google.gson.JsonObject;

public interface TbCityDAO {
	JsonObject getAllByDistrict(String DISTRICT_ID, String searchKeyword);
}
