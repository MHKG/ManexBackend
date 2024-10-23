package com.manex.backend.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentMethod {
    TT("T/T"),
    CASH("CASH"),
    CARD("CARD"),
    ONLINE("ONLINE"),
    OTHERS("OTHERS");

    private final String displayName;
}
