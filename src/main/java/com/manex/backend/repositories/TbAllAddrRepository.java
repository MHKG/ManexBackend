package com.manex.backend.repositories;

import com.manex.backend.entities.TbAllAddr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbAllAddrRepository
        extends JpaRepository<TbAllAddr, Integer>, JpaSpecificationExecutor<TbAllAddr> {}
