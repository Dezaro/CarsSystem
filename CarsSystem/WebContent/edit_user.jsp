<%@page import="carsSystem.model.IConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="includes/header.jsp"%>
<%@ include file="includes/sidebar.jsp"%>
<div id="content" style="float: right; width: 60%;">
	<h3 style="margin-bottom: 20px;">Редактиране на потребител</h3>
	<form method="post" style="margin-bottom: 15px;"
		action="<%=IConstants.USERS_UPDATE%>">
		<input type="hidden" name="Id" value="${user.id }" />
		<input type="hidden" name="url" value="${url }" />
		<div class="form-group">
			<label for="Uname">Потребителско име:</label> <input type="text"
				class="form-control" name="Uname" id="Uname"
				value="${user.userName }">
		</div>
		<div class="form-group">
			<label for="Fname">Име:</label> <input type="text"
				class="form-control" name="Fname" id="Fname"
				value="${user.firstName }">
		</div>
		<div class="form-group">
			<label for="Lname">Фамилия:</label> <input type="text"
				class="form-control" name="Lname" id="Lname"
				value="${user.lastName }">
		</div>
		<div class="form-group">
			<label for="Email">Поща:</label> <input type="text"
				class="form-control" name="Email" id="Email" value="${user.email }">
		</div>
		<div class="form-group">
			<label for="Pass">Парола:</label> <input type="text"
				class="form-control" name="Pass" id="Pass" value="${user.password }">
		</div>
		<div class="form-group">
			<label for="Role">Роля:</label> <select class="form-control"
				name="Role" id="Role">
				<c:if test="${user.role == 'admin'}">
					<option>admin</option>
					<option>user</option>
				</c:if>
				<c:if test="${user.role == 'user'}">
					<option>user</option>
					<option>admin</option>
				</c:if>
			</select>
		</div>
		<button type="submit" name="edit" class="btn btn-default">
			<span class="glyphicon glyphicon-pencil"></span> Редактирай
		</button>
		<button type="button" name="cancel" onclick="history.back()"
			class="btn btn-default">
			<span class="glyphicon glyphicon-remove-circle"></span> Откажи
		</button>
	</form>
</div>
<%@ include file="includes/footer.jsp"%>