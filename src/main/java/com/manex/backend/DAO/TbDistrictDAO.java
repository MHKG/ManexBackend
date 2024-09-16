package com.manex.backend.DAO;

import com.google.gson.JsonObject;

public interface TbDistrictDAO {
    JsonObject getAllByState(String stateId, String searchKeyword);
}
