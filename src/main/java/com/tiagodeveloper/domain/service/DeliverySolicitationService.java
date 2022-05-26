package com.tiagodeveloper.domain.service;

import com.tiagodeveloper.domain.Delivery;
import com.tiagodeveloper.domain.StatusDelivery;
import com.tiagodeveloper.repository.DeliveryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class DeliverySolicitationService {

    private DeliveryRepository deliveryRepository;

    public DeliverySolicitationService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Transactional
    public Delivery request(Delivery delivery){
        delivery.setStatus(StatusDelivery.PENDING);
        delivery.setRequestDate(LocalDateTime.now());
        return deliveryRepository.save(delivery);
    }
}
