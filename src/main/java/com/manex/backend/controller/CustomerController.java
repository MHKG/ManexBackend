package com.manex.backend.controller;

import com.manex.backend.DAO.CustomerDAO;
import com.manex.backend.GenericMethods.Validations;
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
        XscResponse response = Validations.validateFields(payload);
        if (response.getXscStatus() == 0) {
            return response;
        }
        return customerDAO.addCustomer(request, payload);
    }

    @PostMapping("/listCustomer")
    private XscResponse listCustomer(@RequestParam("payload") JSONObject payload) {
        return customerDAO.listCustomer(payload);
    }

    @PostMapping("/getCustomerDetails")
    private XscResponse getCustomerDetails(@RequestParam("payload") JSONObject payload) {
        return customerDAO.getCustomerDetails(payload.getString("CLIENT_CUST_ID"));
    }

    @PostMapping("/updateCustomer")
    private XscResponse updateCustomer(@RequestParam("payload") JSONObject payload) {
        return customerDAO.updateCustomer(payload);
    }

    @PostMapping("/customerNameFilter")
    private XscResponse customerNameFilter(@RequestParam("payload") JSONObject payload) {
        return customerDAO.customerNameFilter(payload);
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
    private XscResponse markCustomerFavourite(@RequestParam("payload") JSONObject payload) {
        return customerDAO.markCustomerFavourite(
                payload.getInt("CLIENT_CUST_ID"), payload.getString("IS_FAVOURITE"));
    }

    @PostMapping("/deleteCustomer")
    private XscResponse deleteCustomer(@RequestParam("payload") JSONObject payload) {
        return customerDAO.deleteCustomer(payload.getString("CLIENT_CUST_ID"));
    }

    @PostMapping("/addAllCustomers")
    private XscResponse addALLCustomers(@RequestParam("payload") JSONObject payload) {
        return customerDAO.addAllCustomers(
                payload.getInt("APP_CLIENT_ID"), payload.getJSONArray("LIST"));
    }

    @PostMapping("/getCustomersByNames")
    private XscResponse getCustomersByNames(@RequestParam("payload") JSONObject payload) {
        return customerDAO.getCustomersByNames(payload);
    }
}
