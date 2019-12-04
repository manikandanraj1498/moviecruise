package com.cognizant.moviecruise.dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.cognizant.moviecruise.dao.ConnectionHandler;
import com.cognizant.moviecruise.model.Movies;

/**
 * 
 * @author ManiKandan V
 *
 */
public class MovieDaoSqlImpl implements MovieDao {

	@Override
	public List<Movies> getMovieListAdmin() {
		// TODO Auto-generated method stub
	
		PreparedStatement preparedStatement = null;
		List<Movies> movieList = new ArrayList<Movies>();
		ResultSet resultSet;
		
		Connection conn =null;
		boolean activeFlag, hasTeaserFlag;
		try {
			 conn = ConnectionHandler.getConnection();
			if (conn != null) {
				preparedStatement = conn.prepareStatement(
						"select mo_id, mo_title,mo_box_office,mo_active,mo_date_of_launch,mo_genre,mo_has_teaser from movies");
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {

					long id = resultSet.getLong("mo_id");
					String title = resultSet.getString("mo_title");
					Date dateOfLaunch = resultSet.getDate("mo_date_of_launch");
					String active = resultSet.getString("mo_active");
					long boxOffice = resultSet.getLong("mo_box_office");
					String genre = resultSet.getString("mo_genre");
					String hasTeaser = resultSet.getString("mo_has_teaser");
					if (hasTeaser != null && hasTeaser.equals("Yes")) {
						hasTeaserFlag = true;
					} else {
						hasTeaserFlag = false;
					}
					if (active != null && active.equals("Yes")) {
						activeFlag = true;
					} else {
						activeFlag = false;
					}
					Movies movies = new Movies(id, title, boxOffice, activeFlag, dateOfLaunch, genre, hasTeaserFlag);
					System.out.println(movies);
					movieList.add(movies);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return movieList;
	}

	@Override
	public List<Movies> getMovieListCustomer() {
		// TODO Auto-generated method stub
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		List<Movies> movieList = new ArrayList<Movies>();
		if (connection != null) {
			try {
				preparedStatement = connection
						.prepareStatement("select*from movies where mo_date_of_launch <=now() and mo_active='Yes'");
				resultSet = preparedStatement.executeQuery();
				boolean activeFlag, hasTeaserFlag;
				while (resultSet.next()) {

					long id = resultSet.getLong(1);
					String title = resultSet.getString(2);
					Date dateOfLaunch = resultSet.getDate(5);
					String active = resultSet.getString(4);
					long boxOffice = resultSet.getLong(3);
					String genre = resultSet.getString(6);
					String hasTeaser = resultSet.getString(7);
					if (hasTeaser != null && hasTeaser.equals("Yes")) {
						hasTeaserFlag = true;
					} else {
						hasTeaserFlag = false;
					}
					if (active != null && active.equals("Yes")) {
						activeFlag = true;
					} else {
						activeFlag = false;
					}
					Movies movies = new Movies(id, title, boxOffice, activeFlag, dateOfLaunch, genre, hasTeaserFlag);
					System.out.println(movies);
					movieList.add(movies);
				}
			}

			catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {

					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		return movieList;
	}

	@Override
	public void modifyMovie(Movies movie) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionHandler.getConnection();
		String sql = "update movies set mo_title=?,mo_box_office=?,mo_active=?,mo_date_of_launch=?,mo_genre=?,mo_has_teaser=? where mo_id=?";
		try {
			if (connection != null) {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, movie.getTitle());
				preparedStatement.setLong(2, movie.getBoxOffice());
				if (movie.isActive())
					preparedStatement.setString(3, "Yes");
				else
					preparedStatement.setString(3, "No");
				preparedStatement.setDate(4, new java.sql.Date(movie.getDateOfLaunch().getTime()));
				preparedStatement.setString(5, movie.getGenre());
				if (movie.isHasTeaser())
					preparedStatement.setString(6, "Yes");
				else
					preparedStatement.setString(6, "No");
				preparedStatement.setLong(7, movie.getMovieId());
				preparedStatement.executeUpdate();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Movies getMovie(long movieId) {
		// TODO Auto-generated method stub
		
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		Movies movie = null;
		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement("select * from movies where mo_id=?");
				preparedStatement.setLong(1, movieId);

				resultSet = preparedStatement.executeQuery();
				boolean activeFlag, hasTeaserFlag;
				Date dateOfLaunch;
				while (resultSet.next()) {
					String title = resultSet.getString(2);
					long boxOffice = resultSet.getLong(3);
					String active = resultSet.getString(4);
					dateOfLaunch = resultSet.getDate(5);
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
					movie = new Movies(movieId, title, boxOffice, activeFlag, dateOfLaunch, genre, hasTeaserFlag);
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
		return movie;

	}

}
