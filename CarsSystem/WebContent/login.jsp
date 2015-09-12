<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="includes/header.jsp"%>
<%@ include file="includes/sidebar.jsp"%>

<div id="content" style="width: 25%; float: left; margin-left: 200px;">
	<%
		String error = (String) session.getAttribute(IConstants.LAST_ERROR);
		if (error != null) {
	%>
	<div class="alert alert-danger" role="alert"><%=error%></div>
	<%
		session.removeAttribute(IConstants.LAST_ERROR);
		}
	%>
	<form method="post" action="<%=IConstants.LOGIN_URL%>"
		style="margin-bottom: 15px;">
		<div class="form-group">
			<label for="Name">Потребителско име:</label> <input type="text"
				class="form-control" name="<%=IConstants.USER_PARAM%>" id="Name"
				placeholder="Потребителско име">
		</div>
		<div class="form-group">
			<label for="Name">Парола:</label> <input type="password"
				class="form-control" name="<%=IConstants.PASSWORD_PARAM%>" id="Pass"
				placeholder="Парола">
		</div>
		<button type="submit" name="login" class="btn btn-default">
			<span class="glyphicon glyphicon-log-in"></span> Вход
		</button>
	</form>
</div>
<%@ include file="includes/footer.jsp"%>
