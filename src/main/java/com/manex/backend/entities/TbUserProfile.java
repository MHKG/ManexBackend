package com.manex.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "tb_user_profile")
public class TbUserProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "USER_ID", nullable = false)
    private Integer userId;

    @Column(name = "f_name")
    private String name;

    @Column(name = "m_name")
    private String mName;

    @Column(name = "l_name")
    private String lName;

    @Column(name = "PROFILE_IMG")
    private Integer profileImg;

    @Column(name = "country_code")
    private Integer countryCode;

    @Column(name = "phone_mobile")
    private String phoneMobile;

    @Column(name = "phone_work")
    private String phoneWork;

    @Column(name = "phone_work_ext")
    private String phoneWorkExt;
}
