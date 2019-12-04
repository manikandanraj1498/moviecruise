function ValidateMovie() {
	var title = document.forms["editMovie"]["title"].value;
	var gross = document.forms["editMovie"]["gross"].value;
	var date = document.forms["editMovie"]["date"].value;
	var genre = document.forms["editMovie"]["genre"].value;
	if (title == "") {
		alert("Title is required");
		return false;
	} else if (title.length < 2 || title.length > 100) {
		alert("Title should have 2 to 100 characters.");
		return false;
	} else if (gross == "") {
		alert("Box Office is required.");
		return false;
	} else if (isNaN(gross)) {
		alert("Box Office has to be a number.");
		return false;
	} else if (date == "") {
		alert("Date of Launch is required.");
		return false;
	} else if (genre == "") {
		alert("Select one genre");
		return false;
	}
}