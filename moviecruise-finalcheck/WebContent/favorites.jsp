<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html>

<head>
<link rel="stylesheet" href="style\stylemovie.css">
<title>Favorites</title>
</head>
<body>

	<header class="header container-fluid">
		<h1 class="header-itemleft">Movie Cruiser</h1>
		<img class="header-img" src="images\reel.png"> <a
			class="header-itemright-Fav" href="ShowFavoriteServlet">Favorites</a>
		<a class="header-itemright-Mov" href="ShowMovieListCustomerServlet">Movies</a>
	</header>

	<section class="body-main">
		<h1>Favorites</h1>
		<c:if test="${removeFavoriteStatus}">
			<h3 style="color: #00b300; text-align: center;">Movie removed
				from Favorites successfully</h3>
		</c:if>
		<table width="100%">
			<tr>
				<th class="th-allignleft">Title</th>
				<th class="th-allignright">Box Office</th>
				<th>Genre</th>
				<th></th>
			</tr>
			<c:set var="sum" value="${0}"></c:set>
			<c:forEach var="fav" items="${favoriteMovieList}">
				<tr>

					<td class="td-allignleft">${fav.title}</td>


					<td class="td-allignright"><fmt:setLocale value="en_US"
							scope="session" />
						<fmt:formatNumber type="currency" value="${fav.boxOffice}" /></td>
					<c:set var="sum" value="${sum+1}"></c:set>
					<td><c:out value="${fav.genre}"></c:out></td>
					<td><a href="RemoveFavoriteServlet?movieId=${fav.movieId }">Delete</a>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td class="td-allignleft"><h3>
						No. of Favorites:
						<c:out value="${sum}" />
					</h3></td>

			</tr>
		</table>
	</section>
	<footer>
		<p>Copyright © 2019</p>
	</footer>
</body>
</html>
