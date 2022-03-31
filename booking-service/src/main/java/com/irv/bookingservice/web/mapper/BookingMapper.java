package com.irv.bookingservice.web.mapper;

import com.irv.bookingservice.domain.Booking;
import com.irv.bookingservice.web.model.BookingDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface BookingMapper {
    BookingDto bookingToBookingDto(Booking booking);
    Booking bookingDtoToBooking(BookingDto booking);
    List<Booking> bookingsDtoToBookings(List<BookingDto> booking);
    List<BookingDto> bookingsToBookingsDto(List<Booking> booking);
}
