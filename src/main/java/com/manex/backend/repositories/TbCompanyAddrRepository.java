package com.manex.backend.repositories;

import com.manex.backend.entities.TbCompanyAddr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface TbCompanyAddrRepository
        extends JpaRepository<TbCompanyAddr, Integer>, JpaSpecificationExecutor<TbCompanyAddr> {

    @Query("SELECT tca FROM TbCompanyAddr tca WHERE tca.COMPANY_ID = :id")
    TbCompanyAddr findByCompanyId(Integer id);
}
