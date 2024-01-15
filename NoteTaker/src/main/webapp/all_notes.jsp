<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.entities.Note"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ALL Notes: Note Taker</title>
<%@include file ="all_js_css.jsp" %>
</head>
<body>

<div class="container-fluid p-0 m-0">

<%@include file ="navbar.jsp" %>
<br>

<h1 class="text-uppercase">All Notes:</h1>

	<div class="row">	<!--creating a row here  -->
	
		<div class="col-12">  <!--creating columns inside row and max no of column is 12 -->
		
		<!--Creating an Session here to get all notes data and show it on web page  -->
	<%
		/*Opening a seesion  */
		Session s = FactoryProvider.getfactory().openSession();
		/*Writing a HQL query to get notes and show it  */
		Query q=s.createQuery("from Note");
		/*Getting list of notes also storing in list */
		List<Note>list=q.list();
		
		for(Note note:list)
		{ 
		%>
		<!-- Adding a card to show all note details in it -->
	<div class="card mt-3">
  			<img class="card-img-top m-4" style="max-width:50px" src="img/one-note.png" alt="Card image cap">
  		<div class="card-body px-5">
   			 <h5 class="card-title"><%=note.getTitle() %></h5>
   			 <p class="card-text">
			<%= note.getContent()%>
			</p>
			
   			 <div class="container text-center mt-2">
   			 <a href="DeleteServlet?note_id=<%=note.getId() %>" class="btn btn-danger">Delete</a>
   			  <a href="edit.jsp?note_id=<%=note.getId()%>" class="btn btn-primary">Update</a>
   			 </div>
   			 
 		</div>
	</div>
		<% 		
		}
		s.close();
	%>
		
		
		</div>
	
	</div>

		

</div>


</body>
</html>