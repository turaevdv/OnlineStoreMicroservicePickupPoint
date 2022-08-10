package ru.turaev.pickuppoint.model;

import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pickup_points")
@Where(clause = "is_working = true")
public class PickupPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "address_id", nullable = false)
    private int addressId;

    @Column(name = "is_working", nullable = false)
    private boolean isWorking;
}
