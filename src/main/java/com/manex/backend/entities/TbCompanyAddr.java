package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_company_addr")
public class TbCompanyAddr {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private Integer COMPANY_ID;

    @Column(nullable = false)
    private Integer ADDR_ID;

    @Column private Integer STATUS;

    @Column private Character DEFAULT_ADDR;

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

    public Integer getADDR_ID() {
        return ADDR_ID;
    }

    public void setADDR_ID(Integer ADDR_ID) {
        this.ADDR_ID = ADDR_ID;
    }

    public Integer getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(Integer STATUS) {
        this.STATUS = STATUS;
    }

    public Character getDEFAULT_ADDR() {
        return DEFAULT_ADDR;
    }

    public void setDEFAULT_ADDR(Character DEFAULT_ADDR) {
        this.DEFAULT_ADDR = DEFAULT_ADDR;
    }
}
