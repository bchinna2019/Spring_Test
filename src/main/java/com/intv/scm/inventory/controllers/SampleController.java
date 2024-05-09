package com.intv.scm.inventory.controllers;

import com.intv.scm.inventory.services.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sample")
public class SampleController {

    @Autowired
    KafkaService kafkaService;

    @PostMapping
    public ResponseEntity InventoryDetails(@RequestBody String payload) {
        kafkaService.inventoryDetails(payload);
        return (ResponseEntity) ResponseEntity.ok();
    }

    @GetMapping
    public ResponseEntity getInventory() {
        return (ResponseEntity) ResponseEntity.ok();
    }

}
