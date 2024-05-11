package pl.pjwstk.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    private final List<Movie> movieList = new ArrayList<>();

    public Movie getMovieById(Integer id) {
        for (Movie movie : movieList) {
            if (movie.getId().equals(id)) {
                return movie;
            }
        }
        throw new MovieNotFoundException();
    }

    public Movie addMovie(Movie movie) {
        movieList.add(movie);
        return movie;
    }

    public void deleteMovieById(Integer id) throws MovieNotFoundException {
        Movie movieToRemove = null;
        for (Movie movie : movieList) {
            if (movie.getId().equals(id)) {
                movieToRemove = movie;
                break;
            }
        }
        if (movieToRemove == null) {
            throw new MovieNotFoundException();
        } else {
            movieList.remove(movieToRemove);
        }
    }


    public void updateMovie(Movie updatedMovie) {
        for (Movie movie : movieList) {
            if (movie.getId().equals(updatedMovie.getId())) {
                movie.setTitle(updatedMovie.getTitle());
                movie.setCategory(updatedMovie.getCategory());
                break;
            }
        }
    }

    public List<Movie> getAllMovies() {
        return movieList;
    }
}
