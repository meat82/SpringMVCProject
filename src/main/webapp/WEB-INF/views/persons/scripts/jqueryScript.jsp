<script type="text/javascript">
	$(document).ready(function() {
		var sessionid = $( "#header_session" ).val();
		console.log("sessionid: " + sessionid);
		if(sessionid || sessionid.length > 0) {
			$( ".menuLogin" ).remove();	
		}
		if(!sessionid || 0 === sessionid.length) {
			$( ".menuLogout" ).remove();	
		}	
		$('#personsTable').DataTable();
		$("#nav-sidepanel").hide();
	} );
	$('#personsTable .userName').click(function() {
		var id = $(this).attr("id");
		var hidden_id = "#" + id + "_hidden";
		var input_value = $(hidden_id).val();
		console.log("click!")
		//http://api.jquery.com/jquery.ajax/
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : '${pageContext.request.contextPath}/views/getPerson',
			data : input_value,
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				$("#nav-sidepanel #userNameId").val(data.result.userName);
				$("#nav-sidepanel #firstNameId").val(data.result.firstName);
				$("#nav-sidepanel #lastNameId").val(data.result.lastName);
				$("#nav-sidepanel #emailId").val(data.result.eMail);
				$("#nav-sidepanel #phoneId").val(data.result.phone);
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
		$("#nav-sidepanel").show("slow");
	});
	$('.closebtn').click(function() {
		$("#nav-sidepanel").hide("slow");
	});
</script>