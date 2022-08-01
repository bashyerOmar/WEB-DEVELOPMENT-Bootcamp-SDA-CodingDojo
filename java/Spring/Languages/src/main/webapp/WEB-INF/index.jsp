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
<title>Languages</title>
</head>
<body>
<div class="container">


<table class="table table-striped ">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Creator</th>
      <th scope="col">version</th>
      <th scope="col" colspan="2">Actions</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="lang1" items="${langs}">
    <tr>
      <td><a href="/languages/${lang1.getId()}"><c:out value="${lang1.getName()}"/></a></td>
      <td><c:out value="${lang1.getCreator()}"/></td>
      <td><c:out value="${lang1.getVersion()}"/></td>
      <td colspan="2"><a href="/languages/${lang1.getId()}/edit">edit</a> </td>
      <td><form action="/languages/${lang1.getId()}" method="post">
      <input type="hidden" name="_method" value="delete">
      <input type="submit" class="btn btn-link" value="Delete">
     </form>
     </td>
    </tr>
    </c:forEach> 
  </tbody>
</table>

       <c:if test="${success != null}">
			<div class="alert alert-success">
				<c:out value="${success}" />
			</div>
		</c:if>
		
		<div class="form">
		<form:form action="/languages" method="post" modelAttribute="lang">
		  <div class="mb-3">
		    <label for="name" class="form-label">Name</label>
		    <form:input path="name" type="text" cssClass="form-control" cssErrorClass="form-control is-invalid" id="name" />
		    <form:errors path="name" cssClass="invalid-feedback"/>
		  </div>
		  <div class="mb-3">
		    <label for="creator" class="form-label">Creator</label>
		    <form:input path="creator" type="text" class="form-control" id="creator" cssErrorClass="form-control is-invalid" />
		    <form:errors path="creator" ssClass="invalid-feedback"/>
		  </div>
		  <div class="mb-3">
		    <label for="version" class="form-label">Version</label>
		    <form:input path="version" type="number" class="form-control" id="version" cssErrorClass="form-control is-invalid" step="any" />
		    <form:errors path="version" ssClass="invalid-feedback"/>
		  </div>
		  
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
</div>

</div>
</body>
</html>