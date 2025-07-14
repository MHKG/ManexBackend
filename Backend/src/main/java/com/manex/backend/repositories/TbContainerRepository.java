package com.manex.backend.repositories;

import com.manex.backend.entities.TbContainer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbContainerRepository
        extends JpaRepository<TbContainer, Integer>, JpaSpecificationExecutor<TbContainer> {}
