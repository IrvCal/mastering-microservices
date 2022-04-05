//package com.irv.bookingservice;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.irv.bookingservice.web.model.BookingDto;
//import com.irv.bookingservice.web.model.ErrorInfoDto;
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.reactive.server.WebTestClient;
//
//import java.time.LocalDate;
//import java.util.Objects;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//class BookingServiceApplicationTests {
//
//	@Autowired
//	private WebTestClient webTestClient;
//	//esta es la implementacion real para consumir servicios rest con caracteristicas con pruebas unitarias
//
//	@Test
//	@Order(1)
//	void add() {
//		webTestClient.post().uri("/v1/bookings/save/")
//				.contentType(MediaType.APPLICATION_JSON)
//				.bodyValue(BookingDto.builder().build())
//				.exchange()
//				.expectHeader().contentType(MediaType.APPLICATION_JSON)
//				.expectBody(ErrorInfoDto.class)
//				.consumeWith(error -> {
//					assertNotNull(error);
//					assertEquals(HttpStatus.NOT_ACCEPTABLE,error.getResponseBody().getStatus());
//				});
//		webTestClient.post().uri("/v1/bookings/save/")
//				.contentType(MediaType.APPLICATION_JSON)
//				.bodyValue(BookingDto.builder()
//						.userId(1L)
//						.restaurantId("1")
//						.reservationName("Irving Calderon")
//						.date(LocalDate.now())
//						.time(LocalDate.now())
//						.build())
//				.exchange()
//				.expectHeader().contentType(MediaType.APPLICATION_JSON)
//				.expectBody(BookingDto.class)
//				.consumeWith(booking -> {
//					assertNotNull(booking);
//					assertEquals(1, Objects.requireNonNull(booking.getResponseBody()).getId());
//				});
//	}
//
//	@Test
//	@Order(2)
//	void findById() {
//	}
//	@Test
//	@Order(3)
//	void findAllActiveBookings() {
//	}
//	@Test
//	@Order(4)
//	void setIsNoLongerActive() {
//	}
//	@Test
//	@Order(5)
//	void findByReservationName() {
//	}
//	@Test
//	@Order(6)
//	void update() {
//	}
//	@Test
//	@Order(7)
//	void delete() {
//
//	}
//}
