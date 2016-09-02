function checkEmptyOrNot(){
	var d1 = document.getElementById("city");
	var city = d1.options[d1.selectedIndex].value;
	var d2 = document.getElementById("area");
	var area = d2.options[d2.selectedIndex].value;
	var d3 = document.getElementById("propertyTypes");
	var propertyTypes = d3.options[d3.selectedIndex].value;
	var d4 = document.getElementById("minPrice");
	var minPrice = d4.options[d4.selectedIndex].value;
	var d5 = document.getElementById("maxPrice");
	var maxPrice = d5.options[d5.selectedIndex].value;
	if(city == "null" || area == "null" || propertyTypes == "null" || minPrice == "null" || maxPrice == "null"){
		alert("Please Select from All");
		return false;
	}
	else return true;
}