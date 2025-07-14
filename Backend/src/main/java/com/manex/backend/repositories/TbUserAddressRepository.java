package com.manex.backend.repositories;

import com.manex.backend.entities.TbUserAddress;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbUserAddressRepository
        extends JpaRepository<TbUserAddress, Integer>, JpaSpecificationExecutor<TbUserAddress> {}
