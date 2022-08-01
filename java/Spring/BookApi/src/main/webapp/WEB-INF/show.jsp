<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reading Book</title>
</head>
<body>

<div>

<h1><c:out value="${book.getTitle() }" /></h1>
<h2>Description: <c:out value="${book.getDescription() }" /> </h2>
<h2>Language: <c:out value="${book.getLanguage() }" /> </h2>
<h2>Number of Pages: <c:out value="${book.getNumberOfPages() }" /> </h2>
 
</div>
</body>
</html>