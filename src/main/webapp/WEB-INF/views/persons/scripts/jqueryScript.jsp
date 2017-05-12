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
		var data =eval('${persons}');
		//$('#personsTable').DataTable();
		var table = $('#personsTable').DataTable( {
			dom: 'Bfrtip',
			aaData: data,
			aoColumns: [
			{ "mData": "userName"},
			{ "mData": "firstName"},
			{ "mData": "lastName"},
			{ "mData": "eMail"},
			{ "mData": "phone"},
			{ "mData": "status"},
			{ "mData": "userId"}
			],
	        columnDefs: [
	            {
	                "targets": [ 6 ],
	                "visible": false,
	                "searchable": false
	            }
	        ],
		    buttons: [
		        'copy','showNode'
		    ],
		    select: true
		});
		$("#nav-sidepanel").hide();

		$('.showPersonBtn').click( function () {
			var rows = $('#personsTable tbody .selected');
		    var row_data = table.row( rows ).data();
		    var input_value = row_data.userId;
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
		} );
	});
	
	$('.closebtn').click(function() {
		$("#nav-sidepanel").hide("slow");
	});
	$.fn.dataTable.ext.buttons.showNode = {
	    text: 'Show',
           exportOptions: {
               modifier: {
                   selected: true
               }
           },
		className:'showPersonBtn'
	};

</script>