package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_all_addr")
public class TbAllAddr implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "APP_CLIENT_ID", nullable = false)
    private Integer appClientId;

    @Column(name = "ADDR_1", nullable = false)
    private String addr1;

    @Column(name = "ADDR_2")
    private String addr2;

    @Column(name = "COUNTRY_ID", nullable = false)
    private Integer countryId;

    @Column(name = "STATE_ID")
    private Integer stateId;

    @Column(name = "DISTRICT_ID")
    private Integer districtId;

    @Column(name = "CITY_ID")
    private Integer cityId;

    @Column(name = "postal_code")
    private String postalCode;
}
