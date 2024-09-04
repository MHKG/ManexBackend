package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_lookup_currency")
public class TbLookupCurrency implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "currency_name", nullable = false)
    private String currencyName;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "currency_symbol", nullable = false)
    private String currencySymbol;

    @Column(name = "COUNTRY_ID", nullable = false)
    private Integer countryId;
}
