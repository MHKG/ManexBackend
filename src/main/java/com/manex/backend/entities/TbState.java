package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_state")
public class TbState {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "STATE", nullable = false)
    private String state;

    @Column(name = "COUNTRY_ID", nullable = false)
    private Integer countryId;

    @Column(name = "STATE_CODE")
    private String stateCode;

    @Column(name = "STATUS")
    private Boolean status;

    @Column(name = "ZONE_ID")
    private Integer zoneId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean isStatus() {
        return status;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }
}
