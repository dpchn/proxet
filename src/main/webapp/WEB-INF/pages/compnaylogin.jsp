<%-- 
<%@taglib prefix="h" uri="http://struts.apache.org/tags-html"%> --%>
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<h1>Welcome to Registration Page</h1>
<form th:action="@{/login}" th:object="${CompanyLoginForm}"
	method="post">

	<table align="centre">
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
			<th><input type="submit" name="Register" value="sdjfk"
				class="form-control btn btn-info" /></th>
		</tr>
	</table>
</form>



<!--  	<form action="/enroll" method="post" name="companyEnroll">
 		<input type="text" name="emai"/>
 		<input type="submit" value="Submit"/>
 	</form> -->