package com.manex.backend.repositories;

import com.manex.backend.entities.TbUserSocial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbUserSocialRepository
        extends JpaRepository<TbUserSocial, Integer>, JpaSpecificationExecutor<TbUserSocial> {}
