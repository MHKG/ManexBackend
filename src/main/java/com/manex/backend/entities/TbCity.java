package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_city")
public class TbCity {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private String CITY;

    @Column(nullable = false)
    private Integer DISTRICT_ID;

    @Column private Double LATITUDE;

    @Column private Double LONGITUDE;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public Integer getDISTRICT_ID() {
        return DISTRICT_ID;
    }

    public void setDISTRICT_ID(Integer DISTRICT_ID) {
        this.DISTRICT_ID = DISTRICT_ID;
    }

    public Double getLATITUDE() {
        return LATITUDE;
    }

    public void setLATITUDE(Double LATITUDE) {
        this.LATITUDE = LATITUDE;
    }

    public Double getLONGITUDE() {
        return LONGITUDE;
    }

    public void setLONGITUDE(Double LONGITUDE) {
        this.LONGITUDE = LONGITUDE;
    }
}
