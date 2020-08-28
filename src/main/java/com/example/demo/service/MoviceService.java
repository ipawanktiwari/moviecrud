/**
 * 
 */
package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.Movie;

/**
 * @author tricksense
 *
 */

public interface MoviceService {

	boolean movie(Movie movie);

	Optional<Movie> getMovieById(Long id);

	List<Movie> getAllMovies();

	Movie updateMovieById(Movie movie);

	boolean dropMovieById(Long id);

}
