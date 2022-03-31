package com.irv.bookingservice.web.controller;

import com.irv.bookingservice.service.BookingService;
import com.irv.bookingservice.web.mapper.BookingMapper;
import com.irv.bookingservice.web.model.BookingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/bookings")
public class BookingController {

    private final BookingService service;

    @GetMapping("/{id}")
    private ResponseEntity<?> findById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<?> findAllActiveBookings() throws Exception {
        return new ResponseEntity<>(service.findAllActiveBookings(),HttpStatus.OK);
    }

    @GetMapping("/reservations/{name}")
    private ResponseEntity<?> findByReservationName(@PathVariable String name) throws Exception {
        return new ResponseEntity<>(service.findByReservationName(name),HttpStatus.OK);
    }

    @PostMapping("/de-active/{id}")
    private ResponseEntity<?> setIsNoLongerActive(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(service.setIsNoLongerActive(id),HttpStatus.ACCEPTED);
    }

    @PostMapping("save/")
    private ResponseEntity<?> save( @Valid @RequestBody BookingDto booking) throws Exception {
        System.out.println(LocalDate.now());
        return new ResponseEntity<>(service.save(booking),HttpStatus.OK);
    }

    @PostMapping("/{id}")
    private ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody BookingDto booking) throws Exception {
        //cheacar el update del campo is active porque lo pasa a null tambien y checar que los que tengan false ya no
//        se puedan actualizar
        return new ResponseEntity<>(service.update(id,booking),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
