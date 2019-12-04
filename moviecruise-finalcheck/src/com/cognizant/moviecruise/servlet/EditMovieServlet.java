package com.cognizant.moviecruise.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * Servlet implementation class EditMovieServlet
 */
@WebServlet("/EditMovieServlet")
public class EditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMovieServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean activeFlag;

		String movieId = request.getParameter("movieid");
		System.out.println(movieId);
		String title = request.getParameter("title");
		System.out.println(title);
		String gross = request.getParameter("gross");
		System.out.println(gross);
		String active = request.getParameter("available");
		if (active.equals("yes")) {
			activeFlag = true;
		} else {
			activeFlag = false;
		}
		System.out.println(active);
		String dateOfLaunch = request.getParameter("date");
		System.out.println(dateOfLaunch);

		String genre = request.getParameter("genre");
		System.out.println(genre);
		boolean hasTeaser = request.getParameter("hasteaser") != null;
		System.out.println(hasTeaser);
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dateLaunch = sdf.parse(dateOfLaunch);
			Movies movies = new Movies(Long.parseLong(movieId), title, Long.parseLong(gross), activeFlag, dateLaunch,
					genre, hasTeaser);
			System.out.println("Movie To be updated is" + movies);
			MovieDaoSqlImpl movieDaoSqlImpl = new MovieDaoSqlImpl();
			MovieDao movieDao = movieDaoSqlImpl;
			movieDao.modifyMovie(movies);
			System.out.println("After updated" + movieDao.getMovieListAdmin());
			request.getRequestDispatcher("edit-movie-status.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
