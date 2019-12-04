<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.cognizant.moviecruise.model.Movies"%>
<!doctype html>
<html>
<head>
<link rel="stylesheet" href="style\stylemovie.css">
<title>Movie list admin</title>
</head>
<body>

	<header class="header container-fluid">
		<h1 class="header-itemleft">Movie Cruiser</h1>
		<img class="header-img" src="images\reel.png"> <a
			class="header-itemright" href="ShowMovieListAdminServlet">Movies</a>
	</header>

	<section class="body-main">
		<h1>Movies</h1>
		<table width="100%">
			<tr>
				<th class="th-allignleft">Title</th>
				<th class="th-allignright">Box Office</th>
				<th>Active</th>
				<th>Date of launch</th>
				<th>Genre</th>
				<th>Has Teaser</th>
				<th>Action</th>
			</tr>
			<c:forEach var="item" items="${adminMovieList}">
				<tr>
					<td class="td-allignleft">${item.title}</td>
					<td class="th-allignright"><fmt:setLocale value="en_US" />
						<fmt:formatNumber type="currency" value="${item.boxOffice}" /></td>
					<td>${item.active ? 'Yes' : 'No'  }</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy"
							value="${item.dateOfLaunch }" /></td>
					<td>${item.genre}</td>
					<td>${item.hasTeaser ? 'Yes' : 'No' }</td>
					<td><a href="ShowEditMovieServlet?movieId=${item.movieId}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</section>
	<footer>
		<p>Copyright © 2019</p>
	</footer>
</body>
</html>





