<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.cognizant.moviecruise.model.Movies"%>
<!doctype html>
<html>

<head>
<script src="js\validatemovie.js"></script>
<link rel="stylesheet" href="style\stylemovie.css">
<style>
.body-main th {
	text-align: left;
}

.body-main td {
	text-align: left;
}
</style>
<title>Edit Movie</title>
</head>
<body>

	<header class="header container-fluid">
		<h1 class="header-itemleft">Movie Cruiser</h1>
		<img class="header-img" src="images\reel.png"> <a
			class="header-itemright" href="ShowMovieListAdminServlet">Movies</a>
	</header>

	<section class="body-main">

		<h1>Edit Movie</h1>
		<c:set var="categories"
			value="Science Fiction,Superhero,Romance,Comedy,Adventure,Thriller"
			scope="application"></c:set>
		<c:set var="selected" value="${movies.genre}" scope="application" />
		<form name="editMovie" action="EditMovieServlet"
			onsubmit="return ValidateMovie()" method="post">
			<table style="width: 100%">
				<tr>
					<th colspan="4" class="edittable"><label for="mtitle">Title</label></th>
				</tr>
				<tr>
					<td colspan="4"><input type="text" name="title" id="mtitle"
						style="width: 815px; height: 35px" value="${movies.title}"></td>
				</tr>
				<tr>
					<th class="edittable"><label for="mgross">Gross ($)</label></th>
					<th class="edittable">Active</th>
					<th class="edittable"><label for="mdate">Date of
							Launch</label> </th>
					<th class="edittable"><label for="mgenre">Genre</label></th>
				</tr>
				<tr>
					<td><input type="text" style="height: 25px" id="mgross"
						name="gross" value="${movies.boxOffice}"></td>
					<c:choose>
						<c:when test="${movies.active}">
							<td><input type="radio" name="available" value="yes"
								id="yes" checked><label>Yes</label> <input type="radio"
								name="available" value="no" id="no"><label>No</label></td>
						</c:when>

						<c:otherwise>

							<td><input type="radio" name="available" value="yes"
								id="yes"><label>Yes</label> <input type="radio"
								name="available" value="no" id="yes" checked><label>No</label>
							</td>
						</c:otherwise>
					</c:choose>
					<td><input style="height: 25px; width: 200px" type="date"
						name="date" id="mdate"
						value="<fmt:formatDate pattern="dd/MM/yyyy" value="${movies.dateOfLaunch}" />"></td>
					<td><select name="genre" id="genre" style="height: 25px">
							<option value="${movies.genre}" selected>${selected}</option>
							<c:forEach items="${categories}" var="genre">
								<c:if test="${genre!=selected}">
									<option value="${genre}">${genre}</option>
								</c:if>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="edittable"><input type="checkbox" id="hasteaser"
						name="hasteaser" value=""
						<c:if test="${movies.hasTeaser}"> checked="checked"</c:if>>
						<label>Has Teaser</label>
					<td>
				</tr>
				<tr>
					<td class="edittable"><input type="submit" class="button"
						value="Save"></td>
				</tr>
			</table>
			<input type="hidden" id="movieid" name="movieid"
				value="${movies.movieId }">
		</form>
	</section>
	<footer>
		<p>Copyright © 2019</p>
	</footer>
</body>
</html>