<%@page import="com.mysql.jdbc.Statement"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="domaine.User" %>  
<%@page import="java.sql.ResultSet" %> 
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
 <% 
 ArrayList<User> users= (ArrayList<User>)session.getAttribute("users");
 //ResultSet rs = (ResultSet) session.getAttribute("users");%>
     
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
<% 
if (users!=null){ 
for(User u : users) {
%>
<tr>
<td> <%=u.getIduser() %></td>
<td> <%=u.getNom()%></td>
<td> <%=u.getPrenom()%></td>
<td> <%=u.getLogin()%></td>
<td> <%=u.getPassword()%></td>
</tr>
<%
}
}
%>
    </table>
    </div>
     </div>
      </div>
       </div>
   </body>
<script type="text/javascript">
$(document).ready( function () {
	//load_data();
	$('#myTable').DataTable();
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