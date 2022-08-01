<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Events</title>
</head>
<body>
<div class="w-75 mx-auto">
<div class="d-flex justify-content-between">
<h1>Welcome <c:out value="${user.getFirstName()}" /> </h1> <a href="/logout">logout</a>
</div>
<p>Some events in your state</p>
<table class="table table-striped mb-5">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Date</th>
      <th scope="col">Location</th>
      <th scope="col" >Host</th>
      <th scope="col" colspan="2" >Actions</th>
      <th scope="col"  ></th>
      
    </tr>
  </thead>
  <tbody>
  <c:forEach var="event" items="${eventsInState}">
    <tr>
      <td><a href="/events/${event.getId()}"><c:out value="${event.getName()}"/></a></td>
      <td><c:out value="${event.getDate()}"/></td>
      <td> <c:out value="${event.getLocation()}"/></td>
      <td> <c:out value="${event.getHost().getFirstName()}"/></td>
     
     <c:choose>
   <c:when test="${event.getHost().getId() == user.getId()}">
    <td colspan="2"><a href="/events/${event.getId()}/edit">edit</a> </td>
      <td><form action="/events/${event.getId()}" method="post">
      <input type="hidden" name="_method" value="delete">
      <input type="submit" class="btn btn-link" value="Delete">
     </form>
     </td>
   </c:when> 
   <c:when test="${event.getUsers().contains(user)}"><td> <a href="/unjoin/${event.getId() }"> un-join </a></td></c:when> 
   <c:otherwise>   <td> <a href="/join/${event.getId() }"> join </a></td></c:otherwise>    
</c:choose>
     
     
    </tr>
    </c:forEach> 
  </tbody>
</table>



<p>Some events from another states</p>
<table class="table table-striped mb-5">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Date</th>
      <th scope="col">Location</th>
      <th scope="col" >Host</th>
      <th scope="col" >Action</th>
      
      
    </tr>
  </thead>
  <tbody>
  <c:forEach var="event" items="${anotherEvents}">
    <tr>
      <td><a href="/events/${event.getId()}"><c:out value="${event.getName()}"/></a></td>
      <td><c:out value="${event.getDate()}"/></td>
      <td> <c:out value="${event.getLocation()}"/></td>
      <td> <c:out value="${event.getHost().getFirstName()}"/></td>
  <c:choose>
   <c:when test="${event.getHost().getId() == user.getId()}">
    <td colspan="2"><a href="/events/${event.getId()}/edit">edit</a> </td>
      <td><form action="/events/${event.getId()}" method="post">
      <input type="hidden" name="_method" value="delete">
      <input type="submit" class="btn btn-link" value="Delete">
     </form>
     </td>
   </c:when> 
   <c:when test="${event.getUsers().contains(user)}"><td> <a href="/unjoin/${event.getId() }"> un-join </a></td></c:when> 
   <c:otherwise>   <td> <a href="/join/${event.getId() }"> join </a></td></c:otherwise>    
</c:choose>
     
    </tr>
    </c:forEach> 
  </tbody>
</table>


<div class="w-50">
<h3>Create an Event</h3>
<form:form action="/events/create" method="post" modelAttribute="event">

		  <div class="mb-3">
		    <label for="name" class="form-label">Name</label>
		    <form:input path="name" type="text" cssClass="form-control" cssErrorClass="form-control is-invalid" id="name" />
		    <form:errors path="name" cssClass="invalid-feedback"/>
		  </div>
		  
		  <div class="mb-3">
		    <label for="date" class="form-label">Date</label>
		    <form:input path="date" type="date" cssClass="form-control" cssErrorClass="form-control is-invalid" id="date" />
		    <form:errors path="date" cssClass="invalid-feedback"/>
		  </div>
		  
		  <div class="mb-3 d-flex" >
		    <label for="location" class="form-label">Location</label>
		    <form:input path="location" type="text" cssClass="form-control" cssErrorClass="form-control is-invalid" id="location" placeholder="city" />
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
		  
		  
		  
		  <button type="submit" class="btn btn-primary">Add Event!</button>
		</form:form>
</div>
</div>
</body>
</html>