package org.carrental.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.carrental.model.car.Car;
import org.carrental.model.car.CarClass;
import org.carrental.model.car.CarStatus;
import org.carrental.model.request.ErrorResponse;
import org.carrental.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class CarControllerIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void cleanUp() {
        carRepository.removeAll();
    }

    @Test
    void shouldCreateNewCar() throws JsonProcessingException {
        Car car = new Car(null, "Skoda", "octavia",
                "123", CarClass.PREMIUM, CarStatus.AVAILABLE, 50D);
        String carRequestJson = objectMapper.writeValueAsString(car);

        Car result = webTestClient.post().uri("/car/create")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(carRequestJson)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Car.class)
                .returnResult()
                .getResponseBody();

        assertNotEquals(result.getId(), car.getId());
        assertEquals(result.getVin(), car.getVin());

        Optional<Car> carFromRepository = carRepository.getById(result.getId());

        assertEquals(carFromRepository.get(), result);
        assertEquals(1, (long) carRepository.getAll().size());
    }

    @Test
    void shouldReturnBadRequestForValidationException() throws JsonProcessingException {
        Car car = new Car(null, "Skoda", "octavia",
                "1234", CarClass.PREMIUM, CarStatus.AVAILABLE, 50D);
        String carRequestJson = objectMapper.writeValueAsString(car);

        ErrorResponse result = webTestClient.post().uri("/car/create")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(carRequestJson)
                .exchange()
                .expectStatus().isBadRequest()
                .expectBody(ErrorResponse.class)
                .returnResult().getResponseBody();

        assertEquals(result.getMessage(), "vin length must be 3");
    }

    @Test
    void shouldReturnAllCars() {
        Car car = new Car(null, "Skoda", "octavia",
                "123", CarClass.PREMIUM, CarStatus.AVAILABLE, 50D);
        Car car2 = new Car(null, "Make", "model", "vin", CarClass.STANDARD, CarStatus.AVAILABLE, 50D);

        carRepository.create(car);
        carRepository.create(car2);
        assertEquals(2, carRepository.getAll().size());

        List<Car> result = webTestClient
                .get()
                .uri("/car/all")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Car.class)
                .returnResult().getResponseBody();

        assertEquals(2, result.size());
        assertEquals(result, carRepository.getAll());
    }

    @Test
    void shouldReturnSpecifiedCarByRequestParam(){
        Car car = new Car(null, "Skoda", "octavia",
                "123", CarClass.PREMIUM, CarStatus.AVAILABLE, 50D);
        carRepository.create(car);

        Car result = webTestClient.get().uri(uriBuilder ->
                        uriBuilder.path("/car")
                                .queryParam("id", 0)
                                .build()
                )
                .exchange()
                .expectBody(Car.class)
                .returnResult().getResponseBody();

        assertEquals(result.getVin(), car.getVin());
        assertEquals(result, carRepository.getById(result.getId()).get());
    }

    @Test
    void shouldReturnSpecifiedCarByPathVariable(){
        Car car = new Car(null, "Skoda", "octavia",
                "123", CarClass.PREMIUM, CarStatus.AVAILABLE, 50D);
        carRepository.create(car);

        Car result = webTestClient.get().uri("/car/0")
                .exchange()
                .expectBody(Car.class)
                .returnResult().getResponseBody();

        assertEquals(result.getVin(), car.getVin());
        assertEquals(result, carRepository.getById(result.getId()).get());
    }


}
