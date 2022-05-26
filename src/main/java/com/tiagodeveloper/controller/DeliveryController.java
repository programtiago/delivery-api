package com.tiagodeveloper.controller;

import com.tiagodeveloper.domain.Delivery;
import com.tiagodeveloper.domain.service.DeliverySolicitationService;
import com.tiagodeveloper.repository.DeliveryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private DeliveryRepository deliveryRepository;

    private DeliverySolicitationService solicitationService;

    public DeliveryController(DeliverySolicitationService solicitationService, DeliveryRepository deliveryRepository) {
        this.solicitationService = solicitationService;
        this.deliveryRepository = deliveryRepository;
    }

    @GetMapping
    public List<Delivery> list(){
        return deliveryRepository.findAll();
    }

    @GetMapping("/{deliveryId}")
    public ResponseEntity<Delivery> get(@PathVariable Long deliveryId){
        return deliveryRepository.findById(deliveryId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery request(@Valid @RequestBody Delivery delivery){
        return solicitationService.request(delivery);
    }
}
