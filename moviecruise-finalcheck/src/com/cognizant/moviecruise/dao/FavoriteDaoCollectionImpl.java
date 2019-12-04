package com.cognizant.moviecruise.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.cognizant.moviecruise.model.Favorites;
import com.cognizant.moviecruise.model.Movies;

/**
 * 
 * @author ManiKandan V
 *
 */
public class FavoriteDaoCollectionImpl implements FavoriteDao {
	private static HashMap<Long, Favorites> userFavorites;

	public FavoriteDaoCollectionImpl() {
		if (userFavorites == null) {
			userFavorites = new HashMap<Long, Favorites>();
			try {

				List<Movies> movieList = new ArrayList<Movies>();
				Favorites favorite = new Favorites(movieList, 0);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public void addFavorite(long userId, long movieId) {
		// TODO Auto-generated method stub
		List<Movies> movieList;
		MovieDaoCollectionImpl movieDaoCollectionImpl = new MovieDaoCollectionImpl();
		MovieDao movieDao = movieDaoCollectionImpl;
		Long userid = new Long(userId);
		Movies movie = movieDao.getMovie(movieId);
		if (userFavorites.containsKey(userid)) {
			Favorites favorite = userFavorites.get(userid);
			movieList = favorite.getMovieList();
			movieList.add(movie);
			favorite.setMovieList(movieList);
			userFavorites.put(userid, favorite);

		} else {
			movieList = new CopyOnWriteArrayList<Movies>();
			movieList.add(movie);

			Favorites favorite = new Favorites(movieList, movie.getBoxOffice());
			userFavorites.put(userid, favorite);

		}

	}

	@Override
	public List<Movies> getAllFavorites(long userId)
			throws FavoriteEmptyException {
		// TODO Auto-generated method stub
		Favorites favorite = userFavorites.get(new Long(userId));
		if (favorite == null) {
			throw new FavoriteEmptyException("Favorite is empty");
		}
		List<Movies> movieList = favorite.getMovieList();
		if (movieList == null || movieList.size() == 0) {
			throw new FavoriteEmptyException("Favorite is empty");
		}
		long numOfFavorites = 0;
		numOfFavorites = numOfFavorites + movieList.size();
		favorite.setNumOfFavorites(numOfFavorites);
		return movieList;
	}

	@Override
	public void removeFavorite(long userId, long movieId) {
		// TODO Auto-generated method stub
		if (userFavorites.containsKey(userId)) {
			Favorites favorite = userFavorites.get(userId);
			List<Movies> movieList = favorite.getMovieList();
			for (Movies movie : movieList) {
				if (movie.getMovieId() == movieId) {
					movieList.remove(movie);
				}
			}
			favorite.setMovieList(movieList);
			userFavorites.put(userId, favorite);

		}
	}

}
