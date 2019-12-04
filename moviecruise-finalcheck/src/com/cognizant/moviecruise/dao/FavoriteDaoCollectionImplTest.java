package com.cognizant.moviecruise.dao;

import java.util.List;

import com.cognizant.moviecruise.model.Movies;

/**
 * 
 * @author MAnikandan V
 *
 */
public class FavoriteDaoCollectionImplTest {
	public static void main(String args[]) throws FavoriteEmptyException {
		testAddFavorite();
		testgetAllFavorites();
		testRemoveFavorite();
	}

	public static void testAddFavorite() throws FavoriteEmptyException {
		FavoriteDaoCollectionImpl favoriteDaoCollectionImpl = new FavoriteDaoCollectionImpl();
		FavoriteDao favoriteDao = favoriteDaoCollectionImpl;
		favoriteDao.addFavorite(2, 4);
		favoriteDao.addFavorite(2, 3);
		List<Movies> movieList = favoriteDao.getAllFavorites(2);
		System.out.println("Movie list :" + movieList);
	}

	public static void testgetAllFavorites() throws FavoriteEmptyException {
		FavoriteDaoCollectionImpl favoriteDaoCollectionImpl = new FavoriteDaoCollectionImpl();
		FavoriteDao favoriteDao = favoriteDaoCollectionImpl;
		List<Movies> movieList = favoriteDao.getAllFavorites(2);
		System.out.println("Movie list :" + movieList);
		System.out.println("num of fav :" + favoriteDao);
	}

	public static void testRemoveFavorite() throws FavoriteEmptyException {
		FavoriteDaoCollectionImpl favoriteDaoCollectionImpl = new FavoriteDaoCollectionImpl();
		FavoriteDao favoriteDao = favoriteDaoCollectionImpl;

		try {
			favoriteDao.removeFavorite(2, 4);
			List<Movies> movieList = favoriteDao.getAllFavorites(2);
			System.out.println("Movie list after removing Favorite:" + movieList);
		} catch (Exception e) {
			throw new FavoriteEmptyException("Favorite is empty");
		}
	}
}
