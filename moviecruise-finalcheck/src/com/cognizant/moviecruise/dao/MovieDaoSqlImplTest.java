package com.cognizant.moviecruise.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.moviecruise.model.Movies;
import com.cognizant.moviecruise.util.DateUtil;

/**
 * 
 * @author ManiKandan V
 *
 */
public class MovieDaoSqlImplTest {
	public static void main(String args[]) throws ParseException {
		testGetMovieItemlistAdmin();
		testGetMovieItemListCustomer();
		testModifyMenuItem();

	}

	public static void testGetMovieItemlistAdmin() {
		MovieDaoCollectionImpl MovieDao = new MovieDaoCollectionImpl();
		List<Movies> movies = MovieDao.getMovieListAdmin();
		for (Movies movie : movies) {
			System.out.println(movie.toString());
		}
	}

	public static void testGetMovieItemListCustomer() {
		MovieDaoCollectionImpl MovieDao = new MovieDaoCollectionImpl();
		List<Movies> movies = MovieDao.getMovieListCustomer();
		for (Movies movie : movies) {
			System.out.println(movie.toString());
		}
	}

	public static void testModifyMenuItem() throws ParseException {
		MovieDaoCollectionImpl MovieDao = new MovieDaoCollectionImpl();
		try {
			Movies movieItem = new Movies(3, "Thor-DarkWorld", 2345678901l, false, DateUtil.convertToDate("11/12/2018"),
					"Superhero", true);
			MovieDao.modifyMovie(movieItem);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// MovieItemDaoSqlImpl movieItemDaoSqlImpl = new MovieItemDaoSqlImpl();
		Movies movieItem = MovieDao.getMovie(3);
		System.out.println("MenuItem:" + movieItem);

	}

}
