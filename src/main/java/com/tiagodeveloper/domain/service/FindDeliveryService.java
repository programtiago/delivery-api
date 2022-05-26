package com.tiagodeveloper.domain.service;

import com.tiagodeveloper.domain.Delivery;
import com.tiagodeveloper.domain.exception.DomainException;
import com.tiagodeveloper.repository.DeliveryRepository;

import javax.persistence.EntityNotFoundException;

public class FindDeliveryService {

    private DeliveryRepository deliveryRepository;

    public FindDeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public Delivery find(Long deliveryId){
       return deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new EntityNotFoundException("Delivery not found"));
    }
}
