package com.cognizant.moviecruise.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruise.dao.MovieDao;
import com.cognizant.moviecruise.dao.MovieDaoCollectionImpl;
import com.cognizant.moviecruise.dao.MovieDaoSqlImpl;
import com.cognizant.moviecruise.model.Movies;

/**
 * 
 * @author ManiKandan V
 *
 */

/**
 * Servlet implementation class ShowEditMovieServlet
 */
@WebServlet("/ShowEditMovieServlet")
public class ShowEditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowEditMovieServlet() {
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
		MovieDaoSqlImpl movieDaoSqlImpl = new MovieDaoSqlImpl();
		MovieDao movieDao = movieDaoSqlImpl;
		long movieId = Long.parseLong(request.getParameter("movieId"));
		Movies movies = movieDao.getMovie(movieId);
		System.out.println("Menu Item===" + movies);
		request.setAttribute("movies", movies);
		request.getRequestDispatcher("edit-movie.jsp").forward(request, response);
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
