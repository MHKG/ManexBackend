package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_lookup_currency")
public class TbLookupCurrency {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private String CURRENCY_NAME;

    @Column(nullable = false)
    private String CURRENCY;

    @Column(nullable = false)
    private String CURRENCY_SYMBOL;

    @Column(nullable = false)
    private Integer COUNTRY_ID;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getCURRENCY_NAME() {
        return CURRENCY_NAME;
    }

    public void setCURRENCY_NAME(String CURRENCY_NAME) {
        this.CURRENCY_NAME = CURRENCY_NAME;
    }

    public String getCURRENCY() {
        return CURRENCY;
    }

    public void setCURRENCY(String CURRENCY) {
        this.CURRENCY = CURRENCY;
    }

    public String getCURRENCY_SYMBOL() {
        return CURRENCY_SYMBOL;
    }

    public void setCURRENCY_SYMBOL(String CURRENCY_SYMBOL) {
        this.CURRENCY_SYMBOL = CURRENCY_SYMBOL;
    }

    public Integer getCOUNTRY_ID() {
        return COUNTRY_ID;
    }

    public void setCOUNTRY_ID(Integer COUNTRY_ID) {
        this.COUNTRY_ID = COUNTRY_ID;
    }
}
