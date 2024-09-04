package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_system_settings")
public class TbSystemSettings implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "APP_CLIENT_ID", nullable = false)
    private Integer appClientId;

    @Column(name = "sender_email")
    private String senderEmail;

    @Column(name = "smtp_server_ip")
    private String smtpServerIp;

    @Column(name = "smtp_svr_login")
    private String smtpSvrLogin;

    @Column(name = "smtp_svr_passwd")
    private String smtpSvrPasswd;

    @Column(name = "SMTP_SVR_OUTGOING_PORT_NO")
    private Integer smtpSvrOutgoingPortNo;

    @Column(name = "smtp_svr_is_ssl")
    private String smtpSvrIsSsl;
}
