package org.carrental.service;

import lombok.RequiredArgsConstructor;
import org.carrental.exception.CarNotFoundException;
import org.carrental.exception.ValidationException;
import org.carrental.model.car.Car;
import org.carrental.model.car.CarStatus;
import org.carrental.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;


    public Car create(Car car) {
        Map<String, String> errors = new HashMap<>();
        if (car.getMake() == null || car.getMake().isBlank()){
            errors.put("make","Cannot be blank");
        }
        if (car.getModel() == null || car.getModel().isBlank()){
            errors.put("model","Cannot be blank");
        }
        if (car.getVin() == null || car.getVin().isBlank()) {
            errors.put("vin","Cannot be blank");
        }
        if (car.getVin().length() != 3){
            errors.put("vin","Length must be 3");
        }

        if (!errors.isEmpty()){
            throw new ValidationException(errors);
        }

        return carRepository.create(car);
    }

    public List<Car> getAvailableCars(){
        return carRepository.getByStatus(CarStatus.AVAILABLE);
    }

    public List<Car> getAllCars(){
        return carRepository.getAll();
    }

    public Car getById(Integer id){
        if (id == null){
            throw new ValidationException("id", "cannot be null");
        }

        return carRepository.getById(id)
                .orElseThrow( ()-> new CarNotFoundException("Car with id: " + id +" does not exist"));
    }

}
