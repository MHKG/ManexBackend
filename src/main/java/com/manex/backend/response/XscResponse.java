package com.manex.backend.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class XscResponse {
    @JsonProperty("XscData")
    private JsonNode XscData;

    @JsonProperty("XscMessage")
    private String XscMessage;

    @JsonProperty("XscStatus")
    private int XscStatus;

    public int getXscStatus() {
        return XscStatus;
    }

    public void setXscStatus(int XscStatus) {
        this.XscStatus = XscStatus;
    }

    public String getXscMessage() {
        return XscMessage;
    }

    public void setXscMessage(String XscMessage) {
        this.XscMessage = XscMessage;
    }

    public JsonNode getXscData() {
        return XscData;
    }

    public void setXscData(JsonNode XscData) {
        this.XscData = XscData;
    }
}
