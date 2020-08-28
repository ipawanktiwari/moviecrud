/**
 * 
 */
package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Movie;
import com.example.demo.repository.MovieRepo;
import com.example.demo.service.MoviceService;

/**
 * @author tricksense
 *
 */
@Service
public class MovieServiceImpl implements MoviceService {

	@Autowired
	private MovieRepo movieRepo;

	@Override
	public Optional<Movie> getMovieById(Long id) {
		return movieRepo.findById(id);
	}

	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie updateMovieById(Movie movie) {
		Optional<Movie> movi = movieRepo.findById(movie.getId());
		Movie mov = null;
		if (movi.isPresent()) {
			mov = movi.get();
			mov.setCategory(movie.getCategory());
			mov.setRating(movie.getRating());
			mov.setTitle(movie.getTitle());
			movieRepo.save(mov);
		}
		return mov;
	}

	@Override
	public boolean dropMovieById(Long id) {
		boolean b = false;
		try {
			movieRepo.deleteById(id);
			b = true;
		} catch (Exception e) {
			// TODO: handle exception
		}

		return b;
	}

	@Override
	public boolean movie(Movie movie) {
		boolean b = (movieRepo.save(movie) != null) ? true : false;
		return b;
	}

}
