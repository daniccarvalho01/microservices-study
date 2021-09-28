package com.microservicesstudy.store.repositories;

import com.microservicesstudy.store.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository <Store, Long> {
}