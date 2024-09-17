package com.manex.backend.DAO;

import com.google.gson.JsonObject;

public interface TbCityDAO {
    JsonObject getAllCitiesByDistrict(String DISTRICT_ID, String searchKeyword);
}
