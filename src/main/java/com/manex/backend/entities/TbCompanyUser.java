package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_company_user")
public class TbCompanyUser {

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

    public Integer getAcCUserId() {
        return acCUserId;
    }

    public void setAcCUserId(Integer acCUserId) {
        this.acCUserId = acCUserId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getAppClientId() {
        return appClientId;
    }

    public void setAppClientId(Integer appClientId) {
        this.appClientId = appClientId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Integer supervisorId) {
        this.supervisorId = supervisorId;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
