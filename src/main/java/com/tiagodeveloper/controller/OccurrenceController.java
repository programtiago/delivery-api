package com.tiagodeveloper.controller;

import com.tiagodeveloper.domain.Delivery;
import com.tiagodeveloper.domain.Occurrence;
import com.tiagodeveloper.domain.service.FindDeliveryService;
import com.tiagodeveloper.domain.service.RegistryOccurrenceService;
import com.tiagodeveloper.mapper.OccurrenceMapper;
import com.tiagodeveloper.model.OccurrenceModel;
import com.tiagodeveloper.model.input.OccurrenceInput;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/deliveries/{deliveryId}/occurrences")
public class OccurrenceController  {

    private RegistryOccurrenceService registryOccurrenceService;

    private OccurrenceMapper occurrenceMapper;

    private FindDeliveryService deliveryService;

    public OccurrenceController(RegistryOccurrenceService registryOccurrenceService, OccurrenceMapper occurrenceMapper) {
        this.registryOccurrenceService = registryOccurrenceService;
        this.occurrenceMapper = occurrenceMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OccurrenceModel registry(@PathVariable Long deliveryId, @Valid @RequestBody OccurrenceInput occurrenceInput){

        Occurrence registeredOccurrence = registryOccurrenceService.registry(deliveryId, occurrenceInput.getDescription());

        return occurrenceMapper.toModel(registeredOccurrence);
    }

    @GetMapping
    public List<OccurrenceModel> list(@PathVariable Long deliveryId){
        Delivery delivery = deliveryService.find(deliveryId);

        return occurrenceMapper.toCollectionModel(delivery.getOccurrences());
    }
}
