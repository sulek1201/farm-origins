package com.sulek.farmorigins.service.parameter;

import com.sulek.farmorigins.dto.UnitTypeDto;
import com.sulek.farmorigins.entity.parameter.UnitType;
import com.sulek.farmorigins.repository.parameter.UnitTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UnitTypeService {

    @Autowired
    private UnitTypeRepository unitTypeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<UnitTypeDto> getAllUnitTypes(){
        List<UnitType> unitTypeList = unitTypeRepository.findAll();

        List<UnitTypeDto> unitTypeDtos = new ArrayList<>();
        for(UnitType unitType : unitTypeList){
            UnitTypeDto unitTypeDto = new UnitTypeDto(unitType.getId() -1L, unitType.getLabel());
            unitTypeDtos.add(unitTypeDto);
        }
        return unitTypeDtos;
    }
}
