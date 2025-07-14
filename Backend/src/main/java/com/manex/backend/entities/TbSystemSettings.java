package com.manex.backend.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
