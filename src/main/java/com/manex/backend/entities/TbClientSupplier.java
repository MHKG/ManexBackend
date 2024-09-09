package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_client_supplier")
public class TbClientSupplier {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private Integer COMPANY_ID;

    @Column(nullable = false)
    private Integer APP_CLIENT_ID;

    @Column(nullable = false)
    private String SUPP_NUM;

    @Column private Character IS_SUPP_FAV;

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

    public String getSUPP_NUM() {
        return SUPP_NUM;
    }

    public void setSUPP_NUM(String SUPP_NUM) {
        this.SUPP_NUM = SUPP_NUM;
    }

    public Character getIS_SUPP_FAV() {
        return IS_SUPP_FAV;
    }

    public void setIS_SUPP_FAV(Character IS_SUPP_FAV) {
        this.IS_SUPP_FAV = IS_SUPP_FAV;
    }

    public Integer getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(Integer STATUS) {
        this.STATUS = STATUS;
    }
}
