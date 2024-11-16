package org.carrental.controller;

import lombok.RequiredArgsConstructor;
import org.carrental.exception.ValidationException;
import org.carrental.model.car.Car;
import org.carrental.service.CarService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> allCars = carService.getAllCars();

        return ResponseEntity.ok(allCars);
    }

    @GetMapping
    public ResponseEntity<Car> getCarByParam(@RequestParam(required = false) Integer id) {
        Car car = carService.getById(id);

        return ResponseEntity.ok(car);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarByPathVariable(@PathVariable Integer id) {
        Car car = carService.getById(id);

        return ResponseEntity.ok(car);
    }

    @PostMapping("/create")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car createdCar = carService.create(car);

        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(createdCar);
    }

}
