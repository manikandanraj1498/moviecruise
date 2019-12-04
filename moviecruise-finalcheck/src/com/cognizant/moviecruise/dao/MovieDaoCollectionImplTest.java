package com.cognizant.moviecruise.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.moviecruise.model.Movies;
import com.cognizant.moviecruise.util.DateUtil;

/**
 * 
 * @author MAniKandan V
 *
 */
public class MovieDaoCollectionImplTest {
	public static void main(String args[]) throws ParseException {
		testGetMovieListAdmin();
		testGetMovieListCustomer();
		testModifyMovie();
	}

	public static void testGetMovieListAdmin() {
		MovieDaoCollectionImpl MovieDao = new MovieDaoCollectionImpl();
		List<Movies> movies = MovieDao.getMovieListAdmin();
		for (Movies movie : movies) {
			System.out.println(movie.toString());
		}
	}

	public static void testGetMovieListCustomer() {
		MovieDaoCollectionImpl MovieDao = new MovieDaoCollectionImpl();
		List<Movies> movies = MovieDao.getMovieListCustomer();
		for (Movies movie : movies) {
			System.out.println(movie.toString());
		}
	}

	public static void testModifyMovie() throws ParseException {
		MovieDaoCollectionImpl MovieDao = new MovieDaoCollectionImpl();
		Movies movie = new Movies(000002, "Titanic", 2187463844l, true, DateUtil.convertToDate("21/08/2018"), "Romance",
				false);
		MovieDao movie_dao = MovieDao;
		movie_dao.modifyMovie(movie);
		System.out.println("modified movie" + movie_dao.getMovie(000002));
	}
}
