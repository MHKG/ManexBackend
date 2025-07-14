package com.manex.backend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_user_profile")
public class TbUserProfile {

    @Id
    @Column(nullable = false)
    private Integer USER_ID;

    @Column
    @JsonProperty("F_NAME")
    private String F_NAME;

    @Column
    @JsonProperty("M_NAME")
    private String M_NAME;

    @Column
    @JsonProperty("L_NAME")
    private String L_NAME;

    @Column private Integer PROFILE_IMG;

    @Column(columnDefinition = "smallint")
    private Integer COUNTRY_CODE;

    @Column private String PHONE_MOBILE;

    @Column private String PHONE_WORK;

    @Column private String PHONE_WORK_EXT;
}
