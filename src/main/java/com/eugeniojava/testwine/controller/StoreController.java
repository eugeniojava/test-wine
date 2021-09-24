package com.eugeniojava.testwine.controller;

import com.eugeniojava.testwine.model.Store;
import com.eugeniojava.testwine.model.form.StoreForm;
import com.eugeniojava.testwine.service.StoreService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/stores")
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public ResponseEntity<List<Store>> findAll() {
        return ResponseEntity.ok(storeService.findAll());
    }

    @GetMapping(value = "/serviced-area")
    public ResponseEntity<Store> findByServicedArea(@RequestParam long area) {
        return storeService.findByServicedArea(area)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<Store> create(@Valid @RequestBody StoreForm storeForm) {
        return storeService.create(storeForm)
                .map(s -> new ResponseEntity<>(s, HttpStatus.CREATED))
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping(value = "/{storeId}")
    public ResponseEntity<Store> update(@PathVariable long storeId, @Valid @RequestBody StoreForm storeForm) {
        return storeService.update(storeId, storeForm)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @DeleteMapping(value = "/{storeId}")
    public ResponseEntity<Void> delete(@PathVariable long storeId) {
        if (storeService.delete(storeId)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
