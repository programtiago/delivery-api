package com.tiagodeveloper.mapper;

import com.tiagodeveloper.domain.Delivery;
import com.tiagodeveloper.model.DeliveryModel;
import com.tiagodeveloper.model.input.DeliveryInputModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DeliveryMapper {

    private ModelMapper modelMapper;

    public DeliveryMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public DeliveryModel toModel(Delivery delivery){
        return modelMapper.map(delivery, DeliveryModel.class);
    }

    public List<DeliveryModel> toCollectionModel(List<Delivery> deliveries){
        return deliveries.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Delivery toEntity(DeliveryInputModel deliveryInput){
        return modelMapper.map(deliveryInput, Delivery.class);
    }
}
