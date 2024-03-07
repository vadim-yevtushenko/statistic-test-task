package com.example.statistictesttask.mapper;

import com.example.statistictesttask.api.dto.AsinStatisticDto;
import com.example.statistictesttask.persistence.entity.AsinStatisticEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AsinStatisticMapper {

    @Autowired
    private ModelMapper mapper;

    public AsinStatisticDto mapEntityToDto(AsinStatisticEntity asinStatisticEntity){
        return mapper.map(asinStatisticEntity, AsinStatisticDto.class);
    }

    public AsinStatisticEntity mapDtoToEntity(AsinStatisticDto asinStatisticDto){
        return mapper.map(asinStatisticDto, AsinStatisticEntity.class);
    }

    public List<AsinStatisticDto> mapListEntityToListDto(List<AsinStatisticEntity> asinStatisticEntities){
        return asinStatisticEntities.stream()
                .map(asinStatisticEntity -> mapper.map(asinStatisticEntity, AsinStatisticDto.class))
                .collect(Collectors.toList());
    }

}
