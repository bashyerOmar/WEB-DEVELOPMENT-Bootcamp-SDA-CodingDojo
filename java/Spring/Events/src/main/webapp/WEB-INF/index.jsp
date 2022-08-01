<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Welcome</title>
</head>
<body>
    <c:if test="${authntication != null}">
			<div class="alert alert-danger">
				<c:out value="${authntication}" />
			</div>
		</c:if>
		
		<c:if test="${success != null}">
			<div class="alert alert-success">
				<c:out value="${success}" />
			</div>
		</c:if>
		
		
	<div class="m-auto w-75">
    <h1>Welcome</h1>
	
	<div class="m-auto d-flex">
	<div class="p-4 mr-4">
	<h3>Registration</h3>
    <form:form action="/register" method="post" modelAttribute="newUser">
        <div class="form-group">
            <label>First Name:</label>
            <form:input path="firstName" class="form-control" type="text" />
            <form:errors path="firstName" class="text-danger" />
        </div>
        
        <div class="form-group">
            <label>Last Name:</label>
            <form:input path="lastName" class="form-control"  type="text"/>
            <form:errors path="lastName" class="text-danger" />
        </div>
        <div class="form-group">
            <label>Email:</label>
            <form:input path="email" class="form-control"  type="email"/>
            <form:errors path="email" class="text-danger" />
        </div>
        
        <div class="form-group d-flex">
            <label>Location:</label>
            <form:input path="location" class="form-control"  type="text"/>
            <form:errors path="location" class="text-danger" />
            
            <div class="mb-3">
           <form:select path="state">
            <form:option value="makkah" path="state">makkah</form:option>
            <form:option value="ryiadh" path="state">ryiadh</form:option>
            <form:option value="asir" path="state">asir</form:option>
            <form:option value="tabuk" path="state">tabuk</form:option>
         </form:select>
    </div>
        </div>
        
        <div class="form-group">
            <label>Password:</label>
            <form:password path="password" class="form-control" />
            <form:errors path="password" class="text-danger" />
        </div>
        <div class="form-group">
            <label>Confirm Password:</label>
            <form:password path="confirmPW" class="form-control" />
            <form:errors path="confirmPW" class="text-danger" />
        </div>
        <input type="submit" value="Register" class="btn btn-primary m-3" />
    </form:form>
    </div>
    
    <div class="p-4 ml-4">
    <h3>Login</h3>
    <form:form action="/login" method="post" modelAttribute="newLogin">
        <div class="form-group">
            <label>Email:</label>
            <form:input path="email" class="form-control" />
            <form:errors path="email" class="text-danger" />
        </div>
        <div class="form-group">
            <label>Password:</label>
            <form:password path="password" class="form-control" />
            <form:errors path="password" class="text-danger" />
        </div>
        <input type="submit" value="Login" class="btn btn-primary m-3" />
    </form:form>
    </div>
 </div>
 </div>
</body>
</html>

