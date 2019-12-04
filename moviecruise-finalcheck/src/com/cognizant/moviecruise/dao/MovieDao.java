package com.cognizant.moviecruise.dao;

import java.util.List;

import com.cognizant.moviecruise.model.Movies;

/**
 * 
 * @author ManiKandan V
 *
 */
public interface MovieDao {
	public List<Movies> getMovieListAdmin();

	public List<Movies> getMovieListCustomer();

	public void modifyMovie(Movies movie);

	public Movies getMovie(long movieId);
}
