package ru.turaev.pickuppoint.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PickupPointDto {
    private String name;
    private int addressId;
}
