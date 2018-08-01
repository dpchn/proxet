<script type="text/javascript">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="th"%>
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<html>
<h1 align="center">Welcome to Registration Page</h1>
<!-- 
	<link rel="stylesheet" type="text/css" href="css/register.css"> -->
<style >
	
	input[type=text],select{
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
    box-sizing: border-box;
}

input[type=password],select{
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

div {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}
</style>
<body>
	<div>
		<form th:action="/enroll" commandName="CompanyEnrollmentForm" method="post">

			<table align="center">
				<tr>
					<th><label for="fname">First Name : </label></th>
					<td><input type="text" name="firstName"
						placeholder="First Name..." /></td>
					<td><h:errors property="fname" /></td>

				</tr>
				<tr>
					<th><label for="lname">Last Name : </label></th>
					<td><input type="text" name="lastName"
						placeholder="Last Name..." /></td>
					<td><h:errors property="lastName" /></td>
				</tr>
				<tr>
					<th><label for="phone">Phone No. : </label></th>
					<td><input type="text" name="phone" /placeholder="Phone No..."></td>
					<td><h:errors property="phone" /></td>
				</tr>
				<tr>
					<th><label for="email">Email : </label></th>
					<td><input type="text" name="email" placeholder="Email..." /></td>
					<td><h:errors property="email" /></td>
				</tr>
				<tr>
					<th><label for="password">Password : </label></th>
					<td><input type="password" name="password"
						placeholder="Password..." /></td>
					<td><h:errors property="password" /></td>
				</tr>
				<tr>
					<th><label for="Cpassword">Confirm Password : </label></th>
					<td><input type="password" name="confirmpassword"
						placeholder="Confirm Password..." /></td>
					<td><h:errors property="password" /></td>
				</tr>
				<tr>
					<th><label for="Cname">Company Name : </label></th>
					<td><input type="text" name="company"
						placeholder="Company Name..." /></td>
					<td><h:errors property="company" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"> 
					<input type="submit" name="Register" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>



<div>
	<form class="form-horizontal" id="b1">
            <div class="form-group form-group-lg">
                <label class="col-sm-2 control-label">Username</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="username"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" id="bth-search"
                            class="btn btn-primary btn-lg">Search
                    </button>
                </div>
            </div>
        </form>
</div>
<div>
<button onclick="ajaxGet()" id="b1">Click me</button>
</div>


<p id="demo">Click me.</p>

<script>
document.getElementById("demo").onclick = function() {myFunction()};

function myFunction() {
    document.getElementById("demo").innerHTML = "YOU CLICKED ME!";
    ajaxGet()
}
</script>

<script type="text/javascript">
function ajaxGet() {
	console.log("Hello");
	$.ajax({
		type : "GET",
		url : "/api/hello",
		success : function(result) {
			console.log("Fail: ", result);
			/* if (result.status == "Done") {
				$('#getResultDiv ul').empty();
				var custList = "";
				$.each(result.data, function(i, customer) {
					var customer = "- Customer with Id = " + i
							+ ", firstname = "
							+ customer.firstname
							+ ", lastName = "
							+ customer.lastname + "<br>";
					$('#getResultDiv .list-group').append(
							customer)
				});
				console.log("Success: ", result);
			} else {
				$("#getResultDiv").html(
						"<strong>Error</strong>");
				console.log("Fail: ", result);
			} */
		},
		error : function(e) {
			$("#getResultDiv").html("<strong>Error</strong>");
			console.log("ERROR: ", e);
		}
	});
}
</script>
	/* $(document).ready(
			function myFunction() {
				// GET REQUEST
				$("#b1").click(function(event) {
					event.preventDefault();
					ajaxGet();
				});

				// DO GET
			
			}) */



