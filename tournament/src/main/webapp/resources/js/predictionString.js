$(document).ready (function () {			
	var userpredictions = document.getElementsByClassName("userprediction");
	for (var i=0; i<userpredictions.length; i++) {
		userpredictions[i].addEventListener('focusout', updateScore, false);
	}
	
	//blah blah
})

function updateScore () {
	$("div#results").append("<p>Posting User/Game ID "  + this.id + " Value " + this.value + "</p>");

	var prediction = {}
	prediction["id"] = this.id;
	prediction["value"] = this.value;

	JSON.stringify(prediction);

	$.ajax({
		type : "POST",
		url : "/tournament/setPredictionString.html",
		data : prediction,
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			displayResult(data, "success");
		},
		error : function(e) {
			console.log("ERROR: ", e);
			displayResult(e, "error");
		},
		done : function(e) {
			console.log("DONE");
			displayResult(true, "done");
		}
	});
}

function displayResult (result, from) {
	$("div#results").append("<p>Ajax call made from "  + from + " Result " + result + "</p>");
}