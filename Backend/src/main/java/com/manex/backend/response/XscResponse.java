package com.manex.backend.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class XscResponse {
    @JsonProperty("XscData")
    private JsonNode XscData;

    @JsonProperty("XscMessage")
    private String XscMessage;

    @JsonProperty("XscStatus")
    private int XscStatus;

    public XscResponse(int XscStatus, String XscMessage) {
        this.XscStatus = XscStatus;
        this.XscMessage = XscMessage;
    }

    public XscResponse(int XscStatus) {
        this.XscStatus = XscStatus;
    }
}
