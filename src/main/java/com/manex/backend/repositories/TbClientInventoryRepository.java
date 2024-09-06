package com.manex.backend.repositories;

import com.manex.backend.entities.TbClientInventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbClientInventoryRepository
        extends JpaRepository<TbClientInventory, Integer>,
                JpaSpecificationExecutor<TbClientInventory> {}
