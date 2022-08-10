package ru.turaev.pickuppoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.turaev.pickuppoint.model.PickupPoint;

@Repository
public interface PickupPointRepository extends JpaRepository<PickupPoint, Long> {

}
