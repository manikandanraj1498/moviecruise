package com.cognizant.moviecruise.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecruise.model.Movies;
import com.cognizant.moviecruise.util.DateUtil;

/**
 * 
 * @author ManiKandan V
 *
 */
public class MovieDaoCollectionImpl implements MovieDao {
	static List<Movies> movieList;

	public MovieDaoCollectionImpl() {
		if (movieList == null) {
			try {
				movieList = new ArrayList<Movies>();
				movieList.add(new Movies(000001, "Avatar", 2787965087l, true, DateUtil.convertToDate("15/03/2017"),
						"Science Fiction", true));
				movieList.add(new Movies(000002, "The Avengers", 1518812988l, true,
						DateUtil.convertToDate("23/12/2017"), "Superhero", false));
				movieList.add(new Movies(000003, "Titanic", 2187463844l, true, DateUtil.convertToDate("21/08/2018"),
						"Romance", false));
				movieList.add(new Movies(000004, "Jurrasic World", 1671713208l, false,
						DateUtil.convertToDate("02/07/2017"), "Science Fiction", true));
				movieList.add(new Movies(000005, "Avengers: Endgame", 2750760348l, true,
						DateUtil.convertToDate("02/11/2022"), "Superhero", true));

			} catch (ParseException pe) {
				System.out.println("Parse Exception " + pe.getMessage());
			}
		}

	}

	@Override
	public List<Movies> getMovieListAdmin() {
		// TODO Auto-generated method stub
		return movieList;
	}

	@Override
	public List<Movies> getMovieListCustomer() {
		// TODO Auto-generated method stub
		List<Movies> movieListCustomer = new ArrayList<Movies>();
		Date today = new Date();
		for (Movies movie : movieList) {
			if (movie.getDateOfLaunch().getTime() <= today.getTime() && movie.isActive()) {
				movieListCustomer.add(movie);
			}
		}
		return movieListCustomer;
	}

	@Override
	public void modifyMovie(Movies movie) {
		// TODO Auto-generated method stub
		for (Movies movie_modify : movieList) {
			if (movie.getMovieId() == movie_modify.getMovieId()) {
				movie_modify.setTitle(movie.getTitle());
				movie_modify.setGenre(movie.getGenre());
				movie_modify.setDateOfLaunch(movie.getDateOfLaunch());
				movie_modify.setBoxOffice(movie.getBoxOffice());
				movie_modify.setActive(movie.isActive());
				movie_modify.setHasTeaser(movie.isHasTeaser());
			}
		}

	}

	@Override
	public Movies getMovie(long movieId) {
		// TODO Auto-generated method stub
		for (Movies movie : movieList) {
			if (movieId == movie.getMovieId()) {
				return movie;
			}
		}
		return null;
	}

}
