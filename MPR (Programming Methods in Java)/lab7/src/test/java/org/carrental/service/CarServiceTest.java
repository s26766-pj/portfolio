package org.carrental.service;

import org.carrental.exception.CarNotFoundException;
import org.carrental.exception.ValidationException;
import org.carrental.model.car.Car;
import org.carrental.model.car.CarClass;
import org.carrental.model.car.CarStatus;
import org.carrental.repository.CarRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {
    private static CarService carService;
    private static CarRepository carRepository;

    @BeforeAll
    static void setUp(){
        carRepository = new CarRepository();
        carService = new CarService(carRepository);
    }

    @AfterEach
    void cleanUp(){
        carRepository.removeAll();
    }

    @Test
    void shouldCorrectlyCreateNewCar(){
        Car car = new Car(
                null, "Volkswagen", "Golf", "123", CarClass.STANDARD, CarStatus.AVAILABLE, 50D
        );

        Car result = assertDoesNotThrow(()->carService.create(car));

        assertEquals(car.getMake(), result.getMake());
    }

    @Test
    void shouldNotReturnAnyCar() {
        List<Car> result = carService.getAllCars();

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldNotCreateNewCar() {
        Car car = new Car(
                null, "Volkswagen", "Golf", "1234", CarClass.STANDARD, CarStatus.AVAILABLE, 50D
        );

        ValidationException result = assertThrows(ValidationException.class,()->carService.create(car));

        assertEquals("vin length must be 3", result.getMessage());
    }

    @ParameterizedTest
    @MethodSource("provideInvalidCarsAndMessages")
    void shouldNotCreateCar(Car car, String message){
        ValidationException result = assertThrows(ValidationException.class,()->carService.create(car));

        assertEquals(message, result.getMessage());
    }

    @Test
    void shouldNotReturnCarByNotExistingId(){
        assertThrows(CarNotFoundException.class, () -> carService.getById(1));
    }

    @Test
    void shouldCorrectlyReturnCar(){
        Car car = new Car(
                null, "Volkswagen", "Golf", "123", CarClass.STANDARD, CarStatus.AVAILABLE, 100D
        );
        Car car2 = new Car(
                null, "Volkswagen", "Golf", "321", CarClass.STANDARD, CarStatus.AVAILABLE, 80D
        );

        carService.create(car);
        Car secondCreatedCar = carService.create(car2);

        Car result = assertDoesNotThrow(() -> carService.getById(secondCreatedCar.getId()));

        assertEquals(secondCreatedCar, result);
    }


    public static Stream<Arguments> provideInvalidCarsAndMessages() {
        return Stream.of(
                Arguments.of(new Car(null, "Volkswagen", "Golf", "1234", CarClass.STANDARD, CarStatus.AVAILABLE, 100D)
                        , "vin length must be 3"),
                Arguments.of(new Car(null, "", "Golf", "123", CarClass.STANDARD, CarStatus.AVAILABLE, 50D)
                        , "make Cannot be blank"),
                Arguments.of(new Car(null, null, "Golf", "123", CarClass.STANDARD, CarStatus.AVAILABLE, 50D)
                        , "make Cannot be blank")
        );
    }


}