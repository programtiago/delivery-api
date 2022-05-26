package com.tiagodeveloper.domain.service;

import com.tiagodeveloper.domain.Delivery;
import com.tiagodeveloper.domain.Occurrence;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistryOccurrenceService {

    private FindDeliveryService deliveryService;

    public RegistryOccurrenceService(FindDeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @Transactional
    public Occurrence registry(Long deliveryId, String description){
        Delivery delivery = deliveryService.find(deliveryId);

        return delivery.addOccurence(description);

    }
}
