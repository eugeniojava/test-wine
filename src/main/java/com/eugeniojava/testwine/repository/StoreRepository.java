package com.eugeniojava.testwine.repository;

import com.eugeniojava.testwine.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    boolean existsByName(String storeName);
}
