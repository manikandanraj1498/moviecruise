package com.cognizant.moviecruise.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruise.dao.FavoriteDao;
import com.cognizant.moviecruise.dao.FavoriteDaoCollectionImpl;
import com.cognizant.moviecruise.dao.FavoriteDaoSqlImpl;
import com.cognizant.moviecruise.dao.MovieDao;
import com.cognizant.moviecruise.dao.MovieDaoCollectionImpl;
import com.cognizant.moviecruise.dao.MovieDaoSqlImpl;
import com.cognizant.moviecruise.model.Movies;
import com.cognizant.moviecruise.dao.FavoriteDaoSqlImplTest;

/**
 * 
 * @author ManiKandan V
 *
 */

/**
 * Servlet implementation class AddToFavoriteServlet
 */
@WebServlet("/AddToFavoriteServlet")
public class AddToFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToFavoriteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		long userId = 1;

		System.out.println("inside do get");
		long movieId = Long.parseLong(request.getParameter("movieId"));
		FavoriteDaoSqlImpl favoriteDaoSqlImpl = new FavoriteDaoSqlImpl();
		//FavoriteDaoSqlImplTest FavoriteDao = favoriteDaoSqlImpl;
		favoriteDaoSqlImpl.addFavorite(userId, movieId);

		MovieDaoSqlImpl movieDaoSqlImpl = new MovieDaoSqlImpl();
		MovieDao movieDao = movieDaoSqlImpl;
		List<Movies> movieList = movieDao.getMovieListCustomer();

		request.setAttribute("addFavoriteStatus", true);
		request.setAttribute("customerMovieList", movieList);
		request.getRequestDispatcher("movie-list-customer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
