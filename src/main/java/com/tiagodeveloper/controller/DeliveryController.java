package com.tiagodeveloper.controller;

import com.tiagodeveloper.domain.Delivery;
import com.tiagodeveloper.domain.service.DeliverySolicitationService;
import com.tiagodeveloper.domain.service.FinishedDeliveryService;
import com.tiagodeveloper.mapper.DeliveryMapper;
import com.tiagodeveloper.model.DeliveryModel;
import com.tiagodeveloper.model.input.DeliveryInputModel;
import com.tiagodeveloper.repository.DeliveryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController{

    private DeliveryRepository deliveryRepository;

    private DeliverySolicitationService solicitationService;

    private DeliveryMapper deliveryMapper;

    private FinishedDeliveryService finishedDeliveryService;

    public DeliveryController(DeliverySolicitationService solicitationService, DeliveryRepository deliveryRepository, DeliveryMapper deliveryMapper) {
        this.solicitationService = solicitationService;
        this.deliveryRepository = deliveryRepository;
        this.deliveryMapper = deliveryMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeliveryModel request(@Valid @RequestBody DeliveryInputModel deliveryInput){
        Delivery newDelivery = deliveryMapper.toEntity(deliveryInput);
        Delivery requestedDelivery = solicitationService.request(newDelivery);

        return deliveryMapper.toModel(requestedDelivery);
    }

    @PutMapping("/{deliveryId}/finishing")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finish(@PathVariable Long deliveryId){
        finishedDeliveryService.finish(deliveryId);
    }

    @GetMapping
    public List<DeliveryModel> list(){
        return deliveryMapper.toCollectionModel(deliveryRepository.findAll());
    }

    @GetMapping("/{deliveryId}")
    public ResponseEntity<DeliveryModel> get(@PathVariable Long deliveryId){
        return deliveryRepository.findById(deliveryId)
                .map(delivery -> ResponseEntity.ok(deliveryMapper.toModel(delivery)))
                .orElse(ResponseEntity.notFound().build());
    }

}
