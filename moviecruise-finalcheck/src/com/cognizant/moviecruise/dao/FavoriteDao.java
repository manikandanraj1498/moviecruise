package com.cognizant.moviecruise.dao;

import java.util.List;

import com.cognizant.moviecruise.model.Movies;

/**
 * 
 * @author Manikandan V
 *
 */
public interface FavoriteDao {
	public void addFavorite(long userId, long movieId);

	public List<Movies> getAllFavorites(long userId) throws FavoriteEmptyException;

	public void removeFavorite(long userId, long movieId);
}
