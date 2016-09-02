function getArea() {
	
	var city = document.getElementById("city");
	var cityId = city.options[city.selectedIndex].value;
	var xhttp;
	if (!cityId) {
		document.getElementById("area").innerHTML = "<option value=\"null\">-- Select Area --</option>";
		return;
	}
	xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			document.getElementById("area").innerHTML = xhttp.responseText;
		}
	};
	xhttp.open("POST", "SearchArea?cityId="+cityId, true);
	xhttp.send();
}