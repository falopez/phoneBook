<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="co.com.livevox.controller.ContactController"%>
<%@ page import="co.com.livevox.dto.ContactDTO"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>PhoneBook</title>
<link rel="stylesheet"
	href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/styles.css">
</head>
<body>

	<div class="container">
		<div class="pure-g">
			<div class="pure-u-1">
				<div class="header">
					<img class="logo" src="img/phonebook.png" />
					<p>v 1.0</p>
				</div>
			</div>
		</div>
		<div class="pure-g">
			<div class="pure-u-sm-1 pure-u-1-3">
				<div class="box">
					<h2>
						<i class="fa fa-user-plus"></i>New contact
					</h2>
					<form class="pure-form" method="POST" action='ContactController' name="frmAddContact">
						<fieldset class="pure-group">
							<input type="text" class="pure-input-1-2" name="firstName"
								placeholder="First Name" value="<c:out value="${contactDTO.firstName}" />" > 
								
								<input type="text" name="lastName"
								class="pure-input-1-2" placeholder="Last Name" value="<c:out value="${contactDTO.lastName}" />"> 
								
								<input type="text" class="pure-input-1-2" placeholder="Phone" name="phone"
								value="<c:out value="${contactDTO.phone}" />">
						</fieldset>
						<button type="submit"
							class="pure-button pure-input-1-2 pure-button-primary">
							<i class="fa fa-user-plus"></i>Add
						</button>
					</form>
				</div>
			</div>
			<div class="pure-u-sm-1 pure-u-1-3">
				<div class="box">
					<h2>
						<i class="fa fa-search"></i>Search contact
					</h2>
					<form class="pure-form" method="GET" action='ContactController' name="frmSearchContact">
						<fieldset class="pure-group">
							<input type="text" class="pure-input-1-2" name="search"
							value="<c:out value="${contactDTO.search}" />">
						</fieldset>
						<button type="submit"
							class="pure-button pure-input-1-2 pure-button-primary">
							<i class="fa fa-search"></i>Search
						</button>
					</form>
				</div>
			</div>
			<div class="pure-u-sm-1 pure-u-1-3">
				<div class="box">
					<h2>
						<i class="fa fa-users"></i> Contacts
					</h2>
					<table class="pure-table">
						<thead>
							<tr>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Phone</th>
							</tr>
						</thead>
						
						<tbody>
							<%
							ContactController contactController = new ContactController();
							if(ContactController.isNotSearch){
								
								List<ContactDTO> contactList = contactController.listContacts();
								for (ContactDTO contactDTO : contactList) {
							%>
							<tr>                    			
                    			<td><%=contactDTO.getFirstName()%></td>
                    			<td><%=contactDTO.getLastName()%></td>
                    			<td><%=contactDTO.getPhone()%></td>
							</tr>
							<%
									}
								}else{
							%>
							<c:forEach items="${contacts}" var="contacts">
								<tr>
									<td><c:out value="${contacts.firstName}" /></td>
									<td><c:out value="${contacts.lastName}" /></td>
									<td><c:out value="${contacts.phone}" /></td>									
								</tr>
							</c:forEach>
							<%
								}
								ContactController.isNotSearch = true;
							%>
							
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>