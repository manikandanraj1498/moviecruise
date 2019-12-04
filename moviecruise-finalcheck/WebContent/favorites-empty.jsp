<!doctype html>
<html>

<head>
<link rel="stylesheet" href="style\stylemovie.css">
<title>Favorites empty</title>
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
		<br>
		<p style="color: #737373;">
			<b>No items in Favorites. Use 'Add to Favorite' option in </b><a
				style="color: #007acc;" href="ShowMovieListCustomerServlet"><b>Movie
					List</b></a>.
		</p>

	</section>
	<footer>
		<p>Copyright © 2019</p>
	</footer>
</body>
</html>