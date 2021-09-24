package com.eugeniojava.testwine.service.impl;

import com.eugeniojava.testwine.model.ServiceArea;
import com.eugeniojava.testwine.model.Store;
import com.eugeniojava.testwine.model.form.StoreForm;
import com.eugeniojava.testwine.repository.ServiceAreaRepository;
import com.eugeniojava.testwine.repository.StoreRepository;
import com.eugeniojava.testwine.service.StoreService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;
    private final ServiceAreaRepository serviceAreaRepository;

    public StoreServiceImpl(StoreRepository storeRepository, ServiceAreaRepository serviceAreaRepository) {
        this.storeRepository = storeRepository;
        this.serviceAreaRepository = serviceAreaRepository;
    }

    @Override
    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    @Override
    public Optional<Store> findById(long storeId) {
        return storeRepository.findById(storeId);
    }

    @Override
    public Optional<Store> findByServicedArea(long area) {
        var serviceArea = serviceAreaRepository.findByArea(area);
        return serviceArea.map(ServiceArea::getStore);
    }

    @Override
    public boolean existsById(long storeId) {
        return storeRepository.existsById(storeId);
    }

    @Override
    public Optional<Store> create(StoreForm storeForm) {
        if (storeRepository.existsByName(storeForm.getName())) {
            return Optional.empty();
        }
        return Optional.of(storeRepository.save(new Store(storeForm.getName())));
    }

    @Override
    public Optional<Store> update(long storeId, StoreForm storeForm) {
        var store = storeRepository.findById(storeId);
        if (store.isPresent()) {
            store.get().setName(storeForm.getName());
            return Optional.of(storeRepository.save(store.get()));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(long storeId) {
        if (storeRepository.existsById(storeId)) {
            storeRepository.deleteById(storeId);
            return true;
        }
        return false;
    }
}
