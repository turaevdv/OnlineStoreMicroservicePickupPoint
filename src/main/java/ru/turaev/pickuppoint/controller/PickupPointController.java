package ru.turaev.pickuppoint.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.turaev.pickuppoint.dto.PickupPointDto;
import ru.turaev.pickuppoint.model.PickupPoint;
import ru.turaev.pickuppoint.service.PickupPointService;

import java.util.List;

@RestController
@RequestMapping("api/v1/pickup-points")
@RequiredArgsConstructor
public class PickupPointController {
    private final PickupPointService pickupPointService;

    @GetMapping("/{id}")
    public PickupPoint getPickupPointById(@PathVariable long id) {
        return pickupPointService.getPickupPointById(id);
    }

    @GetMapping
    public List<PickupPoint> getAllPickupPoints() {
        return pickupPointService.getAllPickupPoints();
    }

    @PostMapping
    public PickupPoint save(@RequestBody PickupPointDto pickupPointDto) {
        return pickupPointService.save(pickupPointDto);
    }

    @PutMapping("/{id}")
    public PickupPoint update(@PathVariable long id, @RequestBody PickupPointDto pickupPointDto) {
        return pickupPointService.updatePickupPoint(id, pickupPointDto);
    }

    @DeleteMapping("/{id}")
    public PickupPoint delete(@PathVariable long id) {
        return pickupPointService.delete(id);
    }

    @GetMapping("/exist/{id}")
    public boolean isPickupPointExist(@PathVariable long id) {
        return pickupPointService.isPickupPointExist(id);
    }
}
