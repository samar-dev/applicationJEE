<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
 	<script type="text/javascript" language="javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div class="row">
        <div class="col-12">
<div class="dataTables_length" id="example_length">
<div class="table-responsive">
<table id="myTable" class="display" style="width:100%">
        <thead>
            <tr>
                <th>User ID</th>
                <th>nom</th>
                <th>prenom</th>
                <th>login</th>
                <th>password</th>
               
            </tr>
        </thead>
         
    </table>
    </div>
     </div>
      </div>
       </div>
   </body>
<script type="text/javascript">
$(document).ready( function () {
	load_data();
} );
function load_data(){
	var data={act:"show"};
	$('#myTable').DataTable({
	ajax:{
		url:"${pageContext.request.contextPath}/Users",
		type:"get",
		data:data,
		dataSrc:"result"
	},
	columns:[
	{data : "iduser"},
	{data : "nom"},
	{data : "prenom"},
	{data : "login"},
	{data : "password"}
	]
	})
	}
</script>

</html>