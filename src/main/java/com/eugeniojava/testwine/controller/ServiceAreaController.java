package com.eugeniojava.testwine.controller;

import com.eugeniojava.testwine.model.ServiceArea;
import com.eugeniojava.testwine.model.form.ServiceAreaForm;
import com.eugeniojava.testwine.service.ServiceAreaService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/service-areas")
public class ServiceAreaController {
    private final ServiceAreaService serviceAreaService;

    public ServiceAreaController(ServiceAreaService serviceAreaService) {
        this.serviceAreaService = serviceAreaService;
    }

    @GetMapping
    public ResponseEntity<List<ServiceArea>> findAll() {
        return ResponseEntity.ok(serviceAreaService.findAll());
    }

    @PostMapping
    public ResponseEntity<ServiceArea> create(@Valid @RequestBody ServiceAreaForm serviceAreaForm) {
        return serviceAreaService.create(serviceAreaForm)
                .map(s -> new ResponseEntity<>(s, HttpStatus.CREATED))
                .orElse(ResponseEntity.badRequest().build());
    }
}
