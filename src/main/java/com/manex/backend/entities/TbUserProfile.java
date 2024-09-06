package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_user_profile")
public class TbUserProfile {

    @Id
    @Column(name = "USER_ID", nullable = false)
    private Integer userId;

    @Column(name = "F_NAME")
    private String fName;

    @Column(name = "M_NAME")
    private String mName;

    @Column(name = "L_NAME")
    private String lName;

    @Column(name = "PROFILE_IMG")
    private Integer profileImg;

    @Column(name = "COUNTRY_CODE", columnDefinition = "smallint")
    private Integer countryCode;

    @Column(name = "PHONE_MOBILE")
    private String phoneMobile;

    @Column(name = "PHONE_WORK")
    private String phoneWork;

    @Column(name = "PHONE_WORK_EXT")
    private String phoneWorkExt;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getMName() {
        return mName;
    }

    public void setMName(String mName) {
        this.mName = mName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public Integer getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(Integer profileImg) {
        this.profileImg = profileImg;
    }

    public Integer getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Integer countryCode) {
        this.countryCode = countryCode;
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
    }

    public String getPhoneWork() {
        return phoneWork;
    }

    public void setPhoneWork(String phoneWork) {
        this.phoneWork = phoneWork;
    }

    public String getPhoneWorkExt() {
        return phoneWorkExt;
    }

    public void setPhoneWorkExt(String phoneWorkExt) {
        this.phoneWorkExt = phoneWorkExt;
    }
}
