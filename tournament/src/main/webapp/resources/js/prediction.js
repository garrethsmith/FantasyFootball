$(document).ready (function () {			
	var userpredictions = document.getElementsByClassName("userprediction");
	for (var i=0; i<userpredictions.length; i++) {
		userpredictions[i].addEventListener('focusout', updateScore, false);
	}
	
	$("#resetLog").bind( "click", function() {
		$("div#results").text("");
	});
})

function updateScore () {
	$("div#results").append("<p>Posting User/Game ID "  + this.id + " Value " + this.value + "</p>");

	var prediction = {}
	prediction["id"] = this.id;
	prediction["value"] = this.value;
	
	showPageLog ("<p>JSon  "  + prediction + "</p>");

	$.ajax({
		type : "POST",
		url : "/tournament/setPrediction.html",
		data : JSON.stringify(prediction),
		contentType: "application/json; charset=utf-8",
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
	showPageLog("<p>Ajax call made from " + from + " Result " + result + "</p>");
	var returnVal = result.substring(0, result.indexOf(':'));
	var json = result.substring(result.indexOf(':')+1);
	result = JSON.parse(json);
	if (from == "success" && returnVal == "SUCCESS") { flashResult ("#B4EEB4", result.id);}
	else { flashResult ("#ffcccc", result.id);}
}

function flashResult (colour, id) {
	$('input#'+id).css("background-color", colour);
	$('input#'+id).fadeTo("slow", 0.5).fadeTo("slow", 1.0, function () {
		$('input#'+id).css("background-color", "white");
	});
}

function showPageLog (string) {
	$("div#results").append(string);
}







