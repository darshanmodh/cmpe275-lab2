/**
 * http://54.153.76.180/
 */

$(document).ready(function() {
	
	$(document.body).on('click', ':button, .CREATE_BTN', function(e) {	
		var userid = $('input[name="userid"]').val();		
		console.log(userid);
		ajaxObj = {
				type : "POST",
				url : "http://54.153.76.180:8080/cmpe275-lab2/profile/",
				success : function() {
					console.log("created");
					location.href = "http://54.153.76.180:8080/cmpe275-lab2/profile/" + userid
				},
				complete : function(XMLHttpRequest) {
					console.log("completed");
					location.href = "http://54.153.76.180:8080/cmpe275-lab2/profile/" + userid
				}
			};
		return $.ajax(ajaxObj);
	});
});