package com.irv.userservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.irv.userservice.exceptions.UserNotFoundException;
import com.irv.userservice.web.model.ErrorInfoDto;
import com.irv.userservice.web.model.UserDto;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Objects;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserServiceApplicationTests {

	private static final String USER_LAST_NAME = "Calderon";
	private final String USER_NAME = "Irving";
	private static final String USER_LAST_NAME_2 = "Valenzuela";
	private final String USER_NAME_1 = "Juan";
	private ObjectMapper objectMapper;

	@Autowired
	private WebTestClient webTestClient;
	//esta es la implementacion real para consumir servicios rest con caracteristicas con pruebas unitarias

	@Test
	@Order(1)
	void add() {
     webTestClient.post().uri("/v1/users/")
			 .contentType(MediaType.APPLICATION_JSON)
			 .bodyValue(UserDto.builder().build())
			 .exchange()
			 .expectStatus().isBadRequest()
			 .expectBody(ErrorInfoDto.class)
			 .consumeWith(error -> {
				 assertEquals(HttpStatus.NOT_ACCEPTABLE, Objects.requireNonNull(error.getResponseBody()).getStatus());
			 })
	 ;
     webTestClient.post().uri("/v1/users/")
			 .contentType(MediaType.APPLICATION_JSON)
			 .bodyValue(UserDto.builder().name(USER_NAME).last_name(USER_LAST_NAME).build())
			 .exchange()
			 .expectStatus().isOk()
			 .expectBody(UserDto.class)
			 .consumeWith(result -> {
				 System.out.println(result);
				 assertEquals(USER_NAME, Objects.requireNonNull(result.getResponseBody().getName()));
				 assertEquals(USER_LAST_NAME, Objects.requireNonNull(result.getResponseBody().getLast_name()));
				 assertEquals(1, Objects.requireNonNull(result.getResponseBody().getId()));
			 })
	 ;
	 webTestClient.post().uri("/v1/users/")
			 .contentType(MediaType.APPLICATION_JSON)
			 .bodyValue(UserDto.builder().name(USER_NAME_1).last_name(USER_LAST_NAME_2).build())
			 .exchange()
			 .expectStatus().isOk()
			 .expectBody(UserDto.class)
			 .consumeWith(result -> {
				 System.out.println(result);
				 assertEquals(USER_NAME_1, Objects.requireNonNull(result.getResponseBody().getName()));
				 assertEquals(USER_LAST_NAME_2, Objects.requireNonNull(result.getResponseBody().getLast_name()));
				 assertEquals(2, Objects.requireNonNull(result.getResponseBody().getId()));
			 })
	 ;
	}

	@Test
	@Order(2)
	void findAll() {
		webTestClient.get().uri("/v1/users/")
				.exchange()
				.expectStatus().isOk()
				.expectHeader()
				.contentType(MediaType.APPLICATION_JSON)
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$").value(hasSize(2))
				.jsonPath("$[0].name").isEqualTo(USER_NAME)
				.jsonPath("$[1].name").isEqualTo(USER_NAME_1)
				.consumeWith(System.out::println)
		;
	}

	@Test
	@Order(3)
	void findById() {
		webTestClient.get().uri("/v1/users/1")
				.exchange()
				.expectStatus().isOk()
				.expectHeader()
				.contentType(MediaType.APPLICATION_JSON)
				.expectBody()
				.jsonPath("$.name").isEqualTo(USER_NAME)
				.jsonPath("$.last_name").isEqualTo(USER_LAST_NAME)
		;
	}
	@Test
	@Order(4)
	void update() {
		webTestClient.post().uri("/v1/users/10")
				.bodyValue(UserDto.builder().name(USER_NAME+"_1")
						.last_name(USER_LAST_NAME_2+"_1")
						.build())
				.exchange()
				.expectStatus().isNotFound()
				.expectHeader().contentType(MediaType.APPLICATION_JSON)
				.expectBody(ErrorInfoDto.class)
				.consumeWith(error -> {
					assertEquals(new UserNotFoundException().getMessage(), Objects.requireNonNull(error.getResponseBody()).getMessage());
				})
		;
		webTestClient.post().uri("/v1/users/1")
				.bodyValue(UserDto.builder().name(USER_NAME+"_1")
						.last_name(USER_LAST_NAME_2+"_1")
						.build())
				.exchange()
				.expectStatus().isOk()
				.expectHeader()
				.contentType(MediaType.APPLICATION_JSON)
				.expectBody()
				.jsonPath("$.name").isEqualTo(USER_NAME+"_1")
				.jsonPath("$.last_name").isEqualTo(USER_LAST_NAME_2+"_1")
		;
	}
	@Test
	@Order(5)
	void delete() {
		webTestClient.get().uri("/v1/users/")
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").value(hasSize(2))
		;
//		webTestClient.post().uri("/v1/users/10")
//				.exchange()
//				.expectStatus().isBadRequest()
//				.expectBody(ErrorInfoDto.class)
//				.consumeWith(error -> {
//					assertEquals(new UserNotFoundException().getMessage(), Objects.requireNonNull(error.getResponseBody()).getMessage());
//				})
//		;
		webTestClient.delete().uri("/v1/users/1")
				.exchange().expectStatus().isNoContent();
		webTestClient.get().uri("/v1/users/")
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").value(hasSize(1))
		;
	}

}
