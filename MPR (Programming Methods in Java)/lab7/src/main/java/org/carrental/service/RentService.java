package org.carrental.service;

import lombok.RequiredArgsConstructor;
import org.carrental.exception.CarNotFoundException;
import org.carrental.exception.RentCreationException;
import org.carrental.model.car.Car;
import org.carrental.model.car.CarStatus;
import org.carrental.model.client.Client;
import org.carrental.model.rent.Rent;
import org.carrental.repository.RentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class RentService {
    private final CarService carService;
    private final ClientService clientService;
    private final RentRepository rentRepository;

    public Rent createRent(Integer carId, Integer clientId, LocalDate startDate, int rentLength){
        //
        // walidacje
        // startDate >= actual date
        // rentLength > 0
        Car selectedCar;
        try {
            selectedCar = carService.getById(carId);
        } catch (CarNotFoundException ex){
            throw new RentCreationException("Couldnt create rent", ex);
        }
        if (selectedCar.getCarStatus() != CarStatus.AVAILABLE){
            throw new RentCreationException("couldnt create rent");
        }

        Client selectedClient = clientService.getById(clientId);
        /// Mogą być wyrzucone wyjątki

        double rentPrice = selectedCar.getPrice() * rentLength;
        // Chcemy sprawdzić czy cena jest prawidłowo wyliczona w teście

        Rent rent = new Rent(carId, clientId, startDate, startDate.plusDays(rentLength), rentPrice);

        return rentRepository.create(rent);
    }

    // Wyszukanie przyszłych najmów, Sprawdzenie wszystkich najmów, wyszukanie po id


}
