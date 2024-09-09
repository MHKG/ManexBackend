package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_customer_po")
public class TbCustomerPo {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column private String CUST_PO_NUM;

    @Column(nullable = false)
    private Integer APP_CLIENT_ID;

    @Column(nullable = false)
    private Integer CLIENT_CUST_ID;

    @Column private Integer CREATED_ON;

    @Column private Integer CREATED_BY;

    @Column private Boolean MANAGER_APPROVAL_STATUS;

    @Column private Integer PO_MM;

    @Column private String DESCRIPTION;

    @Column private Boolean STATUS;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getCUST_PO_NUM() {
        return CUST_PO_NUM;
    }

    public void setCUST_PO_NUM(String CUST_PO_NUM) {
        this.CUST_PO_NUM = CUST_PO_NUM;
    }

    public Integer getAPP_CLIENT_ID() {
        return APP_CLIENT_ID;
    }

    public void setAPP_CLIENT_ID(Integer APP_CLIENT_ID) {
        this.APP_CLIENT_ID = APP_CLIENT_ID;
    }

    public Integer getCLIENT_CUST_ID() {
        return CLIENT_CUST_ID;
    }

    public void setCLIENT_CUST_ID(Integer CLIENT_CUST_ID) {
        this.CLIENT_CUST_ID = CLIENT_CUST_ID;
    }

    public Integer getCREATED_ON() {
        return CREATED_ON;
    }

    public void setCREATED_ON(Integer CREATED_ON) {
        this.CREATED_ON = CREATED_ON;
    }

    public Integer getCREATED_BY() {
        return CREATED_BY;
    }

    public void setCREATED_BY(Integer CREATED_BY) {
        this.CREATED_BY = CREATED_BY;
    }

    public Boolean getMANAGER_APPROVAL_STATUS() {
        return MANAGER_APPROVAL_STATUS;
    }

    public void setMANAGER_APPROVAL_STATUS(Boolean MANAGER_APPROVAL_STATUS) {
        this.MANAGER_APPROVAL_STATUS = MANAGER_APPROVAL_STATUS;
    }

    public Integer getPO_MM() {
        return PO_MM;
    }

    public void setPO_MM(Integer PO_MM) {
        this.PO_MM = PO_MM;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public Boolean getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(Boolean STATUS) {
        this.STATUS = STATUS;
    }
}
