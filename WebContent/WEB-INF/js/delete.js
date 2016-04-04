/**
 * http://54.153.76.180/
 */


$(document).ready(function() {
	
	$(document.body).on('click', ':button, .DELETE_BTN', function(e) {	
		var userid = $('input[name="userid"]').val();		
		console.log(userid);
		ajaxObj = {
				type : "DELETE",
				url : "http://54.153.76.180:8080/cmpe275-lab2/profile/" + userid,
				success : function() {
					console.log("deleted");
					location.href = "http://54.153.76.180:8080/cmpe275-lab2/profile/"
				},
				complete : function(XMLHttpRequest) {
					console.log("completed");
					location.href = "http://54.153.76.180:8080/cmpe275-lab2/profile/"
				}
			};
		return $.ajax(ajaxObj);
	});
});