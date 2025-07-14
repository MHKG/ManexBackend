package com.manex.backend.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
