package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_app_client")
public class TbAppClient {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private Integer COMPANY_ID;

    @Column(nullable = false)
    private Integer OPERATING_CURRENCY;

    @Column private Integer CLIENT_ICON;

    @Column private String CLIENT_COLOR;

    @Column private Boolean STATUS;

    @Column private String CUST_NUM_FORMAT;

    @Column private String SUPP_NUM_FORMAT;

    @Column private String CUST_OR_NUM_FORMAT;

    @Column private String SUPP_OR_NUM_FORMAT;

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

    public Integer getOPERATING_CURRENCY() {
        return OPERATING_CURRENCY;
    }

    public void setOPERATING_CURRENCY(Integer OPERATING_CURRENCY) {
        this.OPERATING_CURRENCY = OPERATING_CURRENCY;
    }

    public Integer getCLIENT_ICON() {
        return CLIENT_ICON;
    }

    public void setCLIENT_ICON(Integer CLIENT_ICON) {
        this.CLIENT_ICON = CLIENT_ICON;
    }

    public String getCLIENT_COLOR() {
        return CLIENT_COLOR;
    }

    public void setCLIENT_COLOR(String CLIENT_COLOR) {
        this.CLIENT_COLOR = CLIENT_COLOR;
    }

    public Boolean getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(Boolean STATUS) {
        this.STATUS = STATUS;
    }

    public String getCUST_NUM_FORMAT() {
        return CUST_NUM_FORMAT;
    }

    public void setCUST_NUM_FORMAT(String CUST_NUM_FORMAT) {
        this.CUST_NUM_FORMAT = CUST_NUM_FORMAT;
    }

    public String getSUPP_NUM_FORMAT() {
        return SUPP_NUM_FORMAT;
    }

    public void setSUPP_NUM_FORMAT(String SUPP_NUM_FORMAT) {
        this.SUPP_NUM_FORMAT = SUPP_NUM_FORMAT;
    }

    public String getCUST_OR_NUM_FORMAT() {
        return CUST_OR_NUM_FORMAT;
    }

    public void setCUST_OR_NUM_FORMAT(String CUST_OR_NUM_FORMAT) {
        this.CUST_OR_NUM_FORMAT = CUST_OR_NUM_FORMAT;
    }

    public String getSUPP_OR_NUM_FORMAT() {
        return SUPP_OR_NUM_FORMAT;
    }

    public void setSUPP_OR_NUM_FORMAT(String SUPP_OR_NUM_FORMAT) {
        this.SUPP_OR_NUM_FORMAT = SUPP_OR_NUM_FORMAT;
    }
}
