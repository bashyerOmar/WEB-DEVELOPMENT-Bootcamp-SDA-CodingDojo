<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>current visit counter</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<p>you have visited <a href="/">http://localhost:8080/</a> <c:out value="${count}"/> times</p>
<p><a href="/">test another visit?</a></p>

<a class="btn btn-primary" href="/reset">Reset counter</a>
</body>
</html>