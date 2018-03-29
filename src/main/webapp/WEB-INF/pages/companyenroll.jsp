<%-- 
<%@taglib prefix="h" uri="http://struts.apache.org/tags-html"%> --%>
<!DOCTYPE HTML>
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



<!--  	<form action="/enroll" method="post" name="companyEnroll">
 		<input type="text" name="emai"/>
 		<input type="submit" value="Submit"/>
 	</form> -->