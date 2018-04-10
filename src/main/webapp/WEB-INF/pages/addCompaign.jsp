

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="th"%>
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<h1 align="center">Welcome to Registration Page</h1>
<form th:action="/addCompaign" commandName="adCompaignForm"
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
			<th align="center"><input type="submit" value="Add" /></th>
		</tr>
	</table>
</form>