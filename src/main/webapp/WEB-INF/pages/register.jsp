<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>

<h1>Wecome to Registration Page</h1>
<html:form action="/enroll" method="POST" name="companyForm">
	<table>
		<tr>
			<th>First Name :</th>
			<td><html:text property="firstName" /></td>
			<td><html:errors property="firstName" /></td>

		</tr>
		<tr>
			<th>Last Name :</th>
			<td><html:text property="lastName" /></td>
			<td><html:errors property="lastName" /></td>
		</tr>
		<%-- <tr>
			<th>Phone No. :</th>
			<td><html:text property="phoneNo" /></td>
			<td><html:errors property="phone" /></td>
		</tr> --%>
		<tr>
			<th>Email id :</th>
			<td><html:text property="email" /></td>
			<td><html:errors property="email" /></td>
		</tr>
		<tr>
			<th>Password :</th>
			<td><html:password property="password" /></td>
			<td><html:errors property="password" /></td>
		</tr>
		<tr>
			<th>Company Name :</th>
			<td><html:text property="company" /></td>
			<td><html:errors property="company" /></td>
		</tr>
		<tr>
			<th><html:submit>Register</html:submit></th>
		</tr>
	</table>
</html:form>
