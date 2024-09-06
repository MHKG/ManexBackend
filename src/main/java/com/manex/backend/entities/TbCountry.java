package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_country")
public class TbCountry {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "COUNTRY", nullable = false)
    private String country;

    @Column(name = "ISO3", length = 3, columnDefinition = "CHAR(3)")
    private String ISO3;

    @Column(name = "ISO2", length = 2, columnDefinition = "CHAR(2)")
    private String ISO2;

    @Column(name = "COUNTRY_CODE")
    private String countryCode;

    @Column(name = "CAPITAL")
    private String capital;

    @Column(name = "NATIVE")
    private String nativeField;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getISO3() {
        return ISO3;
    }

    public void setISO3(String ISO3) {
        this.ISO3 = ISO3;
    }

    public String getISO2() {
        return ISO2;
    }

    public void setISO2(String ISO2) {
        this.ISO2 = ISO2;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getNativeField() {
        return nativeField;
    }

    public void setNativeField(String nativeField) {
        this.nativeField = nativeField;
    }
}
