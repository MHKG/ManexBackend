package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_client_cust")
public class TbClientCust {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private Integer COMPANY_ID;

    @Column(nullable = false)
    private Integer APP_CLIENT_ID;

    @Column(nullable = false)
    private String CUST_NUM;

    @Column private Character IS_CUST_FAV;

    @Column private Integer STATUS;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getCOMPANY_ID() {
        return COMPANY_ID;
    }

    public void setCOMPANY_ID(Integer COMPANY_ID) {
        this.COMPANY_ID = COMPANY_ID;
    }

    public Integer getAPP_CLIENT_ID() {
        return APP_CLIENT_ID;
    }

    public void setAPP_CLIENT_ID(Integer APP_CLIENT_ID) {
        this.APP_CLIENT_ID = APP_CLIENT_ID;
    }

    public String getCUST_NUM() {
        return CUST_NUM;
    }

    public void setCUST_NUM(String CUST_NUM) {
        this.CUST_NUM = CUST_NUM;
    }

    public Character getIS_CUST_FAV() {
        return IS_CUST_FAV;
    }

    public void setIS_CUST_FAV(Character IS_CUST_FAV) {
        this.IS_CUST_FAV = IS_CUST_FAV;
    }

    public Integer getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(Integer STATUS) {
        this.STATUS = STATUS;
    }
}
