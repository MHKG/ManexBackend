package com.manex.backend.repositories;

import com.manex.backend.entities.TbCompanyUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TbCompanyUserRepository
        extends JpaRepository<TbCompanyUser, Integer>, JpaSpecificationExecutor<TbCompanyUser> {

    @Query("SELECT cu FROM TbCompanyUser cu WHERE USER_ID = :id")
    List<TbCompanyUser> findAllByUSER_ID(Integer id);
}
