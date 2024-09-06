package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_lookup_currency")
public class TbLookupCurrency {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CURRENCY_NAME", nullable = false)
    private String currencyName;

    @Column(name = "CURRENCY", nullable = false)
    private String currency;

    @Column(name = "CURRENCY_SYMBOL", nullable = false)
    private String currencySymbol;

    @Column(name = "COUNTRY_ID", nullable = false)
    private Integer countryId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }
}
