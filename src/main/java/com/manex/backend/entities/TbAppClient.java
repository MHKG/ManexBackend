package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_app_client")
public class TbAppClient {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "COMPANY_ID", nullable = false)
    private Integer companyId;

    @Column(name = "OPERATING_CURRENCY", nullable = false)
    private Integer operatingCurrency;

    @Column(name = "CLIENT_ICON")
    private Integer clientIcon;

    @Column(name = "CLIENT_COLOR")
    private String clientColor;

    @Column(name = "STATUS")
    private Boolean status;

    @Column(name = "CUST_NUM_FORMAT")
    private String custNumFormat;

    @Column(name = "SUPP_NUM_FORMAT")
    private String suppNumFormat;

    @Column(name = "CUST_OR_NUM_FORMAT")
    private String custOrNumFormat;

    @Column(name = "SUPP_OR_NUM_FORMAT")
    private String suppOrNumFormat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getOperatingCurrency() {
        return operatingCurrency;
    }

    public void setOperatingCurrency(Integer operatingCurrency) {
        this.operatingCurrency = operatingCurrency;
    }

    public Integer getClientIcon() {
        return clientIcon;
    }

    public void setClientIcon(Integer clientIcon) {
        this.clientIcon = clientIcon;
    }

    public String getClientColor() {
        return clientColor;
    }

    public void setClientColor(String clientColor) {
        this.clientColor = clientColor;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean isStatus() {
        return status;
    }

    public String getCustNumFormat() {
        return custNumFormat;
    }

    public void setCustNumFormat(String custNumFormat) {
        this.custNumFormat = custNumFormat;
    }

    public String getSuppNumFormat() {
        return suppNumFormat;
    }

    public void setSuppNumFormat(String suppNumFormat) {
        this.suppNumFormat = suppNumFormat;
    }

    public String getCustOrNumFormat() {
        return custOrNumFormat;
    }

    public void setCustOrNumFormat(String custOrNumFormat) {
        this.custOrNumFormat = custOrNumFormat;
    }

    public String getSuppOrNumFormat() {
        return suppOrNumFormat;
    }

    public void setSuppOrNumFormat(String suppOrNumFormat) {
        this.suppOrNumFormat = suppOrNumFormat;
    }
}
