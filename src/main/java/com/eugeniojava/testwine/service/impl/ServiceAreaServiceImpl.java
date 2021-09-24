package com.eugeniojava.testwine.service.impl;

import com.eugeniojava.testwine.model.ServiceArea;
import com.eugeniojava.testwine.model.form.ServiceAreaForm;
import com.eugeniojava.testwine.repository.ServiceAreaRepository;
import com.eugeniojava.testwine.repository.StoreRepository;
import com.eugeniojava.testwine.service.ServiceAreaService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ServiceAreaServiceImpl implements ServiceAreaService {
    private final ServiceAreaRepository serviceAreaRepository;
    private final StoreRepository storeRepository;

    public ServiceAreaServiceImpl(ServiceAreaRepository serviceAreaRepository, StoreRepository storeRepository) {
        this.serviceAreaRepository = serviceAreaRepository;
        this.storeRepository = storeRepository;
    }

    @Override
    public List<ServiceArea> findAll() {
        return serviceAreaRepository.findAll();
    }

    @Override
    public Optional<ServiceArea> findByArea(long area) {
        return serviceAreaRepository.findByArea(area);
    }

    @Override
    public Optional<ServiceArea> create(ServiceAreaForm serviceAreaForm) {
        return validateAndPersist(serviceAreaForm);
    }

    @Override
    public Optional<ServiceArea> update(long serviceAreaId, ServiceAreaForm serviceAreaForm) {
        var serviceAreaOptional = serviceAreaRepository.findById(serviceAreaId);
        if (serviceAreaOptional.isEmpty()) return Optional.empty();
        return validateAndPersist(serviceAreaForm);
    }

    private Optional<ServiceArea> validateAndPersist(ServiceAreaForm serviceAreaForm) {
        if (canBeRegisteredOrUpdated(serviceAreaForm)) {
            var store = storeRepository.findById(serviceAreaForm.getStoreId()).get();
            var serviceArea = new ServiceArea(store, serviceAreaForm.getStartRange(), serviceAreaForm.getEndRange());
            return Optional.of(serviceAreaRepository.save(serviceArea));
        }
        return Optional.empty();
    }

    private boolean canBeRegisteredOrUpdated(ServiceAreaForm serviceAreaForm) {
        if (serviceAreaRepository.isRangeInUse(serviceAreaForm.getStartRange(), serviceAreaForm.getEndRange())) {
            return false;
        }
        return storeRepository.existsById(serviceAreaForm.getStoreId());
    }

    @Override
    public boolean delete(long serviceAreaId) {
        return false;
    }
}
