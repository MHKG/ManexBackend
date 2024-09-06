package com.manex.backend.repositories;

import com.manex.backend.entities.TbCustomerPo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbCustomerPoRepository
        extends JpaRepository<TbCustomerPo, Integer>, JpaSpecificationExecutor<TbCustomerPo> {}
