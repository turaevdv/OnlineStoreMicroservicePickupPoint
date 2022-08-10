package ru.turaev.pickuppoint.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PickupPointDto {
    private final String name;
    private final int addressId;
}
