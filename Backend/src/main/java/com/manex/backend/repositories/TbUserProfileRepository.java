package com.manex.backend.repositories;

import com.manex.backend.entities.TbUserProfile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbUserProfileRepository
        extends JpaRepository<TbUserProfile, Integer>, JpaSpecificationExecutor<TbUserProfile> {}
