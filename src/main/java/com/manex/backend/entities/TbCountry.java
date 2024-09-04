package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_country")
public class TbCountry implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "COUNTRY", nullable = false)
    private String country;

    @Column(name = "iso3")
    private String iso3;

    @Column(name = "iso2")
    private String iso2;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "CAPITAL")
    private String capital;

    @Column(name = "NATIVE")
    private String nativeField;
}
