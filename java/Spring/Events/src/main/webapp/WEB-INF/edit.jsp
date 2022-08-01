<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Events</title>
</head>
<body>
<div class="w-50 mx-auto">
<h2 class="mb-5 mt-5"><c:out value="${event.getName()}"/></h2>
<form:form action="/events/${event.getId()}/update" method="post" modelAttribute="event">
       <input type="hidden" name="_method" value="put">
		  <div class="mb-3">
		    <label for="name" class="form-label">Name</label>
		    <form:input path="name" type="text" cssClass="form-control" cssErrorClass="form-control is-invalid" id="name" value="${event.getName()}" />
		    <form:errors path="name" cssClass="invalid-feedback"/>
		  </div>
		  
		  <div class="mb-3">
		    <label for="date" class="form-label">Date</label>
		    <form:input path="date" type="date" cssClass="form-control" cssErrorClass="form-control is-invalid" id="date"  value="${event.getDate()}"/>
		    <form:errors path="date" cssClass="invalid-feedback"/>
		  </div>
		  
		  <div class="mb-3 d-flex" >
		    <label for="location" class="form-label">Location</label>
		    <form:input path="location" type="text" cssClass="form-control" cssErrorClass="form-control is-invalid" id="location" value="${event.getLocation()}"/>
		    <form:errors path="location" cssClass="invalid-feedback"/>
		    
		     <div class="mb-3">
           <form:select path="state">
            <form:option value="makkah" path="state">makkah</form:option>
            <form:option value="ryiadh" path="state">ryiadh</form:option>
            <form:option value="asir" path="state">asir</form:option>
            <form:option value="tabuk" path="state">tabuk</form:option>
         </form:select>
          </div>
		  </div>
		  
		  
		  
		  <button type="submit" class="btn btn-primary">Edit Event!</button>
		</form:form>
		</div>
</body>
</html>