package com.manex.backend.DAO;

import com.manex.backend.response.XscResponse;

import jakarta.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public interface CustomerDAO {
    XscResponse addCustomer(HttpServletRequest request, JSONObject payload) throws IOException;

    XscResponse listCustomer(
            String appClientId, String currentPage, String itemPerPage, String searchKeyword);

    XscResponse getCustomerDetails(String clientCustomerId);

    XscResponse updateCustomer(JSONObject payload);

    XscResponse customerNameFilter(
            String appClientId, String searchKeyword, String currentPage, String itemPerPage);

    XscResponse customerTypeFilter(String appClientId);

    XscResponse customerStatusFilter(String appClientId);

    XscResponse markCustomerFavourite(String clientSuppId, String isFavourite);

    XscResponse deleteCustomer(String clientCustId);

    XscResponse addAllCustomers(int appClientId, JSONArray list);

    XscResponse getCustomersByNames(JSONObject payload);
}
