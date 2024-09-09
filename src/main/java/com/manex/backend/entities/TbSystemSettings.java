package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_system_settings")
public class TbSystemSettings {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private Integer APP_CLIENT_ID;

    @Column private String SENDER_EMAIL;

    @Column private String SMTP_SERVER_IP;

    @Column private String SMTP_SVR_LOGIN;

    @Column private String SMTP_SVR_PASSWD;

    @Column private Integer SMTP_SVR_OUTGOING_PORT_NO;

    @Column private String SMTP_SVR_IS_SSL;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getAPP_CLIENT_ID() {
        return APP_CLIENT_ID;
    }

    public void setAPP_CLIENT_ID(Integer APP_CLIENT_ID) {
        this.APP_CLIENT_ID = APP_CLIENT_ID;
    }

    public String getSENDER_EMAIL() {
        return SENDER_EMAIL;
    }

    public void setSENDER_EMAIL(String SENDER_EMAIL) {
        this.SENDER_EMAIL = SENDER_EMAIL;
    }

    public String getSMTP_SERVER_IP() {
        return SMTP_SERVER_IP;
    }

    public void setSMTP_SERVER_IP(String SMTP_SERVER_IP) {
        this.SMTP_SERVER_IP = SMTP_SERVER_IP;
    }

    public String getSMTP_SVR_LOGIN() {
        return SMTP_SVR_LOGIN;
    }

    public void setSMTP_SVR_LOGIN(String SMTP_SVR_LOGIN) {
        this.SMTP_SVR_LOGIN = SMTP_SVR_LOGIN;
    }

    public String getSMTP_SVR_PASSWD() {
        return SMTP_SVR_PASSWD;
    }

    public void setSMTP_SVR_PASSWD(String SMTP_SVR_PASSWD) {
        this.SMTP_SVR_PASSWD = SMTP_SVR_PASSWD;
    }

    public Integer getSMTP_SVR_OUTGOING_PORT_NO() {
        return SMTP_SVR_OUTGOING_PORT_NO;
    }

    public void setSMTP_SVR_OUTGOING_PORT_NO(Integer SMTP_SVR_OUTGOING_PORT_NO) {
        this.SMTP_SVR_OUTGOING_PORT_NO = SMTP_SVR_OUTGOING_PORT_NO;
    }

    public String getSMTP_SVR_IS_SSL() {
        return SMTP_SVR_IS_SSL;
    }

    public void setSMTP_SVR_IS_SSL(String SMTP_SVR_IS_SSL) {
        this.SMTP_SVR_IS_SSL = SMTP_SVR_IS_SSL;
    }
}
