

<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="th"%>
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<h1 align="center">Welcome to Registration Page</h1>
<form th:action="/addContent" commandName="adContentForm"
	method="post">

	<table align="center">
		<tr>
			<th>Content Type :</th>
			<td><input type="text" name="contentType" /></td>
			<!-- <td><h:errors property="firstName" /></td> -->

		</tr>
		<tr>
			<th>short Notification :</th>
			<td><input type="text" name="shortNotification"/></td>
			<!-- <td><h:errors property="lastName" /></td> -->
		</tr>
		<tr>
			<th>short Notification :</th>
			<td><input type="text" name="longNotification"/></td>
			<!-- <td><h:errors property="phone" /></td> -->
		</tr>
		<tr>
			<th align="center"><input type="submit" value="Add" /></th>
		</tr>
	</table>
</form>

