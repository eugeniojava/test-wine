package com.eugeniojava.testwine.service;

import com.eugeniojava.testwine.model.ServiceArea;
import com.eugeniojava.testwine.model.form.ServiceAreaForm;
import java.util.List;
import java.util.Optional;

public interface ServiceAreaService {

    List<ServiceArea> findAll();

    Optional<ServiceArea> findByArea(long area);

    Optional<ServiceArea> create(ServiceAreaForm serviceAreaForm);

    Optional<ServiceArea> update(long serviceAreaId, ServiceAreaForm serviceAreaForm);

    boolean delete(long serviceAreaId);
}
