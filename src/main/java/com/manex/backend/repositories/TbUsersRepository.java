package com.manex.backend.repositories;

import com.manex.backend.entities.TbUsers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbUsersRepository
        extends JpaRepository<TbUsers, Integer>, JpaSpecificationExecutor<TbUsers> {}
