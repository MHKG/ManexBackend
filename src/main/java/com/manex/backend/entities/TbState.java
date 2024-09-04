package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_state")
public class TbState implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "STATE", nullable = false)
    private String state;

    @Column(name = "COUNTRY_ID", nullable = false)
    private Integer countryId;

    @Column(name = "state_code")
    private String stateCode;

    @Column(name = "STATUS")
    private Boolean status;

    @Column(name = "ZONE_ID")
    private Integer zoneId;
}
