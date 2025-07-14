package com.manex.backend.DAO;

import com.google.gson.JsonObject;

public interface TbDistrictDAO {
    JsonObject getAllDistrictsByState(String stateId, String searchKeyword);
}
