package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_all_addr")
public class TbAllAddr {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private Integer APP_CLIENT_ID;

    @Column(nullable = false)
    private String ADDR_1;

    @Column private String ADDR_2;

    @Column(nullable = false)
    private Integer COUNTRY_ID;

    @Column private Integer STATE_ID;

    @Column private Integer DISTRICT_ID;

    @Column private Integer CITY_ID;

    @Column private String POSTAL_CODE;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getAPP_CLIENT_ID() {
        return APP_CLIENT_ID;
    }

    public void setAPP_CLIENT_ID(Integer APP_CLIENT_ID) {
        this.APP_CLIENT_ID = APP_CLIENT_ID;
    }

    public String getADDR_1() {
        return ADDR_1;
    }

    public void setADDR_1(String ADDR_1) {
        this.ADDR_1 = ADDR_1;
    }

    public String getADDR_2() {
        return ADDR_2;
    }

    public void setADDR_2(String ADDR_2) {
        this.ADDR_2 = ADDR_2;
    }

    public Integer getCOUNTRY_ID() {
        return COUNTRY_ID;
    }

    public void setCOUNTRY_ID(Integer COUNTRY_ID) {
        this.COUNTRY_ID = COUNTRY_ID;
    }

    public Integer getSTATE_ID() {
        return STATE_ID;
    }

    public void setSTATE_ID(Integer STATE_ID) {
        this.STATE_ID = STATE_ID;
    }

    public Integer getDISTRICT_ID() {
        return DISTRICT_ID;
    }

    public void setDISTRICT_ID(Integer DISTRICT_ID) {
        this.DISTRICT_ID = DISTRICT_ID;
    }

    public Integer getCITY_ID() {
        return CITY_ID;
    }

    public void setCITY_ID(Integer CITY_ID) {
        this.CITY_ID = CITY_ID;
    }

    public String getPOSTAL_CODE() {
        return POSTAL_CODE;
    }

    public void setPOSTAL_CODE(String POSTAL_CODE) {
        this.POSTAL_CODE = POSTAL_CODE;
    }
}
