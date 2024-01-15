<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Notes</title>
<%@include file ="all_js_css.jsp" %>
</head>
<body>

<div class="container-fluid p-0 m-0">
    
    <%@include file ="navbar.jsp" %>
    <br>
    <h1>fill you note details</h1>
   
   <!--Adding a form  to add title and its content-->
   <form action="SaveNoteServlet" method="post">
   
   
  <div class="form-group">
    <label for="Note">Note Title</label>
    <input 
    name="title"
    required type="text" 
    class="form-control" 
    id="title" 
    aria-describedby="emailHelp" 
    placeholder="Enter text here"/>
  </div>
  
  
  <div class="form-group">
    <label for="content">Note Content</label>
    <textarea 
    name="content"
    required="content" 
    placeholder="Enter your content here"
    class ="form-control" 
    style="height:300px"></textarea>
    </div>
 
    <div class="container text-center">
    <button type="submit" class="btn btn-success btn btn-lg "> Add</button>
    
    </div>
  
</form>
   
    </div>


</body>
</html>