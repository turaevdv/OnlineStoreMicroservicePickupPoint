package ru.turaev.pickuppoint.service;

import ru.turaev.pickuppoint.dto.PickupPointDto;
import ru.turaev.pickuppoint.model.PickupPoint;

import java.util.List;

public interface PickupPointService {
    PickupPoint getPickupPointById(long id);
    List<PickupPoint> getAllPickupPoints();
    PickupPoint save(PickupPointDto pickupPointDto);
    PickupPoint updatePickupPoint(long id, PickupPointDto pickupPointDto);
    PickupPoint delete(long id);
    boolean isPickupPointExist(long id);
}
