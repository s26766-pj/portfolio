package pl.pjwstk.demo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @Operation(summary = "List all movies")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success! All movies have been retrieved.")
    })
    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAll() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }


    @GetMapping("/{id}")
    @Operation(summary = "Get Movie by provided id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success! Movie have been retrieved."),
            @ApiResponse(responseCode = "404", description = "Fail! Movie not found!", content = @Content)
    })
    public ResponseEntity<Movie> getMovieById(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie newMovie) {
        return ResponseEntity.ok(movieService.addMovie(newMovie));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Integer id, @RequestBody Movie updatedMovie) {
        Movie existingMovie = movieService.getMovieById(id);
        existingMovie.setTitle(updatedMovie.getTitle());
        existingMovie.setCategory(updatedMovie.getCategory());
        movieService.updateMovie(existingMovie);
        return ResponseEntity.ok(existingMovie);
    }

    @PutMapping("/{id}/available")
    public ResponseEntity<Movie> setMovieAvailable(@PathVariable Integer id) {
        movieService.setMovieAvailable(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/unavailable")
    public ResponseEntity<Void> setMovieUnavailable(@PathVariable Integer id) {
        movieService.setMovieUnavailable(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovieById(id);
        return ResponseEntity.noContent().build();
    }
}