package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_user_social")
public class TbUserSocial implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId private TbUserSocialId id;

    @Column(name = "sm_handle")
    private String smHandle;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "addl_info")
    private String addlInfo;
}
