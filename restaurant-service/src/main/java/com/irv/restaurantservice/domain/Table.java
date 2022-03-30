package com.irv.restaurantservice.domain;

import javax.persistence.*;
import java.math.BigInteger;

@Entity(name = "mesa")//Table es palabra reservada y da error y no te dice que es por eso o quiza si pero no entendi
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    BigInteger id;
    private int capacity;
    private boolean isModified;
    @ManyToOne()
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

}
