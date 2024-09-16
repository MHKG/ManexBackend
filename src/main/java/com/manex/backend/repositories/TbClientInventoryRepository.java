package com.manex.backend.repositories;

import com.manex.backend.entities.TbClientInventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TbClientInventoryRepository
        extends JpaRepository<TbClientInventory, Integer>,
                JpaSpecificationExecutor<TbClientInventory> {

	@Query("SELECT tci FROM TbClientInventory tci WHERE APP_CLIENT_ID = :appClientId")
	List<TbClientInventory> findByAppClientId(Integer appClientId);
}
