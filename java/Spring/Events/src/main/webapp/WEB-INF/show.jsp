<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
          <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title><c:out value="${event.getName()}"/></title>
</head>
<body>
<div class="w-75 d-flex mx-auto">
<div class="p-4">
<h3> <c:out value="${event.getName()}"/> </h3>
<p> Date: <c:out value="${event.getDate()}"/> </p>
<p>Location: <c:out value="${event.getLocation()}"/> </p>
<p>people who attending this event : <c:out value="${event.getUsers().size()}"/></p>

<table class="table table-striped mb-5">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Location</th>
      
    </tr>
  </thead>
  <tbody>
  <c:forEach var="user" items="${event.getUsers()}">
    <tr>
      <td><c:out value="${user.getFirstName()}"/> <c:out value="${user.getLastName()}"/></td>
      <td><c:out value="${user.getLocation()}"/></td>
    </tr>
    </c:forEach> 
  </tbody>
</table>
</div>

<div class="p-4">
<h3 >Messages Wall</h3>
    <div class="p-4 overflow-auto h-50" >
        <c:forEach var="cmnt" items="${event.getComments()}">
        <p><c:out value="${cmnt.getUser().getFirstName()}"/> says : <c:out value="${cmnt.getComment()}"/></p>
        <hr>
        </c:forEach> 
    </div>
    
    <form:form action="/comment/create/${event.getId() }" method="post" modelAttribute="cmnt">
		  <div class="mb-3">
		    <label for="comment" class="form-label">Add Comment</label>
		    <form:textarea path="comment" cssClass="form-control" cssErrorClass="form-control is-invalid" rows = "5" cols = "30" />
		    <form:errors path="comment" cssClass="invalid-feedback"/>
		  </div>
		  
		  <button type="submit" class="btn btn-primary">Add</button>
		</form:form>
</div>
</div>
</body>
</html>