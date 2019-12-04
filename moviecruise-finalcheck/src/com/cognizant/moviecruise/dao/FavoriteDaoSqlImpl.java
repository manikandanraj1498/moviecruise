package com.cognizant.moviecruise.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecruise.model.Favorites;
import com.cognizant.moviecruise.model.Movies;
import com.cognizant.moviecruise.dao.ConnectionHandler;

/**
 * 
 * @author ManiKandan V
 *
 */
public class FavoriteDaoSqlImpl implements FavoriteDao {

	@Override
	public void addFavorite(long userId, long movieId) {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement;
		Connection connection = ConnectionHandler.getConnection();
		try {
			if (connection != null) {
				preparedStatement = connection
						.prepareStatement("insert into favorites values (default, ?, ?)");
				preparedStatement.setLong(1, userId);
				preparedStatement.setLong(2, movieId);
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<Movies> getAllFavorites(long userId)
			throws FavoriteEmptyException {
		// TODO Auto-generated method stub
		Connection connection = null;
		List<Movies> movieList = new ArrayList<Movies>();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		boolean activeFlag, hasTeaserFlag;
		Movies movie = null;
		try {
			connection = ConnectionHandler.getConnection();
			if (connection != null) {

				Favorites favorites = new Favorites(movieList, 0);

				StringBuffer sqlBuffer = new StringBuffer();
				sqlBuffer
						.append("select mi.mo_id,mi.mo_title,mi.mo_box_office,mi.mo_active,mi.mo_date_of_launch,mi.mo_genre,mi.mo_has_teaser from movies mi ")
						.append("inner join favorites fv on mi.mo_id=fv.fe_mo_id where fv.fe_us_id=?");
				System.out.println("SqlString:" + sqlBuffer.toString());
				preparedStatement = connection.prepareStatement(sqlBuffer.toString());
				preparedStatement.setLong(1, userId);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					int movieId = resultSet.getInt(1);
					String title = resultSet.getString(2);
					long boxOffice = resultSet.getLong(3);
					String active = resultSet.getString(4);
					Date dateOfLaunch = resultSet.getDate(5);
					String genre = resultSet.getString(6);
					String hasTeaser = resultSet.getString(7);

					if (active != null && active.equals("Yes"))
						activeFlag = true;
					else
						activeFlag = false;
					if (hasTeaser != null && hasTeaser.equals("Yes"))
						hasTeaserFlag = true;
					else
						hasTeaserFlag = false;
					movie = new Movies(movieId, title, boxOffice, activeFlag,
							dateOfLaunch, genre, hasTeaserFlag);
					movieList.add(movie);
				}
				favorites.setMovieList(movieList);
				favorites.setNumOfFavorites(getNumOfFavorites(userId,connection));
				System.out.println("Records fetched successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (movieList.size() == 0) {
			throw new FavoriteEmptyException("Favorites is Empty");
		}

		return movieList;
	}

	private long getNumOfFavorites(long userId, Connection conn) {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		long noOfFavorites = 0;
		List<Movies> movieList = new ArrayList<Movies>();
		try {
			if (conn != null) {
				Favorites Favorites = new Favorites(movieList, 0);
				StringBuffer sqlBuffer = new StringBuffer();
				sqlBuffer
						.append("select count(mo_box_office) from movies inner join favorites on movies.mo_id=favorites.fe_mo_id ")
						.append("where favorites.fe_us_id=?");
				System.out.println("SqlString:" + sqlBuffer.toString());

				preparedStatement = conn.prepareStatement(sqlBuffer.toString());
				resultSet = preparedStatement.executeQuery();
				
				preparedStatement.setLong(1, userId);
				while (resultSet.next()) {
					noOfFavorites = resultSet.getLong(1);
				}
				System.out.println("Records fetched successfully");
			}
		}

		catch (SQLException sq) {
			sq.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return noOfFavorites;
	}

	@Override
	public void removeFavorite(long userId, long movieId) {
		// TODO Auto-generated method stub
		PreparedStatement prepareStatement;
		Connection conn = null;
		try {
			conn = ConnectionHandler.getConnection();
			if (conn != null) {
				prepareStatement = conn
						.prepareStatement("delete from favorites where fe_us_id=? and fe_mo_id=?");
				prepareStatement.setInt(1, (int) userId);
				prepareStatement.setInt(2, (int) movieId);
				prepareStatement.executeUpdate();
				System.out.println("record deletd successfully..");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
