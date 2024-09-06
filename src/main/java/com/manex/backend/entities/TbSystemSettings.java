package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_system_settings")
public class TbSystemSettings {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "APP_CLIENT_ID", nullable = false)
    private Integer appClientId;

    @Column(name = "SENDER_EMAIL")
    private String senderEmail;

    @Column(name = "SMTP_SERVER_IP")
    private String smtpServerIp;

    @Column(name = "SMTP_SVR_LOGIN")
    private String smtpSvrLogin;

    @Column(name = "SMTP_SVR_PASSWD")
    private String smtpSvrPasswd;

    @Column(name = "SMTP_SVR_OUTGOING_PORT_NO")
    private Integer smtpSvrOutgoingPortNo;

    @Column(name = "SMTP_SVR_IS_SSL")
    private String smtpSvrIsSsl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppClientId() {
        return appClientId;
    }

    public void setAppClientId(Integer appClientId) {
        this.appClientId = appClientId;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getSmtpServerIp() {
        return smtpServerIp;
    }

    public void setSmtpServerIp(String smtpServerIp) {
        this.smtpServerIp = smtpServerIp;
    }

    public String getSmtpSvrLogin() {
        return smtpSvrLogin;
    }

    public void setSmtpSvrLogin(String smtpSvrLogin) {
        this.smtpSvrLogin = smtpSvrLogin;
    }

    public String getSmtpSvrPasswd() {
        return smtpSvrPasswd;
    }

    public void setSmtpSvrPasswd(String smtpSvrPasswd) {
        this.smtpSvrPasswd = smtpSvrPasswd;
    }

    public Integer getSmtpSvrOutgoingPortNo() {
        return smtpSvrOutgoingPortNo;
    }

    public void setSmtpSvrOutgoingPortNo(Integer smtpSvrOutgoingPortNo) {
        this.smtpSvrOutgoingPortNo = smtpSvrOutgoingPortNo;
    }

    public String getSmtpSvrIsSsl() {
        return smtpSvrIsSsl;
    }

    public void setSmtpSvrIsSsl(String smtpSvrIsSsl) {
        this.smtpSvrIsSsl = smtpSvrIsSsl;
    }
}
