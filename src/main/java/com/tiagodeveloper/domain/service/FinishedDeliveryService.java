package com.tiagodeveloper.domain.service;

import com.tiagodeveloper.domain.Delivery;
import com.tiagodeveloper.domain.StatusDelivery;
import com.tiagodeveloper.domain.exception.DomainException;
import com.tiagodeveloper.repository.DeliveryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FinishedDeliveryService {

    private FindDeliveryService deliveryService;

    private DeliveryRepository deliveryRepository;

    public FinishedDeliveryService(FindDeliveryService deliveryService, DeliveryRepository deliveryRepository) {
        this.deliveryService = deliveryService;
        this.deliveryRepository = deliveryRepository;
    }

    @Transactional
    public void finish(Long deliveryId){
        Delivery delivery = deliveryService.find(deliveryId);

        delivery.finish();

        deliveryRepository.save(delivery);
    }
}
