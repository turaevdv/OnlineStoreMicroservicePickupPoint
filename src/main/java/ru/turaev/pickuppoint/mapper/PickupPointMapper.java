package ru.turaev.pickuppoint.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.turaev.pickuppoint.dto.PickupPointDto;
import ru.turaev.pickuppoint.model.PickupPoint;

@Mapper(componentModel = "spring")
public interface PickupPointMapper {
    @Mapping(target = "working", expression = "java(true)")
    PickupPoint fromDto(PickupPointDto storehouseDto);
}
