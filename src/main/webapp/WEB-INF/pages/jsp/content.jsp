

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

.th_class, .td_class {
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
	<li><a class="active" href="contents">Contents</a></li>
	<li><a href="compaigns">Compaigns</a></li>
</ul>

<div class="middle_top_div">
	<div class="right_conrer_button">
		<button type="button" class="btn btn-info" data-toggle="modal"
			data-target="#myModal">Add Content</button>
	</div>
	<div>
		<h1>Content</h1>
	</div>
	<div class="middle_div">
		<div>
			<table class="table">
				<tr>
					<th class="th_class">S.No</th>
					<th>Name</th>
					<th>Notification</th>
					<th>Compaigns</th>
					<th>Type</th>
					<th>Preview</th>
					<th>Created On</th>
					<th>Edit</th>
					<c:forEach items="${contentData }" var="data">
						<tr>
							<td class="td_class">${data.sn }</td>
							<td>${data.name }</td>
							<td>${data.notification }</td>
							<td>Compaigns</td>
							<td>${data.conentType}</td>
							<td><img src="${data.file}" width="100" height="100" /></td>
							<td>${data.createdOn }</td>
							<td>Edit</td>
						</tr>
					</c:forEach>
				</tr>
			</table>
		</div>
		<%-- <div>
			<table class="table table-hover">
				<c:forEach items="${contentData }" var="data">
					<tr>
						<td>1</td>
						<td>${data.name }</td>
						<td>${data.notification }</td>
						<td>Compaigns</td>
						<td>${data.type }</td>
						<td>${data.conentType }</td>
						<td>${data.createdOn }</td>
						<td>Edit</td>
					</tr>
				</c:forEach>
				<c:out value='${contentData }' />
			</table>
		</div> --%>
	</div>

	<!-- The Modal -->
	<div class="modal fade" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Add</h4>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<form action="addContent" method="post" commandName="contentForm" enctype="multipart/form-data">
						<table align="center">
							<tr>
								<th>Name :</th>
								<td><input type="text" name="name"></td>
							</tr>
							<tr>
								<th>Content Type :</th>
								<td><select name="contentType">
										<option value=" "></option>
										<option value="Image">Image</option>
										<option value="Video">Video</option>
										<option value="Url">Url</option>
								</select></td>
								<!-- <td><h:errors property="firstName" /></td> -->
							</tr>
							<tr>
								<th>File :</th>
								<td><input type="file" name="file" accept="*"></td>
								<!-- <td><h:errors property="firstName" /></td> -->
							</tr>
							<tr>
								<th>short Notification :</th>
								<td><input type="text" name="shortNotification" /></td>
								<!-- <td><h:errors property="lastName" /></td> -->
							</tr>
							<tr>
								<th>short Notification :</th>
								<td><input type="text" name="longNotification" /></td>
								<!-- <td><h:errors property="phone" /></td> -->
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

				<!-- Modal footer -->
				<!-- <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div> -->

			</div>
		</div>
	</div>


</div>

</html>

