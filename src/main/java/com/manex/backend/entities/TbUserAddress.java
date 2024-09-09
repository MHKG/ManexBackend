package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_user_address")
public class TbUserAddress {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private Integer USER_ID;

    @Column(nullable = false)
    private Integer ADDR_ID;

    @Column private Boolean STATUS;

    @Column private Character DEFAULT_ADDR;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(Integer USER_ID) {
        this.USER_ID = USER_ID;
    }

    public Integer getADDR_ID() {
        return ADDR_ID;
    }

    public void setADDR_ID(Integer ADDR_ID) {
        this.ADDR_ID = ADDR_ID;
    }

    public Boolean getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(Boolean STATUS) {
        this.STATUS = STATUS;
    }

    public Character getDEFAULT_ADDR() {
        return DEFAULT_ADDR;
    }

    public void setDEFAULT_ADDR(Character DEFAULT_ADDR) {
        this.DEFAULT_ADDR = DEFAULT_ADDR;
    }
}
