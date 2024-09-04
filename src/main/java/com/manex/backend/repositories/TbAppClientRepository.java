package com.manex.backend.repositories;

import com.manex.backend.entities.TbAppClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbAppClientRepository
        extends JpaRepository<TbAppClient, Integer>, JpaSpecificationExecutor<TbAppClient> {}
