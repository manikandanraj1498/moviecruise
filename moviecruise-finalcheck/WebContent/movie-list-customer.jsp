<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.cognizant.moviecruise.model.Movies"%>
<!doctype html>
<html>

<head>
<link rel="stylesheet" href="style\stylemovie.css">
<title>Movie list customer</title>
</head>
<body>

	<header class="header container-fluid">
		<h1 class="header-itemleft">Movie Cruiser</h1>
		<img class="header-img" src="images\reel.png"> <a
			class="header-itemright-Fav" href="ShowFavoriteServlet">Favorites</a>
		<a class="header-itemright-Mov" href="ShowMovieListCustomerServlet">Movies</a>
	</header>

	<section class="body-main">
		<h1>Movies</h1>
		<c:if test="${addFavoriteStatus}">
			<h3 style="color: #00b300; text-align: center;">Movie added to
				Favorites Successfully</h3>
		</c:if>
		<table width="100%">
			<tr>
				<th class="th-allignleft">Title</th>
				<th class="th-allignright">Box Office</th>
				<th>Genre</th>
				<th>Has Teaser</th>
				<th>Action</th>
			</tr>
			<c:forEach var="item" items="${customerMovieList}">
				<tr>
					<td class="td-allignleft">${item.title}</td>
					<td class="th-allignright"><fmt:setLocale value="en_US" />
						<fmt:formatNumber type="currency" value="${item.boxOffice}" /></td>
					<td>${item.genre}</td>
					<td>${item.hasTeaser ? 'Yes' : 'No' }</td>
					<td><a href="AddToFavoriteServlet?movieId=${item.movieId}">Add
							to Favorite</a></td>
				</tr>
			</c:forEach>
		</table>
	</section>
	<footer>
		<p>Copyright © 2019</p>
	</footer>
</body>
</html>
