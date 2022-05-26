package com.tiagodeveloper.domain.service;

import com.tiagodeveloper.domain.Delivery;
import com.tiagodeveloper.domain.Occurrence;
import com.tiagodeveloper.domain.exception.DomainException;
import com.tiagodeveloper.repository.DeliveryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistryOccurrenceService {

    private DeliveryRepository deliveryRepository;

    public RegistryOccurrenceService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Transactional
    public Occurrence registry(Long deliveryId, String description){
        Delivery delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new DomainException("Delivery not found"));

        return delivery.addOccurence(description);

    }
}
