package com.manex.backend.repositories;

import com.manex.backend.entities.TbMm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbMmRepository
        extends JpaRepository<TbMm, Integer>, JpaSpecificationExecutor<TbMm> {}
