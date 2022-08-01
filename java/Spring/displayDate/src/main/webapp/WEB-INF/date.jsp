<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/dateStyle.css">
<script type="text/javascript" src="/js/date.js"></script>
<title>Date</title>
</head>
<body>
<div class="container"><h1><c:out value="${dayName}" /> the <c:out value="${dayNumber}" /> of <c:out value="${monthyear}" /> </h1></div>
</body>
</html>