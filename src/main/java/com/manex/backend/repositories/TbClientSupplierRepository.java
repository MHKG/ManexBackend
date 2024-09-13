package com.manex.backend.repositories;

import com.manex.backend.entities.TbClientSupplier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TbClientSupplierRepository
        extends JpaRepository<TbClientSupplier, Integer>,
                JpaSpecificationExecutor<TbClientSupplier> {

	@Query("SELECT tcs FROM TbClientSupplier tcs WHERE tcs.APP_CLIENT_ID = :appClientId")
	List<TbClientSupplier> findAllByAppClientId(String appClientId);
}
