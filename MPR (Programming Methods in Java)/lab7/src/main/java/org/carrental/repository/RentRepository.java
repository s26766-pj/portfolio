package org.carrental.repository;

import org.carrental.model.car.Car;
import org.carrental.model.rent.Rent;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RentRepository {

    private List<Rent> rentList = new ArrayList<>();

    public Rent create(Rent rent){
        rent.setId(rentList.size());
        rentList.add(rent);

        return rent;
    }

    public Optional<Rent> getById(Integer id){
        return rentList
                .stream()
                .filter(it -> it.getId().equals(id))
                .findFirst();
    }

    public List<Rent> getAll(){
        return rentList;
    }

}
