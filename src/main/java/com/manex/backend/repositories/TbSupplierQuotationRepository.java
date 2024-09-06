package com.manex.backend.repositories;

import com.manex.backend.entities.TbSupplierQuotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbSupplierQuotationRepository
        extends JpaRepository<TbSupplierQuotation, Integer>,
                JpaSpecificationExecutor<TbSupplierQuotation> {}
