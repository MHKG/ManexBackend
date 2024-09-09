package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_user_profile")
public class TbUserProfile {

    @Id
    @Column(nullable = false)
    private Integer USER_ID;

    @Column private String F_NAME;

    @Column private String M_NAME;

    @Column private String L_NAME;

    @Column private Integer PROFILE_IMG;

    @Column(columnDefinition = "smallint")
    private Integer COUNTRY_CODE;

    @Column private String PHONE_MOBILE;

    @Column private String PHONE_WORK;

    @Column private String PHONE_WORK_EXT;

    public Integer getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(Integer USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getF_NAME() {
        return F_NAME;
    }

    public void setF_NAME(String f_NAME) {
        F_NAME = f_NAME;
    }

    public String getM_NAME() {
        return M_NAME;
    }

    public void setM_NAME(String m_NAME) {
        M_NAME = m_NAME;
    }

    public String getL_NAME() {
        return L_NAME;
    }

    public void setL_NAME(String l_NAME) {
        L_NAME = l_NAME;
    }

    public Integer getPROFILE_IMG() {
        return PROFILE_IMG;
    }

    public void setPROFILE_IMG(Integer PROFILE_IMG) {
        this.PROFILE_IMG = PROFILE_IMG;
    }

    public Integer getCOUNTRY_CODE() {
        return COUNTRY_CODE;
    }

    public void setCOUNTRY_CODE(Integer COUNTRY_CODE) {
        this.COUNTRY_CODE = COUNTRY_CODE;
    }

    public String getPHONE_MOBILE() {
        return PHONE_MOBILE;
    }

    public void setPHONE_MOBILE(String PHONE_MOBILE) {
        this.PHONE_MOBILE = PHONE_MOBILE;
    }

    public String getPHONE_WORK() {
        return PHONE_WORK;
    }

    public void setPHONE_WORK(String PHONE_WORK) {
        this.PHONE_WORK = PHONE_WORK;
    }

    public String getPHONE_WORK_EXT() {
        return PHONE_WORK_EXT;
    }

    public void setPHONE_WORK_EXT(String PHONE_WORK_EXT) {
        this.PHONE_WORK_EXT = PHONE_WORK_EXT;
    }
}
