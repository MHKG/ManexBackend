package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_state")
public class TbState {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private String STATE;

    @Column(nullable = false)
    private Integer COUNTRY_ID;

    @Column private String STATE_CODE;

    @Column private Boolean STATUS;

    @Column private Integer ZONE_ID;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getSTATE() {
        return STATE;
    }

    public void setSTATE(String STATE) {
        this.STATE = STATE;
    }

    public Integer getCOUNTRY_ID() {
        return COUNTRY_ID;
    }

    public void setCOUNTRY_ID(Integer COUNTRY_ID) {
        this.COUNTRY_ID = COUNTRY_ID;
    }

    public String getSTATE_CODE() {
        return STATE_CODE;
    }

    public void setSTATE_CODE(String STATE_CODE) {
        this.STATE_CODE = STATE_CODE;
    }

    public Boolean getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(Boolean STATUS) {
        this.STATUS = STATUS;
    }

    public Integer getZONE_ID() {
        return ZONE_ID;
    }

    public void setZONE_ID(Integer ZONE_ID) {
        this.ZONE_ID = ZONE_ID;
    }
}
