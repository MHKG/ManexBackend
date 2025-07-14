package com.manex.backend.repositories;

import com.manex.backend.entities.TbCtn;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TbCtnRepository
        extends JpaRepository<TbCtn, Integer>, JpaSpecificationExecutor<TbCtn> {

    @Query("SELECT tc FROM TbCtn tc WHERE tc.APP_CLIENT_ID = :appClientId")
    List<TbCtn> findByAppClientId(String appClientId);

    @Query("SELECT tc FROM TbCtn tc WHERE tc.ALIAS_NAME = :ALIAS_NAME")
    TbCtn findByAliasName(String ALIAS_NAME);
}
