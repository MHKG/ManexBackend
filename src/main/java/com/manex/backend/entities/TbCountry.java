package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_country")
public class TbCountry {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(name = "COUNTRY", nullable = false)
    private String COUNTRY;

    @Column(name = "ISO3", length = 3, columnDefinition = "CHAR(3)")
    private String ISO3;

    @Column(name = "ISO2", length = 2, columnDefinition = "CHAR(2)")
    private String ISO2;

    @Column(name = "COUNTRY_CODE")
    private String COUNTRY_CODE;

    @Column(name = "CAPITAL")
    private String CAPITAL;

    @Column(name = "NATIVE")
    private String NATIVE;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getCOUNTRY() {
        return COUNTRY;
    }

    public void setCOUNTRY(String COUNTRY) {
        this.COUNTRY = COUNTRY;
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

    public String getCOUNTRY_CODE() {
        return COUNTRY_CODE;
    }

    public void setCOUNTRY_CODE(String COUNTRY_CODE) {
        this.COUNTRY_CODE = COUNTRY_CODE;
    }

    public String getCAPITAL() {
        return CAPITAL;
    }

    public void setCAPITAL(String CAPITAL) {
        this.CAPITAL = CAPITAL;
    }

    public String getNATIVE() {
        return NATIVE;
    }

    public void setNATIVE(String NATIVE) {
        this.NATIVE = NATIVE;
    }
}
