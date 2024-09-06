package com.manex.backend.enums;

public enum PaymentMethod {
    TT("T/T"),
    CASH("CASH"),
    CARD("CARD"),
    ONLINE("ONLINE"),
    OTHERS("OTHERS");

    private final String displayName;

    PaymentMethod(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
