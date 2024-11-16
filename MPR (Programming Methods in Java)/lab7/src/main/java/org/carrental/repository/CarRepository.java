package org.carrental.repository;

import org.carrental.model.car.Car;
import org.carrental.model.car.CarStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CarRepository {

    private List<Car> carList = new ArrayList<>();

    public Car create(Car car) {
        car.setId(carList.size());
        carList.add(car);
        return car;
    }

    public Optional<Car> getById(Integer id){
        return carList
                .stream()
                .filter(it -> it.getId().equals(id))
                .findFirst();
    }

    public List<Car> getByStatus(CarStatus carStatus){
        return carList
                .stream()
                .filter(it -> it.getCarStatus().equals(carStatus))
                .collect(Collectors.toList());
    }

    public void removeById(Integer id){
        Optional<Car> car = getById(id);

        car.ifPresent(it -> carList.remove(it));
    }

    public void removeAll(){
        carList = new ArrayList<>();
    }

    public Optional<Car> modify(Car car) {
        Optional<Car> carToModify = getById(car.getId());

        return carToModify.map(it -> {
            it.setMake(car.getMake());
            it.setCarClass(car.getCarClass());
            it.setModel(car.getModel());
            it.setCarStatus(car.getCarStatus());
            it.setVin(car.getVin());
            return it;
        });
    }

    public List<Car> getAll() {
        return carList;
    }
}
