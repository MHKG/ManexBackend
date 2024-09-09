package com.manex.backend.response;

import org.json.JSONObject;

public class XscResponse {
    private JSONObject XscData;
    private String XscMessage;
    private int XscStatus;

    public int getXscStatus() {
        return XscStatus;
    }

    public void setXscStatus(int xscStatus) {
        XscStatus = xscStatus;
    }

    public String getXscMessage() {
        return XscMessage;
    }

    public void setXscMessage(String xscMessage) {
        XscMessage = xscMessage;
    }

    public JSONObject getXscData() {
        return XscData;
    }

    public void setXscData(JSONObject xscData) {
        XscData = xscData;
    }
}
