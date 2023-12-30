<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous"></head>
<style>
	body{
		background-color:#FCF6F5FF ;

	}

	form{
	background-color: #990011FF;
	color: white;
	font-weight:700;
	margin:20px;
	padding:10px;
	
	}

</style>
<title>Add Player</title>
</head>
<body>
	<f:form action="save" modelAttribute="player" method="Post">
	  <div class="form-row">
	      
	      <f:hidden path="id"/>
	 
	    <div class="form-group col-md-6">
	      <label>Name</label>
	      <f:input path="name" type="text"  class="form-control" placeholder="Name" required="required"/>
	    </div>
	    <div class="form-group col-md-6">
	      <label>Number</label>
	      <f:input path="number" type="text" class="form-control" placeholder="Number"/>
	    </div>
	    <div class="form-group col-md-12">
		    <label for="inputAddress">Address</label>
		    <f:input path="address" type="text" class="form-control"  placeholder="Address"/>
		  </div>
		<div class="form-group  col-md-12">
		    <label for="inputAddress2">Phone</label>
		    <f:input path="phone" type="text" class="form-control" id="inputAddress2" placeholder="Phone Number"/>
		  </div>
	  </div>
	  <button type="submit" class="btn btn-primary">Add Player</button>
  </f:form>
</body>
</html>