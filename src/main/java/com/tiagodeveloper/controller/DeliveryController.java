package com.tiagodeveloper.controller;

import com.tiagodeveloper.domain.Delivery;
import com.tiagodeveloper.domain.service.DeliverySolicitationService;
import com.tiagodeveloper.model.DeliveryModel;
import com.tiagodeveloper.model.RecipientModel;
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
    public ResponseEntity<DeliveryModel> get(@PathVariable Long deliveryId){
        return deliveryRepository.findById(deliveryId)
                .map(delivery -> {
                    DeliveryModel deliveryModel = new DeliveryModel();
                    deliveryModel.setId(delivery.getId());
                    deliveryModel.setClientName(delivery.getClient().getName());
                    deliveryModel.setRecipient(new RecipientModel());
                    deliveryModel.getRecipient().setName(delivery.getRecipient().getName());
                    deliveryModel.getRecipient().setAddress(delivery.getRecipient().getAddress());
                    deliveryModel.getRecipient().setComplement(delivery.getRecipient().getComplement());
                    deliveryModel.getRecipient().setNumber(delivery.getRecipient().getNumber());
                    deliveryModel.getRecipient().setDistrict(delivery.getRecipient().getDistrict());
                    deliveryModel.setTax(delivery.getTax());
                    deliveryModel.setStatus(delivery.getStatus());
                    deliveryModel.setRequestDate(delivery.getRequestDate());
                    deliveryModel.setCompletionDate(delivery.getCompletionDate());

                    return ResponseEntity.ok(deliveryModel);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery request(@Valid @RequestBody Delivery delivery){
        return solicitationService.request(delivery);
    }
}
