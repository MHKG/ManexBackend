package com.manex.backend.repositories;

import com.manex.backend.entities.TbCompanyUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbCompanyUserRepository
        extends JpaRepository<TbCompanyUser, Integer>, JpaSpecificationExecutor<TbCompanyUser> {}
