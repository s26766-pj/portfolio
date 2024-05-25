package pl.pjwstk.demo;

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

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAll() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{id}")
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
    public void setMovieAvailable(@PathVariable Integer id) {
        movieService.setMovieAvailable(id);
    }

    @PutMapping("/{id}/unavailable")
    public void setMovieUnavailable(@PathVariable Integer id) {
        movieService.setMovieUnavailable(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovieById(id);
        return ResponseEntity.noContent().build();
    }
}
