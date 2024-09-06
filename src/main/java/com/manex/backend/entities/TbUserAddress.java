package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_user_address")
public class TbUserAddress {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "USER_ID", nullable = false)
    private Integer userId;

    @Column(name = "ADDR_ID", nullable = false)
    private Integer addrId;

    @Column(name = "STATUS")
    private Boolean status;

    @Column(name = "DEFAULT_ADDR")
    private Character defaultAddr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAddrId() {
        return addrId;
    }

    public void setAddrId(Integer addrId) {
        this.addrId = addrId;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean isStatus() {
        return status;
    }

    public Character getDefaultAddr() {
        return defaultAddr;
    }

    public void setDefaultAddr(Character defaultAddr) {
        this.defaultAddr = defaultAddr;
    }
}
