
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
	margin: 0;
}

input[type=text], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit]:hover {
	background-color: #45a049;
}

div.form {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
	width: 30%;
	margin-left: 450px;
	margin-top: 150px;
}

ul {
	list-style-type: none;
	position: fixed;
	margin: 0;
	padding: 0;
	width: 25%;
	background-color: #f1f1f1;
	position: fixed;
	height: 100%;
	overflow: auto;
}

li a {
	display: block;
	color: #000;
	padding: 8px 16px;
	text-decoration: none;
}

li a.active {
	background-color: #4CAF50;
	color: white;
}

li a:hover {
	background-color: #555;
	color: white;
}

div.topdiv {
	list-style-type: none;
	margin: 20x;
	padding: 30px;
	overflow: hidden;
	background-color: black;
}

div.middle_top_div {
	list-style-type: none;
	height: 530px;
	margin-left: 320px;
	padding: 30px;
	overflow: hidden;
	background-color: white;
}

.right_conrer_button {
	position: absolute;
	top: 100px;
	right: 16px;
	font-size: 18px;
}

.middle_div {
	list-style-type: none;
	height: 500px;
	padding: 30px;
	overflow-y: scroll;
	background-color: white;
}

.outset {
	border-style: outset;
}

th, td {
	width: 100px;
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>


<div class="topdiv"></div>
<ul>
	<li><a href="dashboard">Dashboard</a></li>
	<li><a href="analytics">Analytics</a></li>
	<li><a href="devices">Devices</a></li>
	<li><a href="contents">Contents</a></li>
	<li><a class="active" href="compaigns">Compaigns</a></li>
</ul>

<div class="middle_top_div">
	<div class="right_conrer_button">
		<button type="button" class="btn btn-info" data-toggle="modal"
			data-target="#myModal">Add Compaign</button>
	</div>
	<div>
		<h1>Compaigns</h1>
	</div>
	<div class="middle_div">
		<div>
			<table class="table">
				<tr>
					<th>S.No</th>
					<th>Title</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>Status</th>
					<th>Action</th>
					<c:forEach items="${compaignList}" var="data">
						<tr>
							<td>${data.sn }</td>
							<td>${data.title }</td>
							<td>${data.startDate }</td>
							<td>${data.endDate }</td>
							<td>${data.status }</td>
							<td><a href="/company/compaignRule?compaignId=${data.id}">View</a></td>
							<td><a href="/company/compaignRule?compaignId=${data.id}">Delete</a></td>
						</tr>
					</c:forEach>
				</tr>
			</table>
		</div>
	</div>

	<!-- The Modal -->
	<div class="modal fade" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Add Compaign</h4>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<form action="addCompaign" commandName="adCompaignForm"
						method="post">

						<table align="center">
							<tr>
								<th>Title :</th>
								<td><input type="text" name="title" /></td>
								<!-- <td><h:errors property="firstName" /></td> -->
							</tr>
							<tr>
								<th>Start Date :</th>
								<td><input type="text" name="startDate" /></td>
								<!-- <td><h:errors property="firstName" /></td> -->
							</tr>
							<tr>
								<th>Start Time :</th>
								<td><input type="text" name="startTime" /></td>
								<!-- <td><h:errors property="firstName" /></td> -->
							</tr>
							<tr>
								<th>End Date :</th>
								<td><input type="text" name="endDate" /></td>
								<!-- <td><h:errors property="firstName" /></td> -->
							</tr>
							<tr>
								<th>End Time :</th>
								<td><input type="text" name="endTime" /></td>
								<!-- <td><h:errors property="firstName" /></td> -->
							</tr>
							<tr>
								<td align="center" colspan="2"><input type="submit"
									value="Add" class="btn-info" />
									<button type="button" class="btn btn-danger"
										data-dismiss="modal">Close</button></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</html>
