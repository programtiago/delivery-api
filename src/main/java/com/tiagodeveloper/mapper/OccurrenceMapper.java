package com.tiagodeveloper.mapper;

import com.tiagodeveloper.domain.Occurrence;
import com.tiagodeveloper.model.OccurrenceModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OccurrenceMapper {

    private ModelMapper modelMapper;

    public OccurrenceModel toModel(Occurrence occurrence){
        return modelMapper.map(occurrence, OccurrenceModel.class);
    }

    public List<OccurrenceModel> toCollectionModel(List<Occurrence> occurrences){
        return occurrences.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}
