package com.example.statistictesttask.mapper;

import com.example.statistictesttask.api.dto.DateStatisticDto;
import com.example.statistictesttask.persistence.entity.DateStatisticEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DateStatisticMapper {

    @Autowired
    private ModelMapper mapper;

    public DateStatisticDto mapEntityToDto(DateStatisticEntity asinStatisticEntity){
        return mapper.map(asinStatisticEntity, DateStatisticDto.class);
    }

    public DateStatisticEntity mapDtoToEntity(DateStatisticDto asinStatisticDto){
        return mapper.map(asinStatisticDto, DateStatisticEntity.class);
    }

    public List<DateStatisticDto> mapListEntityToListDto(List<DateStatisticEntity> dateStatisticEntities){
        return dateStatisticEntities.stream()
                .map(dateStatisticEntity -> mapper.map(dateStatisticEntity, DateStatisticDto.class))
                .collect(Collectors.toList());
    }

}
