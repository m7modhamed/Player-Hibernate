<%@page import="org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FiFa Players</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous"></head>
</head>
<body>
	<table class="table table-dark">
	  <thead >
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Name</th>
	      <th scope="col">Number</th>
	      <th scope="col">Address</th>
	      <th scope="col">Phone</th>
	      <th scope="col">Services</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach var="p" items="${players}">
	  
		    <tr>
		      <td>${p.id}</td>
		      <td>${p.name}</td>
		      <td>${p.number}</td>
		      <td>${p.address}</td>
		      <td>${p.phone}</td>
		      <td>
		      <c:url var="edit" value="/fifa/showplayer" >
		      	<c:param name="playerId" value="${p.id}"/>
		      </c:url>
		      <a href=${edit}  type="button" class="btn btn-primary">edit</a>
		     	
		     	<c:url var="delete" value="/fifa/delete" >
		      	<c:param name="playerId" value="${p.id}"/>
		      </c:url>
		      <a href=${delete}  type="button" class="btn btn-danger">delete</a>
		      </td>
		    </tr>
	    </c:forEach>
	  </tbody>
</table>
		  <a type="button" href="add" class="btn btn-danger">Add New Player</button>

</body>
</html>
