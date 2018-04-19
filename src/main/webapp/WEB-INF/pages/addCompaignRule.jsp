

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="th"%>
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<h1 align="center">Welcome to Registration Page</h1>
<form th:action="/addCompaign" commandName="compaignRuleForm"
	method="post">


	<table align="center">
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
			<th>Title :</th>
			<td><input type="text" name="title" /></td>
			<!-- <td><h:errors property="firstName" /></td> -->
		</tr>
		<tr>
			<th>Schedule Days :</th><td>
			<table>
				<input type="checkbox" name="days" value="monday" />Mon
				<input type="checkbox" name="days" value="tuesday" />Tue
				<input type="checkbox" name="days" value="wednesday" />Wed
				<input type="checkbox" name="days" value="thursday" />Thu
				<input type="checkbox" name="days" value="friday" />Fri
				<br>
				<input type="checkbox" name="days" value="saturday" />Sat
				<input type="checkbox" name="days" value="sunday" />Sun
			</table>
			<td>
		</tr>
		<tr>
			<th>Start Time :</th>
			<td><input type="text" name="startTime" /></td>
			<!-- <td><h:errors property="firstName" /></td> -->
		</tr>
		<tr>
			<th>End Time :</th>
			<td><input type="text" name="endTime" /></td>
			<!-- <td><h:errors property="firstName" /></td> -->
		</tr>
		<tr>
			<th>Show Content :</th>
			<td>  <input type="radio" name="showContent" value="any" > Any<br>
  				<input type="radio" name="showContent" value="OfferList"> In Offer List<br>
  				<input type="radio" name="showContent" value="pushNotification">In Push Notification 
		</td>
		</tr>
		<tr>
			<th>Frequency :</th>
			<td><select name="frequency">
				  <option value=""></option>
				  <option value="always">Always</option>
				  <option value="once">Only Once</option>
				  <option value="onceEvery">Once very 15 min</option>
			</select></td>
			<
		<tr>
			<th align="center"><input type="submit" value="Add" /></th>
		</tr>
	</table>
</form>