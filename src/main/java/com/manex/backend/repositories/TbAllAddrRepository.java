package com.manex.backend.repositories;

import com.manex.backend.entities.TbAllAddr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TbAllAddrRepository
        extends JpaRepository<TbAllAddr, Integer>, JpaSpecificationExecutor<TbAllAddr> {

    @Query("SELECT taa FROM TbAllAddr taa WHERE APP_CLIENT_ID = :appClientId")
    List<TbAllAddr> findByAppClientId(Integer appClientId);
}
