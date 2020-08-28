/**
 * 
 */
package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Movie;
import com.example.demo.service.impl.MovieServiceImpl;
import com.example.demo.util.ResponseHandler;

/**
 * @author tricksense
 *
 */
@RestController
public class UserRequestController {

	@Autowired
	private MovieServiceImpl movieServiceImpl;

	@PostMapping("/add-movie")
	public ResponseEntity<Object> movie(@RequestBody Movie movie) {

		boolean result = movieServiceImpl.movie(movie);
		if(result) {
			return ResponseHandler.generateResponse(HttpStatus.CREATED, false, "Success", movie);
		}else
			return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, true, "Something went wrong", null);
		
	}
	
	@GetMapping("/fetch-movie")
	public ResponseEntity<Object> movie(@RequestParam Long id) {
		Optional<Movie> movie = movieServiceImpl.getMovieById(id);
		if(movie.isPresent()) {
			return ResponseHandler.generateResponse(HttpStatus.OK, false, "Success", movie);
		}else
			return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, true, "Something went wrong", null);
	}
	
	@PutMapping("/update-movie")
	public ResponseEntity<Object> updatemovie(@RequestBody Movie movie) {
		Movie move = movieServiceImpl.updateMovieById(movie);
		if(move!=null) {
			return ResponseHandler.generateResponse(HttpStatus.OK, false, "Success", movie);
		}else
			return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, true, "Something went wrong", null);
	}
	
	@PutMapping("/delete-movie")
	public ResponseEntity<Object> deletemovie(@RequestParam Long id) {
		boolean result = movieServiceImpl.dropMovieById(id);
		
		if(result) {
			return ResponseHandler.generateResponse(HttpStatus.OK, false, "Success", result);
		}else
			return ResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, true, "Something went wrong", null);
	}

}
