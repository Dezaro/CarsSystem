<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setHeader("Pragma", "No-cache");
	response.setDateHeader("Expires", 0);
	response.setHeader("Cache-Control", "no-cache");
%>
<%@ page import="carsSystem.model.IConstants"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap-3.3.2-dist/css/bootstrap.min.css">
<script src="jquery-ui-1.11.2.custom/jquery.min.js"></script>
<script src="bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="jquery-ui-1.11.2.custom/jquery-ui.css">
<script src="jquery-ui-1.11.2.custom/jquery-ui.min.js"></script>
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
	<div id="wrapper">
		<div id="header-wrapper">
			<div id="header" class="container">
				<div id="logo">
					<h1>
						<a href="<%=IConstants.MAIN_FORM%>">Бързи и яростни 7</a>
					</h1>
				</div>
				<div id="menu">
					<ul>
						<li><a href="<%= IConstants.MAIN_FORM %>">Начало</a></li>
						<%
							if (session.getAttribute(IConstants.CURRENT_USER) == null
									&& session.getAttribute(IConstants.USER_ROLE) == null) {
						%>
						<li><a href="<%=IConstants.LOGIN_FORM%>"><span
								class="glyphicon glyphicon-log-in"></span> Вход</a></li>
						<%
							} else {
						%>
						<li><a href="<%= IConstants.INSERT_MODEL %>">Добави</a></li>
						<li><a href="<%= IConstants.MODELS_URL %>">Редактирай</a></li>
						<li><a href="<%=IConstants.LOGOUT_URL%>"><span
								class="glyphicon glyphicon-log-out"></span> Изход</a></li>
						<%
							if (session.getAttribute(IConstants.USER_ROLE).equals("user")) {
						%>
						<div
							style="margin-left: 250px; color: #326B7E; font-size: medium;">
							Здравейте,
							<%=session.getAttribute(IConstants.CURRENT_USER)%>
							<span class="glyphicon glyphicon-user"></span>
						</div>
						<%
							} else {
						%>
						<div
							style="margin-left: 120px; color: #326B7E; font-size: medium;">
							Здравейте,
							<%=session.getAttribute(IConstants.CURRENT_USER)%>
							<a
								style="float: none; display: inline; line-height: 0px; text-align: inherit; font-size: medium; font-weight: normal; padding: 0px; text-transform: none; a:"
								href="<%= IConstants.USERS_URL%>"> <span class="glyphicon glyphicon-user"></span>
								[Админ панел]
							</a>
						</div>
						<%
							}
						%>
						<%
							}
						%>
					</ul>
				</div>
			</div>
			<div id="banner">
				<div class="content">
					<img src="images/cars.jpg" width="1000" height="300" alt="" />
				</div>
			</div>
		</div>
		<div id="page">