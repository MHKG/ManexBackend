package com.manex.backend.repositories;

import com.manex.backend.entities.TbCustomerPi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbCustomerPiRepository
        extends JpaRepository<TbCustomerPi, Integer>, JpaSpecificationExecutor<TbCustomerPi> {}
