package com.manex.backend.GenericMethods;

import com.manex.backend.response.XscResponse;

import org.json.JSONObject;

public class Validations {

    public static XscResponse validateFields(JSONObject payload) {
        XscResponse response = new XscResponse(0);

        if (GenericMethods.isNullOrEmpty(payload.getString("NAME"), true)) {
            response.setXscMessage("Name cannot be null.");
            return response;
        }

        if (GenericMethods.isNullOrEmpty(payload.getString("ADDR_1"), true)) {
            response.setXscMessage("Address line 1 cannot be null.");
            return response;
        }

        if (GenericMethods.isNullOrEmpty(payload.getString("CONTACT_NUMBER"), true)) {
            response.setXscMessage("Contact Number cannot be null.");
            return response;
        }

        if (GenericMethods.isNullOrEmpty(payload.getString("COUNTRY_ID"), true)) {
            response.setXscMessage("Country Id cannot be null.");
            return response;
        }

        if (GenericMethods.isNullOrEmpty(payload.getString("EMAIL"), true)) {
            response.setXscMessage("Email cannot be null.");
            return response;
        } else if (!GenericMethods.regexChecker(
                payload.getString("EMAIL"), new String[] {"Email"}, true)) {
            response.setXscMessage("Enter correct email.");
            return response;
        }

        if (GenericMethods.isNullOrEmpty(payload.getString("REG_NUMBER"), true)) {
            response.setXscMessage("Reg Number cannot be null.");
            return response;
        }

        if (GenericMethods.isNullOrEmpty(payload.getString("CITY_ID"), true)) {
            response.setXscMessage("City Id cannot be null.");
            return response;
        }

        if (GenericMethods.isNullOrEmpty(payload.getString("DISTRICT_ID"), true)) {
            response.setXscMessage("District Id cannot be null.");
            return response;
        }

        if (GenericMethods.isNullOrEmpty(payload.getString("POSTAL_CODE"), true)) {
            response.setXscMessage("Postal Code cannot be null.");
            return response;
        }

        if (GenericMethods.isNullOrEmpty(payload.getString("WEBSITE"), true)) {
            response.setXscMessage("Website cannot be null.");
            return response;
        }

        response.setXscStatus(1);
        return response;
    }
}
