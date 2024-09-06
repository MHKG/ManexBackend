package com.manex.backend.repositories;

import com.manex.backend.entities.TbSupplierPi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbSupplierPiRepository
        extends JpaRepository<TbSupplierPi, Integer>, JpaSpecificationExecutor<TbSupplierPi> {}
