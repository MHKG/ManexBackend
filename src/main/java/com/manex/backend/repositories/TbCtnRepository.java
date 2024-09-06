package com.manex.backend.repositories;

import com.manex.backend.entities.TbCtn;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbCtnRepository
        extends JpaRepository<TbCtn, Integer>, JpaSpecificationExecutor<TbCtn> {}
