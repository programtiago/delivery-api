package com.tiagodeveloper.domain.service;

import com.tiagodeveloper.domain.Client;
import com.tiagodeveloper.domain.Delivery;
import com.tiagodeveloper.domain.StatusDelivery;
import com.tiagodeveloper.domain.exception.DomainException;
import com.tiagodeveloper.exceptionhandler.ApiExceptionHandler;
import com.tiagodeveloper.repository.ClientRepository;
import com.tiagodeveloper.repository.DeliveryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class DeliverySolicitationService {
    private CatalogClientService catalogClientService;
    private DeliveryRepository deliveryRepository;

    public DeliverySolicitationService(DeliveryRepository deliveryRepository, CatalogClientService catalogClientService) {
        this.deliveryRepository = deliveryRepository;
        this.catalogClientService = catalogClientService;
    }

    @Transactional
    public Delivery request(Delivery delivery){
        Client client = catalogClientService.get(delivery.getClient().getId());

        delivery.setClient(client);
        delivery.setStatus(StatusDelivery.PENDING);
        delivery.setRequestDate(LocalDateTime.now());
        return deliveryRepository.save(delivery);
    }
}
