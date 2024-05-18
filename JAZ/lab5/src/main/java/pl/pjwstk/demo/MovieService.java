package pl.pjwstk.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie getMovieById(Integer id) {
        return movieRepository.findById(id).orElseThrow(MovieNotFoundException::new);
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovieById(Integer id) {
        if (!movieRepository.existsById(id)) {
            throw new MovieNotFoundException();
        }
        movieRepository.deleteById(id);
    }

    public void updateMovie(Movie updatedMovie) {
        if (!movieRepository.existsById(updatedMovie.getId())) {
            throw new MovieNotFoundException();
        }
        movieRepository.save(updatedMovie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
