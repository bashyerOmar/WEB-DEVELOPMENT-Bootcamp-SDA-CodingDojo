<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Edit My Task</title>
</head>
<body>

<div class="container">
<div class="d-flex">
<h1> Edit Expense  </h1> &nbsp; <span class="p-4"><a href="/expenses">Go Back </a></span>
</div>

     <form:form action="/expenses/update/${poke.getId()}" method="post" modelAttribute="pokeModel">
        <input type="hidden" name="_method" value="put">
		  <div class="mb-3">
		    <label for="expense" class="form-label">Expense Name</label>
		    <form:input path="expense" type="text" cssClass="form-control" cssErrorClass="form-control is-invalid" id="expense" value="${poke.getExpense()}" />
		    <form:errors path="expense" cssClass="invalid-feedback"/>
		  </div>
		  <div class="mb-3">
		    <label for="vendor" class="form-label">Vendor</label>
		    <form:input path="vendor" type="text" class="form-control" id="creator" cssErrorClass="form-control is-invalid" value="${poke.getVendor()}" />
		    <form:errors path="vendor" ssClass="invalid-feedback"/>
		  </div>
		  <div class="mb-3">
		    <label for="amount" class="form-label">Amount</label>
		    <form:input path="amount" type="number" class="form-control" id="amount" cssErrorClass="form-control is-invalid" step="any" value="${poke.getAmount()}" />
		    <form:errors path="amount" ssClass="invalid-feedback"/>
		  </div>
		  
		  <div class="mb-3">
		    <label for="desc" class="form-label">description</label>
		    <form:input path="desc" type="text" class="form-control" id="desc" cssErrorClass="form-control is-invalid" step="any" value="${poke.getDesc()}"/>
		    <form:errors path="desc" cssClass="invalid-feedback"/>
		  </div>
		  
		  <button type="submit" class="btn btn-primary">Update!</button>
		</form:form>
		</div>
</body>
</html>