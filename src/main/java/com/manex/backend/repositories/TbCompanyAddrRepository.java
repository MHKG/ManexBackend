package com.manex.backend.repositories;

import com.manex.backend.entities.TbCompanyAddr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbCompanyAddrRepository
        extends JpaRepository<TbCompanyAddr, Integer>, JpaSpecificationExecutor<TbCompanyAddr> {}
