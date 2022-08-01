<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
          <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/Style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title><c:out value="${lang.getName()}"/></title>
</head>
<body>
<p id="dashlink"> <a href="/languages">Dashboard </a></p>
<div class="container">
<p> <c:out value="${lang.getName()}"/> </p>
<p> <c:out value="${lang.getCreator()}"/> </p>
<p><c:out value="${lang.getVersion()}"/> </p>



<p><a href="/languages/${lang.getId()}/edit">Edit</a></p>
<form action="/languages/${lang1.getId()}" method="post">
      <input type="hidden" name="_method" value="delete">
      <input type="submit" class="btn btn-link" value="Delete">
     </form>

</div>
</body>
</html>