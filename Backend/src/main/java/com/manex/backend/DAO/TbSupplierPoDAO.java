package com.manex.backend.DAO;

import com.manex.backend.response.XscResponse;

import org.json.JSONObject;

public interface TbSupplierPoDAO {
    XscResponse selectPO(JSONObject payload);

    XscResponse getClientSupplierDetails(JSONObject payload);

    XscResponse getSupplierPo(JSONObject payload);

    XscResponse listSupplierPo(JSONObject payload);
}
