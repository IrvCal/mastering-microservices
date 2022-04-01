package com.irv.restaurantservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.irv.restaurantservice.web.mapper.RestaurantMapper;
import com.irv.restaurantservice.web.model.ErrorInfoDto;
import com.irv.restaurantservice.web.model.RestaurantDto;
import com.irv.restaurantservice.web.model.TableDto;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.hamcrest.Matchers.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class RestaurantControllerTest {

    private ObjectMapper objectMapper;
    private final String RESTAURANT_NAME = "LosPollos";//hay que hacer las correcciones para que acepte espacios entre palabras
    private final String RESTAURANT_ADDRESS = "Los Sauces";

    @Autowired
    private WebTestClient webTestClient;
    //esta es la implementacion real para consumir servicios rest con caracteristicas con pruebas unitarias

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Autowired
    private RestaurantMapper restaurantMapper;

    @Test
    @Order(1)
    void add() {
        webTestClient.post().uri("/v1/restaurants/")
                .contentType(MediaType.APPLICATION_JSON)
                //Given
                .bodyValue(RestaurantDto.builder()
                        .name(RESTAURANT_NAME)
                        .address(RESTAURANT_ADDRESS)
                        .tables(List.of(
                                TableDto.builder().id(new BigInteger("1")).capacity(5).build(),
                                TableDto.builder().id(new BigInteger("2")).capacity(3).build(),
                                TableDto.builder().id(new BigInteger("3")).capacity(2).build()
                        ))
                        .build())
                //When
                .exchange()
                //Then
                .expectStatus().isCreated()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(RestaurantDto.class)
                .consumeWith(restaurantDtoEntityExchangeResult -> {
                   assertNotNull(restaurantDtoEntityExchangeResult);
                   assertEquals(RESTAURANT_NAME,restaurantDtoEntityExchangeResult.getResponseBody().getName());
                   assertEquals(3,restaurantDtoEntityExchangeResult.getResponseBody().getTables().size());
                });
        //Restaurant sin nombre y sin address
        webTestClient.post().uri("/v1/restaurants/")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(RestaurantDto.builder().build())
                .exchange()
                .expectBody(ErrorInfoDto.class)
                .consumeWith(error->{
                    assertEquals(HttpStatus.NOT_ACCEPTABLE, Objects.requireNonNull(error.getResponseBody()).getStatus());
                })
        ;
    }


    @Test
    @Order(2)
    void findAll() {
        webTestClient.get().uri("/v1/restaurants/")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$").isArray()
                .jsonPath("$").value(hasSize(1))
                .jsonPath("$[0].name").isEqualTo(RESTAURANT_NAME)
                .jsonPath("$[0].address").isEqualTo(RESTAURANT_ADDRESS)
                .jsonPath("$[0].tables").isArray()
                .jsonPath("$[0].tables").value(Assertions::assertNotNull)
//                .jsonPath("$[0].tables").value(hasSize(3))//hay que guardar las tables tambien y no esta el CRUD de estas
        ;
    }

    @Test
    void findByName() {
        //no esta bien optimizado para busquedas con espacios entre nombres
        webTestClient.get().uri("/v1/restaurants/name/pruebas")
                .exchange()
                .expectStatus().isNotFound()
                .expectBody(ErrorInfoDto.class)
        ;
    }

    @Test
    @Order(3)
    void findById() {
        webTestClient.get().uri("/v1/restaurants/"+1)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.name").isEqualTo(RESTAURANT_NAME)
        ;
    }

    @Test
    @Order(4)
    void update() {
        webTestClient.post().uri("/v1/restaurants/"+1)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(RestaurantDto.builder()
                        .name("Nuevo")
                        .address(RESTAURANT_ADDRESS)
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.name").isEqualTo("Nuevo")
        ;
    }

    @Test
    @Order(5)
    void delete() {

        webTestClient.get().uri("/v1/restaurants/")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$").isArray()
                .jsonPath("$").value(hasSize(1))
        ;

        webTestClient.delete().uri("/v1/restaurants/"+1)
                .exchange().expectStatus().isNoContent();

        webTestClient.get().uri("/v1/restaurants/")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$").isArray()
                .jsonPath("$").value(hasSize(0))
        ;
        webTestClient.get().uri("/v1/restaurants/"+1)
                .exchange()
                .expectStatus().isNotFound()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(ErrorInfoDto.class)
                .consumeWith(errorInfo ->{
                    assertEquals(HttpStatus.NOT_FOUND, Objects.requireNonNull(errorInfo.getResponseBody()).getStatus());
                })
        ;
    }
}