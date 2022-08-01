<%@ page isErrorPage="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/edit.css">
<title><c:out value="${lang.getName()}"/></title>
</head>
<body>

<div class="links"> 
<form action="/languages/${lang1.getId()}" method="post">
      <input type="hidden" name="_method" value="delete">
      <input type="submit" class="btn btn-link" value="Delete">
     </form>

<a href="/languages">Dashboard</a> </div>

<div class="container">
     <form:form action="/languages/${lang.getId()}" method="post" modelAttribute="lang">
        <input type="hidden" name="_method" value="put">
		  <div class="mb-3">
		    <label for="name" class="form-label">Name</label>
		    <form:input path="name" type="text" cssClass="form-control" cssErrorClass="form-control is-invalid" id="name" value="${lang.getName()}" />
		    <form:errors path="name" cssClass="invalid-feedback"/>
		  </div>
		  <div class="mb-3">
		    <label for="creator" class="form-label">Creator</label>
		    <form:input path="creator" type="text" class="form-control" id="creator" cssErrorClass="form-control is-invalid" value="${lang.getCreator()}" />
		    <form:errors path="creator" ssClass="invalid-feedback"/>
		  </div>
		  <div class="mb-3">
		    <label for="version" class="form-label">Version</label>
		    <form:input path="version" type="number" class="form-control" id="version" cssErrorClass="form-control is-invalid" step="any" value="${lang.getVersion()}" />
		    <form:errors path="version" ssClass="invalid-feedback"/>
		  </div>
		  
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
		</div>
</body>
</html>