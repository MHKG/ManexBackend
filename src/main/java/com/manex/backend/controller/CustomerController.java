package com.manex.backend.controller;

import com.manex.backend.DAO.CustomerDAO;
import com.manex.backend.response.XscResponse;

import jakarta.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/customer_controller")
public class CustomerController {

    @Autowired private CustomerDAO customerDAO;

    @PostMapping("/addCustomer")
    private XscResponse addCustomer(
            HttpServletRequest request, @RequestParam("payload") JSONObject payload)
            throws IOException {
        return customerDAO.addCustomer(request, payload);
    }

    @PostMapping("/listCustomer")
    private XscResponse listCustomer(
            @RequestParam("APP_CLIENT_ID") String APP_CLIENT_ID,
            @RequestParam("CURRENT_PAGE") String CURRENT_PAGE,
            @RequestParam("ITEM_PER_PAGE") String ITEM_PER_PAGE,
            @RequestParam("SEARCH_KEYWORD") String SEARCH_KEYWORD) {
        return customerDAO.listCustomer(APP_CLIENT_ID, CURRENT_PAGE, ITEM_PER_PAGE, SEARCH_KEYWORD);
    }

    @PostMapping("/getCustomerDetails")
    private XscResponse getCustomerDetails(@RequestParam("CLIENT_CUST_ID") String CLIENT_CUST_ID) {
        return customerDAO.getCustomerDetails(CLIENT_CUST_ID);
    }

    @PostMapping("/updateCustomer")
    private XscResponse updateCustomer(@RequestParam("payload") JSONObject payload) {
        return customerDAO.updateCustomer(payload);
    }

    @PostMapping("/customerNameFilter")
    private XscResponse customerNameFilter(
            @RequestParam("APP_CLIENT_ID") String APP_CLIENT_ID,
            @RequestParam("SEARCH_KEYWORD") String SEARCH_KEYWORD,
            @RequestParam("CURRENT_PAGE") String CURRENT_PAGE,
            @RequestParam("ITEM_PER_PAGE") String ITEM_PER_PAGE) {
        return customerDAO.customerNameFilter(
                APP_CLIENT_ID, SEARCH_KEYWORD, CURRENT_PAGE, ITEM_PER_PAGE);
    }

    @PostMapping("/customerTypeFilter")
    private XscResponse customerTypeFilter(@RequestParam("APP_CLIENT_ID") String APP_CLIENT_ID) {
        return customerDAO.customerTypeFilter(APP_CLIENT_ID);
    }

    @PostMapping("/customerStatusFilter")
    private XscResponse customerStatusFilter(@RequestParam("APP_CLIENT_ID") String APP_CLIENT_ID) {
        return customerDAO.customerStatusFilter(APP_CLIENT_ID);
    }

    @PostMapping("/markCustomerFavourite")
    private XscResponse markCustomerFavourite(
            @RequestParam("CLIENT_CUST_ID") String CLIENT_CUST_ID,
            @RequestParam("IS_FAVOURITE") String IS_FAVOURITE) {
        return customerDAO.markCustomerFavourite(CLIENT_CUST_ID, IS_FAVOURITE);
    }

	@PostMapping("/deleteCustomer")
	private XscResponse deleteCustomer(@RequestParam("CLIENT_CUST_ID") String CLIENT_CUST_ID){
		return customerDAO.deleteCustomer(CLIENT_CUST_ID);
	}
}
