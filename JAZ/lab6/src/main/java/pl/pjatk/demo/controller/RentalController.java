package pl.pjatk.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.demo.exception.BadRequestException;
import pl.pjatk.demo.exception.MovieNotFoundException;
import pl.pjatk.demo.exception.MovieServiceUnavailableException;
import pl.pjatk.demo.model.Movie;
import pl.pjatk.demo.service.RentalService;

@RestController
public class RentalController {
    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id){
        return ResponseEntity.ok(rentalService.getMovie(id));
    }



    @PutMapping("/movies/{id}/available")
    public ResponseEntity<Movie> returnMovie(@PathVariable Long id){
        return ResponseEntity.ok(rentalService.returnMovie(id));
    }

    @PutMapping("/movies/{id}/unavailable")
    public ResponseEntity<Movie> rentMovie(@PathVariable Long id){
        return ResponseEntity.ok(rentalService.rentMovie(id));
    }

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<String> handleMovieNotFoundException(MovieNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handleBadRequestException(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(MovieServiceUnavailableException.class)
    public ResponseEntity<String> handleMovieServiceUnavailableException(MovieServiceUnavailableException ex) {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(ex.getMessage());
    }
}