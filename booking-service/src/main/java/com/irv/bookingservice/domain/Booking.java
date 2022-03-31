package com.irv.bookingservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String restaurantId;
    private String reservationName;
    private LocalDate date;
    private LocalDate time;
    @Column(columnDefinition="Boolean default true")
    private Boolean isActive;
}
