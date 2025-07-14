package com.manex.backend.DAO;

import com.manex.backend.response.XscResponse;

import org.json.JSONObject;

public interface TbClientInventoryDAO {
    XscResponse getInventoryDetails(JSONObject payload);

    XscResponse viewPurchaseHistory(JSONObject payload);
}
