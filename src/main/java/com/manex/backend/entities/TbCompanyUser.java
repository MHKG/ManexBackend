package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_company_user")
public class TbCompanyUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "AC_C_USER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer acCUserId;

    @Column(name = "COMPANY_ID", nullable = false)
    private Integer companyId;

    @Column(name = "APP_CLIENT_ID", nullable = false)
    private Integer appClientId;

    @Column(name = "USER_ID", nullable = false)
    private Integer userId;

    @Column(name = "SUPERVISOR_ID")
    private Integer supervisorId;

    @Column(name = "USER_ROLE")
    private Integer userRole;

    @Column(name = "STATUS")
    private Integer status;
}
