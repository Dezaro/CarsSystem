<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="includes/header.jsp"%>
<%@ include file="includes/sidebar.jsp"%>

<div id="content" style="width: 30%; float: left; margin-left: 175px;">
	<h3 style="margin-bottom: 20px;">Добавяне потребител</h3>
	<form method="post" style="margin-bottom: 15px;" action="<%=IConstants.USERS_INSERT%>">
		<%
			String message = (String) session.getAttribute("message");
			if (message != null) {
		%>
		<div class="alert alert-success" role="alert"><%=message%></div>
		<%
			session.removeAttribute("message");
			}
		%>
		<div class="form-group">
			<label for="Uname">Потребителско име:</label> <input type="text"
				class="form-control" name="Uname" id="Uname"
				placeholder="Потребителско име ">
		</div>
		<div class="form-group">
			<label for="Fname">Име:</label> <input type="text"
				class="form-control" name="Fname" id="Fname" placeholder="Име">
		</div>
		<div class="form-group">
			<label for="Lname">Фамилия:</label> <input type="text"
				class="form-control" name="Lname" id="Lname" placeholder="Фамилия">
		</div>
		<div class="form-group">
			<label for="Email">Поща:</label> <input type="text"
				class="form-control" name="Email" id="Email" placeholder="Поща">
		</div>
		<div class="form-group">
			<label for="Pass">Парола:</label> <input type="password"
				class="form-control" name="Pass" id="Pass" placeholder="Парола">
		</div>
		<div class="form-group">
			<label for="Role">Роля:</label> <select class="form-control"
				name="Role" id="Role">
				<option>admin</option>
				<option>user</option>
			</select>
		</div>
		<button type="submit" name="add" class="btn btn-default">
			<span class="glyphicon glyphicon-plus"></span> Добави
		</button>
	</form>
</div>

<%@ include file="includes/footer.jsp"%>