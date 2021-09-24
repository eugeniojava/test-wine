package com.eugeniojava.testwine.service;

import com.eugeniojava.testwine.model.Store;
import com.eugeniojava.testwine.model.form.StoreForm;
import java.util.List;
import java.util.Optional;

public interface StoreService {

    List<Store> findAll();

    Optional<Store> findById(long storeId);

    Optional<Store> findByServicedArea(long area);

    boolean existsById(long storeId);

    Optional<Store> create(StoreForm storeForm);

    Optional<Store> update(long storeId, StoreForm storeForm);

    boolean delete(long storeId);
}
