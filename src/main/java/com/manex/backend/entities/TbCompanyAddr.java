package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_company_addr")
public class TbCompanyAddr {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "COMPANY_ID", nullable = false)
    private Integer companyId;

    @Column(name = "ADDR_ID", nullable = false)
    private Integer addrId;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "DEFAULT_ADDR")
    private Character defaultAddr;

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

    public Integer getAddrId() {
        return addrId;
    }

    public void setAddrId(Integer addrId) {
        this.addrId = addrId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Character getDefaultAddr() {
        return defaultAddr;
    }

    public void setDefaultAddr(Character defaultAddr) {
        this.defaultAddr = defaultAddr;
    }
}
