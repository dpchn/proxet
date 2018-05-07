<%-- 
<%@taglib prefix="h" uri="http://struts.apache.org/tags-html"%> --%>
<%-- <!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<h1>Welcome to Registration Page</h1>
<form th:action="@{/enroll}" th:object="${CompanyEnrollmentForm}"
	method="post">

	<table align="center">
		<tr>
			<th>First Name :</th>
			<td><input type="text" id="firstName" name="firstName"
				th:value="*{firstName}" /></td>
			<!-- <td><h:errors property="firstName" /></td> -->

		</tr>
		<tr>
			<th>Last Name :</th>
			<td><input type="text" id="lastName" name="lastName"
				th:value="*{lastName}" /></td>
			<!-- <td><h:errors property="lastName" /></td> -->
		</tr>
		<tr>
			<th>Phone No. :</th>
			<td><input type="text" id="phone" name="phone"
				th:value="*{phone}" /></td>
			<!-- <td><h:errors property="phone" /></td> -->
		</tr>
		<tr>
			<th>Email id :</th>
			<td><input type="text" id="email" name="email"
				th:value="*{email}" /></td>
			<!-- <td><h:errors property="email" /></td> -->
		</tr>
		<tr>
			<th>Password :</th>
			<td><input type="password" id="password" name="password"
				th:value="*{password}" /></td>
			<!-- <td><h:errors property="password" /></td> -->
		</tr>
		<tr>
			<th>Confirm Password :</th>
			<td><input type="password" id="confirmpassword" name="confirmpassword"
				th:value="*{confirmpassword}" /></td>
			<!-- <td><h:errors property="password" /></td> -->
		</tr>
		<tr>
			<th>Company Name :</th>
			<td><input type="text" id="company" name="company"
				th:value="*{company}" /></td>
			<!-- <td><h:errors property="company" /></td> -->
		</tr>
		<tr>
			<th><input type="submit" name="Register" value="sdjfk"
				class="form-control btn btn-info" /></th>
		</tr>
	</table>
</form>
 --%>




<%@ taglib uri="http://www.springframework.org/tags/form" prefix="th"%>
<!DOCTYPE HTML>
<html>
<h1 align="center">Welcome to Registration Page</h1>

 <link rel="stylesheet" type="text/css" href="css/register.css" />



<body>
	<div>
		<form th:action="/enroll" commandName="CompanyEnrollmentForm"
			method="post">

			<table align="center">
				<tr>
					<td><label for="fname">First Name : </label></td>
					<td><input type="text" name="firstName"
						placeholder="First Name..." /></td>
					<!-- <td><h:errors property="firstName" /></td> -->

				</tr>
				<tr>
					<td><label for="lname">Last Name : </label></td>
					<td><input type="text" name="lastName"
						placeholder="Last Name..." /></td>
					<!-- <td><h:errors property="lastName" /></td> -->
				</tr>
				<tr>
					<td><label for="phone">Phone No. : </label></td>
					<td><input type="text" name="phone" /placeholder="Phone No..."></td>
					<!-- <td><h:errors property="phone" /></td> -->
				</tr>
				<tr>
					<td><label for="email">Email : </label></td>
					<td><input type="text" name="email" placeholder="Email..." /></td>
					<!-- <td><h:errors property="email" /></td> -->
				</tr>
				<tr>
					<td><label for="password">Password : </label></td>
					<td><input type="password" name="password"
						placeholder="Password..." /></td>
					<!-- <td><h:errors property="password" /></td> -->
				</tr>
				<tr>
					<td><label for="Cpassword">Confirm Password : </label></td>
					<td><input type="password" name="confirmpassword"
						placeholder="Confirm Password..." /></td>
					<!-- <td><h:errors property="password" /></td> -->
				</tr>
				<tr>
					<td><label for="Cname">Company Name : </label></td>
					<td><input type="text" name="company"
						placeholder="Company Name..." /></td>
					<!-- <td><h:errors property="company" /></td> -->
				</tr>
				<tr>
					<th align="center"><input type="submit" name="Register"
						value="Register" /></th>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
