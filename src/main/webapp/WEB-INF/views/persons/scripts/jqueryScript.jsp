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
		$('#person').DataTable();
	} );
</script>