package com.manex.backend.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "tb_company")
public class TbCompany {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column private String NAME;

    @Column private String REG_NUMBER;

    @Column private String TAX_NUMBER;

    @Column private String CONTACT_NUMBER;

    @Column private String ALT_CONTACT_NUMBER;

    @Column private String EMAIL;

    @Column private String FAX;

    @Column private String WEBSITE;

    @Column private Integer LOGO;

    @Column private Date CREATED_DATE;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getREG_NUMBER() {
        return REG_NUMBER;
    }

    public void setREG_NUMBER(String REG_NUMBER) {
        this.REG_NUMBER = REG_NUMBER;
    }

    public String getTAX_NUMBER() {
        return TAX_NUMBER;
    }

    public void setTAX_NUMBER(String TAX_NUMBER) {
        this.TAX_NUMBER = TAX_NUMBER;
    }

    public String getCONTACT_NUMBER() {
        return CONTACT_NUMBER;
    }

    public void setCONTACT_NUMBER(String CONTACT_NUMBER) {
        this.CONTACT_NUMBER = CONTACT_NUMBER;
    }

    public String getALT_CONTACT_NUMBER() {
        return ALT_CONTACT_NUMBER;
    }

    public void setALT_CONTACT_NUMBER(String ALT_CONTACT_NUMBER) {
        this.ALT_CONTACT_NUMBER = ALT_CONTACT_NUMBER;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getFAX() {
        return FAX;
    }

    public void setFAX(String FAX) {
        this.FAX = FAX;
    }

    public String getWEBSITE() {
        return WEBSITE;
    }

    public void setWEBSITE(String WEBSITE) {
        this.WEBSITE = WEBSITE;
    }

    public Integer getLOGO() {
        return LOGO;
    }

    public void setLOGO(Integer LOGO) {
        this.LOGO = LOGO;
    }

    public Date getCREATED_DATE() {
        return CREATED_DATE;
    }

    public void setCREATED_DATE(Date CREATED_DATE) {
        this.CREATED_DATE = CREATED_DATE;
    }
}
