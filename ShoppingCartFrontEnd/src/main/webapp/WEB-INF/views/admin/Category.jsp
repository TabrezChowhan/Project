<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="resources/css/CategoryList.css">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

</head>
<body>

<div class="container">

	<!------------------------------- Create Category code -------------------------------->

	<h2 align="center">Add Categories</h2>
	<div id="CreateCategory">
		<!-- <div class="container"> -->

			<form class="form-inline" action="manage_category_add">

				<div class="form-group">
					<label for="id">Id:</label> <input type="text" class="form-control"
						id="id" placeholder="Enter Category Id" name="id">
				</div>

				<div class="form-group">
					<label for="name">Name:</label> <input type="text"
						class="form-control" id="name" placeholder="Enter Name"
						name="name">
				</div>

				<div class="form-group">
					<label for="description">Description:</label> <input type="text"
						class="form-control" id="description"
						placeholder="Enter Description" name="description">
				</div>

				<button type="submit" class="btn btn-success">Create
					Category</button>
			</form>

	</div>

<br>
<!-- -------------------------------Update Category ------------------------------------- -->
<h2 align="center">Update Categories</h2>
<div id="UpdateCategory">
		<!-- <div class="container"> -->

			<form class="form-inline" action="manage_category_update" method="post">

				<div class="form-group">
					<label for="id">Id:</label> <input type="text" class="form-control"
						id="id" placeholder="Enter Category Id" name="id" value="${selectedCategory.id}">
				</div>

				<div class="form-group">
					<label for="name">Name:</label> <input type="text"
						class="form-control" id="name"  placeholder="Enter Name"
						 name="name" value="${selectedCategory.name}">
				</div>

				<div class="form-group">
					<label for="description">Description:</label> <input type="text"
						class="form-control" id="description"
						placeholder="Enter Description" name="description" value="${selectedCategory.description}">
				</div>

				<button type="submit" class="btn btn-success">Update
					Category</button>
			</form>
		
	</div>

<br>
	<!------------------------- Show Category List --------------------------------------->

	<h2 align="center">Delete / Update the Categories</h2>
	<div id="ShowCategories">
		<!-- <div class="container"> -->
						<table class="table table-striped custab">
					<thead>
						<tr>
							<th>Category ID</th>
							<th>Category Name</th>
							<th>Category Description</th>
							<th class="text-center">Action</th>
						</tr>
					</thead>

					<c:forEach var="category" items="${categoryList}">

						<tr>
							<td>${category.id}</td>
							<td>${category.name}</td>
							<td>${category.description}</td>
							
							<td class="text-center">
							<a class="btn btn-info btn-xs" href="<c:url value = '/manage_category_edit/${category.id}'/>">
							 <span class="glyphicon glyphicon-edit"></span> Edit</a> 
							 &nbsp;
							 <a href="<c:url value ='/manage_category_delete/${category.id}'/>" class="btn btn-danger btn-xs"> 
							 <span class="glyphicon glyphicon-remove"></span> Delete
							</a></td>
						</tr>

					</c:forEach>

				</table>

			

		</div>

	

</div>

</body>
</html>