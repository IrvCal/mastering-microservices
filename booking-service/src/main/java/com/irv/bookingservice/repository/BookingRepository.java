package com.irv.bookingservice.repository;

import com.irv.bookingservice.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    Optional<Booking> findById(Long id);
    @Query(nativeQuery = true, value = "select * from booking where is_active = true")
    Optional<List<Booking>> findAllActiveBookings();
    @Query(nativeQuery = true, value = "select * from booking where reservation_name = ?1 and is_active = true")
    Optional<List<Booking>> findByReservationName(String name);
    @Modifying
    @Query(nativeQuery = true, value = "update booking set is_active = false  where id = ?1 ")
    int setIsNoLongerActive(Long id);
}
