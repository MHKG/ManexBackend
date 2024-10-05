package com.manex.backend.DAO;

import com.manex.backend.response.XscResponse;

import jakarta.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public interface CustomerDAO {
    XscResponse addCustomer(HttpServletRequest request, JSONObject payload) throws IOException;

    XscResponse listCustomer(String appClientId, String searchKeyword);

    XscResponse getCustomerDetails(String clientCustomerId);

    XscResponse updateCustomer(JSONObject payload);

    XscResponse customerNameFilter(JSONObject payload);

    XscResponse customerTypeFilter(String appClientId);

    XscResponse customerStatusFilter(String appClientId);

    XscResponse markCustomerFavourite(int clientSuppId, String isFavourite);

    XscResponse deleteCustomer(String clientCustId);

    XscResponse addAllCustomers(int appClientId, JSONArray list);

    XscResponse getCustomersByNames(JSONObject payload);
}
