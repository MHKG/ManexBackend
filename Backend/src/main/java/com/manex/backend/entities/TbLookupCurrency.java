package com.manex.backend.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
