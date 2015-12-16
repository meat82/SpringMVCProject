<script type="text/javascript">
	$(document).ready(function() {
		var sessionid = $( "#header_session" ).val();
		if(sessionid || sessionid.length > 0) {
			$( ".menuLogin" ).remove();	
		}
		if(!sessionid || 0 === sessionid.length) {
			$( ".menuLogout" ).remove();	
		}	
			
	} );
</script>