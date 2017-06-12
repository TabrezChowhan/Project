<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
<div class="container">

	<!------------------------------- Create Category code -------------------------------->

	<h2 align="center">Add Supplier</h2>
	<div id="CreateSupplier">
		<!-- <div class="container"> -->

			<form class="form-inline" action="manage_supplier_add">

				<div class="form-group">
					<label for="id">Id:</label> <input type="text" class="form-control"
						id="id" placeholder="Enter Supplier Id" name="id">
				</div>

				<div class="form-group">
					<label for="name">Name:</label> <input type="text"
						class="form-control" id="name" placeholder="Enter Name"
						name="name">
				</div>

				<div class="form-group">
					<label for="description">Address:</label> <input type="text"
						class="form-control" id="description"
						placeholder="Enter Address" name="address">
				</div>

				<button type="submit" class="btn btn-success">Create
					Supplier</button>
			</form>

	</div>

<br>
 <!-- -------------------------------Update Category ------------------------------------- -->
<h2 align="center">Update Supplier</h2>
<div id="UpdateSupplier">
		<!-- <div class="container"> -->

			<form class="form-inline" action="manage_supplier_update" method="post">

				<div class="form-group">
					<label for="id">Id:</label> <input type="text" class="form-control"
						id="id" placeholder="Enter Supplier Id" name="id" value="${selectedSupplier.id}">
				</div>

				<div class="form-group">
					<label for="name">Name:</label> <input type="text"
						class="form-control" id="name"  placeholder="Enter Name"
						 name="name" value="${selectedSupplier.name}">
				</div>

				<div class="form-group">
					<label for="description">Address:</label> <input type="text"
						class="form-control" id="address"
						placeholder="Enter Address" name="address" value="${selectedSupplier.address}">
				</div>

				<button type="submit" class="btn btn-success">Update
					Supplier</button>
			</form>
		
	</div>

<br>
	<!------------------------- Show Category List --------------------------------------->

	<h2 align="center">Delete / Update the Suppliers</h2>
	<div id="ShowSuppliers">
		<!-- <div class="container"> -->
				<table class="table table-striped custab">
					<thead>
						<tr>
							<th>Supplier ID</th>
							<th>Supplier Name</th>
							<th>Supplier Address</th>
							<th class="text-center">Action</th>
						</tr>
					</thead>

					<c:forEach var="supplier" items="${supplierList}">

						<tr>
							<td>${supplier.id}</td>
							<td>${supplier.name}</td>
							<td>${supplier.address}</td>
							<td class="text-center"><a class='btn btn-info btn-xs'
								href="<c:url value='manage_supplier_edit/${supplier.id}'/>"> <span
									class="glyphicon glyphicon-edit"></span> Edit
							</a> &nbsp; <a href="<c:url value='manage_supplier_delete/${supplier.id}'/>"
								class="btn btn-danger btn-xs"> <span
									class="glyphicon glyphicon-remove"></span> Delete
							</a></td>
						</tr>

					</c:forEach>

				</table>

			

		</div>

	
</div>

</body>
</html>