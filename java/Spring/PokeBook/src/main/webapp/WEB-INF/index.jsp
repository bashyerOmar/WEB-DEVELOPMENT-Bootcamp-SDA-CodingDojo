<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/Style.css">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<title>Read Share</title>
</head>
<body>
<div class="container w-75 p-4">
<h1>Poke Book</h1>

<table class="table table-striped mb-5">
  <thead>
    <tr>
      <th scope="col">Expense</th>
      <th scope="col">Vendor</th>
      <th scope="col">Amount</th>
      <th scope="col" colspan="2">Actions</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="poke" items="${allPokes}">
    <tr>
      <td><a href="/expenses/${poke.getId()}"><c:out value="${poke.getExpense()}"/></a></td>
      <td><c:out value="${poke.getVendor()}"/></td>
      <td><c:out value="${poke.getAmount()}"/></td>
      <td><a href="/expenses/edit/${poke.getId()}">edit</a>  </td>
      <td><form action="/expenses/${poke.getId()}" method="post">
      <input type="hidden" name="_method" value="delete">
      <input type="submit" class="btn btn-primary" value="Delete">
     </form></td>
    </tr>
    </c:forEach> 
  </tbody>
</table>

           <c:if test="${success != null}">
			<div class="alert alert-success">
				<c:out value="${success}" />
			</div>
			</c:if>
			
			
			<h2>track an expense</h2>

    
		<form:form method="post" modelAttribute="poke" action="/expenses/create">
		
		  <div class="mb-3">
		    <label for="poke" class="form-label">expense</label>
		    <form:input path="expense" type="text" cssClass="form-control" cssErrorClass="form-control is-invalid" id="poke" aria-describedby="bookHelp"/>
		    <form:errors path="expense" cssClass="invalid-feedback"/>
		  </div>
		  <div class="mb-3">
		    <label for="vendor" class="form-label">vendor</label>
		    <form:input path="vendor" type="text" class="form-control" id="vendor"/>
		    <form:errors path="vendor" cssClass="invalid-feedback"/>
		  </div>
		  <div class="mb-3">
		    <label for="amount" class="form-label">amount</label>
		    <form:input path="amount" type="number" class="form-control" id="amount"/>
		    <form:errors path="amount" cssClass="invalid-feedback"/>
		  </div>
		  
		  	<div class="mb-3">
		    <label for="desc" class="form-label">description</label>
		    <form:input path="desc" type="text" class="form-control" id="desc"/>
		    <form:errors path="desc" cssClass="invalid-feedback"/>
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
		
</form:form> 
</div>
</body>
</html>