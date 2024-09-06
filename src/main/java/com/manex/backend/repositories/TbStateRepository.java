package com.manex.backend.repositories;

import com.manex.backend.entities.TbState;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbStateRepository
        extends JpaRepository<TbState, Integer>, JpaSpecificationExecutor<TbState> {}
