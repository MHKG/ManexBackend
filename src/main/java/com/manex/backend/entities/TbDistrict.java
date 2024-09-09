package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_district")
public class TbDistrict {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private String DISTRICT;

    @Column(nullable = false)
    private Integer STATE_ID;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getDISTRICT() {
        return DISTRICT;
    }

    public void setDISTRICT(String DISTRICT) {
        this.DISTRICT = DISTRICT;
    }

    public Integer getSTATE_ID() {
        return STATE_ID;
    }

    public void setSTATE_ID(Integer STATE_ID) {
        this.STATE_ID = STATE_ID;
    }
}
