package com.cognizant.moviecruise.model;

import java.util.List;

/**
 * 
 * @author ManiKandan V
 *
 */
public class Favorites {
	private List<Movies> movieList;
	private long numOfFavorites;

	public List<Movies> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movies> movieList) {
		this.movieList = movieList;
	}

	public long getNumOfFavorites() {
		return numOfFavorites;
	}

	public void setNumOfFavorites(long numOfFavorites) {
		this.numOfFavorites = numOfFavorites;
	}

	public Favorites(List<Movies> movieList, long numOfFavorites) {
		super();
		this.movieList = movieList;
		this.numOfFavorites = numOfFavorites;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movieList == null) ? 0 : movieList.hashCode());
		result = prime * result + (int) (numOfFavorites ^ (numOfFavorites >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favorites other = (Favorites) obj;
		if (movieList == null) {
			if (other.movieList != null)
				return false;
		} else if (!movieList.equals(other.movieList))
			return false;
		if (numOfFavorites != other.numOfFavorites)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Favorites [movieList=" + movieList + ", numOfFavorites=" + numOfFavorites + "]";
	}

}
