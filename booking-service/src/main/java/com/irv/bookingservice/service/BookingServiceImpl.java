package com.irv.bookingservice.service;

import com.irv.bookingservice.domain.Booking;
import com.irv.bookingservice.exceptions.BookingNotFoundException;
import com.irv.bookingservice.exceptions.ListBookingsNotFoundException;
import com.irv.bookingservice.repository.BookingRepository;
import com.irv.bookingservice.web.mapper.BookingMapper;
import com.irv.bookingservice.web.model.BookingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingMapper mapper;
    private final BookingRepository repository;

    @Override
    public BookingDto findById(Long id) throws Exception{
        return mapper.bookingToBookingDto(getOptionalBooking(id));
    }

    @Override
    public List<BookingDto> findAllActiveBookings() throws Exception{
        return mapper.bookingsToBookingsDto(repository.findAllActiveBookings().orElseGet(ArrayList::new));
    }

    @Override
    public List<BookingDto> findByReservationName(String name) throws Exception{
        return mapper.bookingsToBookingsDto(repository.findByReservationName(name).orElseThrow(ListBookingsNotFoundException::new));
    }

    @Transactional
    @Override
    public int setIsNoLongerActive(Long id) throws Exception{
        getOptionalBooking(id);
        return repository.setIsNoLongerActive(id);
    }

    @Override
    public BookingDto save(BookingDto booking) throws Exception{
        booking.setIsActive(true);
        //agregar regla de negocio que no ser repita una reservacion para la misma hora
        return mapper.bookingToBookingDto(repository.save(mapper.bookingDtoToBooking(booking)));
    }

    @Override
    public BookingDto update(Long id, BookingDto booking) throws Exception{
        return mapper.bookingToBookingDto(
                repository.save(
                        repository.findById(id).map(
                          booking1 -> {
                              booking1.setRestaurantId(booking.getRestaurantId());
                              booking1.setUserId(booking.getUserId());
                              booking1.setDate(booking.getDate());
                              booking1.setTime(booking.getTime());
                              booking1.setReservationName(booking.getReservationName());
                              booking1.setIsActive(booking.getIsActive());
                              return booking1;
                          }).orElseThrow()
                )
        );
    }

    @Override
    public void delete(Long id) throws Exception{
        repository.delete(getOptionalBooking(id));
    }

    private Booking getOptionalBooking(Long id) throws BookingNotFoundException {
        return repository.findById(id).orElseThrow(BookingNotFoundException::new);
    }
}
