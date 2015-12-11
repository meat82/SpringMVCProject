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
		$('#formProcess #userName').keyup(function(event) {
			// will pass the form date using the jQuery serialize function
			var input_value = $(this).val()
			console.log("input_value: " + input_value);
			$.post('${pageContext.request.contextPath}/views/userId', {userName: input_value}, function(response) {
				if($.trim(response).length == 0 ) {
					$('#userNameResponse').hide();
				}
				else {
					$('#userNameResponse').show().text(response);
				}
			});
		});
	} );
</script>