package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_user_social")
public class TbUserSocial {

    @Id
    @Column(name = "SM_ID", nullable = false)
    private Integer smId;

    @Column(name = "USER_ID", nullable = false)
    private Integer userId;

    @Column(name = "SM_HANDLE")
    private String smHandle;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "ADDL_INFO")
    private String addlInfo;

    public Integer getSmId() {
        return smId;
    }

    public void setSmId(Integer smId) {
        this.smId = smId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSmHandle() {
        return smHandle;
    }

    public void setSmHandle(String smHandle) {
        this.smHandle = smHandle;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAddlInfo() {
        return addlInfo;
    }

    public void setAddlInfo(String addlInfo) {
        this.addlInfo = addlInfo;
    }
}
