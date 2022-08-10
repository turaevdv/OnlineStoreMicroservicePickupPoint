package ru.turaev.pickuppoint.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.turaev.pickuppoint.dto.PickupPointDto;
import ru.turaev.pickuppoint.exception.AddressNotFoundException;
import ru.turaev.pickuppoint.exception.PickupPointNotFoundException;
import ru.turaev.pickuppoint.mapper.PickupPointMapper;
import ru.turaev.pickuppoint.model.PickupPoint;
import ru.turaev.pickuppoint.repository.PickupPointRepository;
import ru.turaev.pickuppoint.restconsumer.AddressRestConsumer;
import ru.turaev.pickuppoint.service.PickupPointService;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PickupPointServiceImpl implements PickupPointService {
    private final PickupPointRepository repository;
    private final PickupPointMapper pickupPointMapper;
    private final AddressRestConsumer addressRestConsumer;

    @Override
    public PickupPoint getPickupPointById(long id) {
        log.info("Trying to find pickup point with id = {}", id);
        PickupPoint pickupPoint = repository.findById(id)
                .orElseThrow(() -> new PickupPointNotFoundException("Pickup point with id " + id + " not found"));
        log.info("The pickup point with id = {} was found", id);
        return pickupPoint;
    }

    @Override
    public List<PickupPoint> getAllPickupPoints() {
        log.info("Trying to find all pickup points");
        return repository.findAll();
    }

    @Override
    @Transactional
    public PickupPoint save(PickupPointDto pickupPointDto) {
        log.info("Trying to save a new pickup point");
        if (!addressRestConsumer.isAddressExist(pickupPointDto.getAddressId())) {
            throw new AddressNotFoundException("Address with id " + pickupPointDto.getAddressId() + " not found");
        }
        PickupPoint pickupPoint = repository.save(pickupPointMapper.fromDto(pickupPointDto));
        log.info("The pickup point was saved with id = {}", pickupPoint.getId());
        return pickupPoint;
    }

    @Override
    @Transactional
    public PickupPoint updatePickupPoint(long id, PickupPointDto pickupPointDto) {
        log.info("Trying to update a pickup point with id = {}", id);
        if (!addressRestConsumer.isAddressExist(pickupPointDto.getAddressId())) {
            throw new AddressNotFoundException("Address with id " + pickupPointDto.getAddressId() + " not found");
        }
        PickupPoint pickupPoint = getPickupPointById(id);
        pickupPoint.setName(pickupPointDto.getName());
        pickupPoint.setAddressId(pickupPointDto.getAddressId());
        log.info("The pickup point with id = {} successfully updated", id);
        return pickupPoint;
    }

    @Override
    @Transactional
    public PickupPoint delete(long id) {
        log.info("Trying to delete a pickup point with id = {}", id);
        PickupPoint pickupPoint = getPickupPointById(id);
        pickupPoint.setWorking(false);
        log.info("The pickup point with id = {} successfully deleted", id);
        return pickupPoint;
    }

    @Override
    public boolean isPickupPointExist(long id) {
        return repository.existsById(id);
    }
}
