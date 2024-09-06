package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_client_supplier")
public class TbClientSupplier {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "COMPANY_ID", nullable = false)
    private Integer companyId;

    @Column(name = "APP_CLIENT_ID", nullable = false)
    private Integer appClientId;

    @Column(name = "SUPP_NUM", nullable = false)
    private String suppNum;

    @Column(name = "IS_SUPP_FAV")
    private Character suppFav;

    @Column(name = "STATUS")
    private Integer status;

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

    public Integer getAppClientId() {
        return appClientId;
    }

    public void setAppClientId(Integer appClientId) {
        this.appClientId = appClientId;
    }

    public String getSuppNum() {
        return suppNum;
    }

    public void setSuppNum(String suppNum) {
        this.suppNum = suppNum;
    }

    public Character getSuppFav() {
        return suppFav;
    }

    public void setSuppFav(Character suppFav) {
        this.suppFav = suppFav;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
