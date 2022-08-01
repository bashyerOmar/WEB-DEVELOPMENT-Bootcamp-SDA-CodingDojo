<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
         
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Show Expense</title>
</head>
<body>

<div class="container">

<div class="d-flex">
<h1> Expense Details </h1> &nbsp; <span class="p-4"><a href="/expenses">Go Back </a></span>
</div>

<p> Expense Name: <c:out value="${poke.getExpense()}"/> </p>
<p> Expense Description : <c:out value="${poke.getDesc()}"/> </p>
<p>Vendor :  <c:out value="${poke.getVendor()}"/> </p>
<p>Amount Spent : <c:out value="${poke.getAmount()}"/>$ </p>


</div>
</body>
</html>