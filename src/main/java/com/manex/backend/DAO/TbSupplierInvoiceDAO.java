package com.manex.backend.DAO;

import com.manex.backend.response.XscResponse;
import org.json.JSONObject;

public interface TbSupplierInvoiceDAO {
	XscResponse paySupplierDisplay(JSONObject payload);

	XscResponse supplierInvoiceList(JSONObject payload);
}
