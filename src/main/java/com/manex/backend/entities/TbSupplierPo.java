package com.manex.backend.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_supplier_po")
public class TbSupplierPo {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private String PO_NUM;

    @Column(nullable = false)
    private Integer APP_CLIENT_ID;

    @Column(nullable = false)
    private Integer CLIENT_SUPPLIER_ID;

    @Column private Date TIMESTAMP;

    @Column private Integer CREATED_BY;

    @Column private Integer MANAGER_APPROVAL_STATUS;

    @Column private Integer STATUS;

    @Column private Integer PO_MM;

    @Column private String DESCRIPTION;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getPO_NUM() {
        return PO_NUM;
    }

    public void setPO_NUM(String PO_NUM) {
        this.PO_NUM = PO_NUM;
    }

    public Integer getAPP_CLIENT_ID() {
        return APP_CLIENT_ID;
    }

    public void setAPP_CLIENT_ID(Integer APP_CLIENT_ID) {
        this.APP_CLIENT_ID = APP_CLIENT_ID;
    }

    public Integer getCLIENT_SUPPLIER_ID() {
        return CLIENT_SUPPLIER_ID;
    }

    public void setCLIENT_SUPPLIER_ID(Integer CLIENT_SUPPLIER_ID) {
        this.CLIENT_SUPPLIER_ID = CLIENT_SUPPLIER_ID;
    }

    public Date getTIMESTAMP() {
        return TIMESTAMP;
    }

    public void setTIMESTAMP(Date TIMESTAMP) {
        this.TIMESTAMP = TIMESTAMP;
    }

    public Integer getCREATED_BY() {
        return CREATED_BY;
    }

    public void setCREATED_BY(Integer CREATED_BY) {
        this.CREATED_BY = CREATED_BY;
    }

    public Integer getMANAGER_APPROVAL_STATUS() {
        return MANAGER_APPROVAL_STATUS;
    }

    public void setMANAGER_APPROVAL_STATUS(Integer MANAGER_APPROVAL_STATUS) {
        this.MANAGER_APPROVAL_STATUS = MANAGER_APPROVAL_STATUS;
    }

    public Integer getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(Integer STATUS) {
        this.STATUS = STATUS;
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
}
