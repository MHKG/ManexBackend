package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_users")
public class TbUsers {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private String EMAIL;

    @Column private String PASSWORD;

    @Column private Integer USER_TYPE;

    @Column private String RESET_PASS;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public Integer getUSER_TYPE() {
        return USER_TYPE;
    }

    public void setUSER_TYPE(Integer USER_TYPE) {
        this.USER_TYPE = USER_TYPE;
    }

    public String getRESET_PASS() {
        return RESET_PASS;
    }

    public void setRESET_PASS(String RESET_PASS) {
        this.RESET_PASS = RESET_PASS;
    }
}
