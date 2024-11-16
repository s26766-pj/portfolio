package org.carrental;

import org.carrental.model.car.Car;
import org.carrental.model.car.CarClass;
import org.carrental.model.car.CarStatus;
import org.carrental.repository.CarRepository;
import org.carrental.service.CarService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class);

        CarService carService = context.getBean("carService", CarService.class);

        Car car = new Car(null, "Make", "model", "vin", CarClass.STANDARD, CarStatus.AVAILABLE, 50D);
        Car car2 = new Car(null, "Skoda", "Octavia", "vin", CarClass.STANDARD, CarStatus.RENTED, 150D);
        carService.create(car);
        carService.create(car2);

        List<Car> allCars = carService.getAllCars();
        System.out.println(allCars);
        CarRepository carRepository = context.getBean("carRepository", CarRepository.class);
        Optional<Car> carById = carRepository.getById(0);


        System.out.println(carById);


    }
}