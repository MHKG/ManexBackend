package com.manex.backend.repositories;

import com.manex.backend.entities.TbCustomerQuotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbCustomerQuotationRepository
        extends JpaRepository<TbCustomerQuotation, Integer>,
                JpaSpecificationExecutor<TbCustomerQuotation> {}
