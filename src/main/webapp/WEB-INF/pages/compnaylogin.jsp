<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<h1 align="center">Welcome to Login Page</h1>
<form th:action="@{/login}" th:object="${CompanyLoginForm}"
	method="post">

	<table align="center">
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
			<th><input type="submit" name="Login" value="Login"
				class="form-control btn btn-info" /></th>
		</tr>
	</table>
</form>




<%-- 
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="th"%>
<!DOCTYPE HTML>
<h1 align="center">Welcome to Login Page</h1>
<form th:action="/login" commandName="CompanyLoginForm" method="post">

	<table align="center">
		<tr>
			<th>Email id :</th>
			<td><th:input type="text" path="email" name="email"/></td>
			<!-- <td><h:errors property="email" /></td> -->
		</tr>
		<tr>
			<th>Password :</th>
			<td><th:input type="password" path="password" name="password"/></td>
			<!-- <td><h:errors property="password" /></td> -->
		</tr>
		
		<tr>
			<th><input type="submit" value="Login"/></th>
		</tr>
	</table>
</form> --%>




