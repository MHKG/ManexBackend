package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_company_user")
public class TbCompanyUser {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer AC_C_USER_ID;

    @Column(nullable = false)
    private Integer COMPANY_ID;

    @Column(nullable = false)
    private Integer APP_CLIENT_ID;

    @Column(nullable = false)
    private Integer USER_ID;

    @Column private Integer SUPERVISOR_ID;

    @Column private Integer USER_ROLE;

    @Column private Integer STATUS;

    public Integer getAC_C_USER_ID() {
        return AC_C_USER_ID;
    }

    public void setAC_C_USER_ID(Integer AC_C_USER_ID) {
        this.AC_C_USER_ID = AC_C_USER_ID;
    }

    public Integer getCOMPANY_ID() {
        return COMPANY_ID;
    }

    public void setCOMPANY_ID(Integer COMPANY_ID) {
        this.COMPANY_ID = COMPANY_ID;
    }

    public Integer getAPP_CLIENT_ID() {
        return APP_CLIENT_ID;
    }

    public void setAPP_CLIENT_ID(Integer APP_CLIENT_ID) {
        this.APP_CLIENT_ID = APP_CLIENT_ID;
    }

    public Integer getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(Integer USER_ID) {
        this.USER_ID = USER_ID;
    }

    public Integer getSUPERVISOR_ID() {
        return SUPERVISOR_ID;
    }

    public void setSUPERVISOR_ID(Integer SUPERVISOR_ID) {
        this.SUPERVISOR_ID = SUPERVISOR_ID;
    }

    public Integer getUSER_ROLE() {
        return USER_ROLE;
    }

    public void setUSER_ROLE(Integer USER_ROLE) {
        this.USER_ROLE = USER_ROLE;
    }

    public Integer getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(Integer STATUS) {
        this.STATUS = STATUS;
    }
}
