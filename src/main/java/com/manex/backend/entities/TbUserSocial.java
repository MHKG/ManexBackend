package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_user_social")
public class TbUserSocial {

    @Id
    @Column(nullable = false)
    private Integer SM_ID;

    @Column(nullable = false)
    private Integer USER_ID;

    @Column private String SM_HANDLE;

    @Column private Integer STATUS;

    @Column private String ADDL_INFO;

    public Integer getSM_ID() {
        return SM_ID;
    }

    public void setSM_ID(Integer SM_ID) {
        this.SM_ID = SM_ID;
    }

    public Integer getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(Integer USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getSM_HANDLE() {
        return SM_HANDLE;
    }

    public void setSM_HANDLE(String SM_HANDLE) {
        this.SM_HANDLE = SM_HANDLE;
    }

    public Integer getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(Integer STATUS) {
        this.STATUS = STATUS;
    }

    public String getADDL_INFO() {
        return ADDL_INFO;
    }

    public void setADDL_INFO(String ADDL_INFO) {
        this.ADDL_INFO = ADDL_INFO;
    }
}
