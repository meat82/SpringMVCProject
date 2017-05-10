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
		$('#personsTable .userName').click(function() {
			var id = $(this).attr("id");
			var hidden_id = "#" + id + "_hidden";
			var input_value = $(hidden_id).val();
			console.log("input_value: " + input_value);
			console.log("id: " + id);
			$("#nav-sidepanel").show("slow");
		});
		$('.closebtn').click(function() {
			$("#nav-sidepanel").hide("slow");
		});
	} );
	
</script>