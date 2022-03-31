package com.irv.bookingservice.service;

import com.irv.bookingservice.web.model.BookingDto;

import java.util.List;

public interface BookingService {
    BookingDto findById(Long id) throws Exception;
    List<BookingDto> findAllActiveBookings()throws Exception;
    List<BookingDto> findByReservationName(String name)throws Exception;
    int setIsNoLongerActive(Long id)throws Exception;
    BookingDto save(BookingDto booking)throws Exception;
    BookingDto update(Long id, BookingDto booking)throws Exception;
    void delete(Long id)throws Exception;

}
