package com.tiagodeveloper.controller;

import com.tiagodeveloper.domain.Delivery;
import com.tiagodeveloper.domain.service.DeliverySolicitationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private DeliverySolicitationService solicitationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery request(@RequestBody Delivery delivery){
        return solicitationService.request(delivery);
    }
}
