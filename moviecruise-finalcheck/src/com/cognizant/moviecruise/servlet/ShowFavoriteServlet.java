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
import com.cognizant.moviecruise.dao.FavoriteEmptyException;
import com.cognizant.moviecruise.model.Movies;

/**
 * 
 * @author ManiKandan V
 *
 */

/**
 * Servlet implementation class ShowFavoriteServlet
 */
@WebServlet("/ShowFavoriteServlet")
public class ShowFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowFavoriteServlet() {
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
		FavoriteDaoSqlImpl favoriteDaoSqlImpl = new FavoriteDaoSqlImpl();
		FavoriteDao FavoriteDao = favoriteDaoSqlImpl;

		try {
			List<Movies> movieList = FavoriteDao.getAllFavorites(userId);
			System.out.println("getAllfavs:" + movieList);
			request.setAttribute("favoriteMovieList", movieList);
			request.getRequestDispatcher("favorites.jsp").forward(request, response);

		} catch (FavoriteEmptyException e) {
			// TODO Auto-generated catch block
			request.getRequestDispatcher("favorites-empty.jsp").forward(request, response);
		}
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
