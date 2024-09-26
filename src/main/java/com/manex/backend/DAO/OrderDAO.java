package com.manex.backend.DAO;

import com.manex.backend.response.XscResponse;
import org.json.JSONObject;

public interface OrderDAO {
	XscResponse orderStatusFilter(JSONObject payload);

	XscResponse paymentStatusFilter(JSONObject payload);

	XscResponse getOrderList(JSONObject payload);
}
