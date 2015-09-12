<%@page import="carsSystem.model.IConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="includes/header.jsp"%>
<%@ include file="includes/sidebar.jsp"%>
<div id="content" style="width: 30%; float: left; margin-left: 175px;">
	<h3 style="margin-bottom: 20px;">Добавяне модел</h3>
	<form method="post" enctype="multipart/form-data"
		style="margin-bottom: 15px;" action="<%=IConstants.MODEL_INSERT%>">
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
			<label for="sel1">Марка:</label> <select class="form-control"
				name="Brand" id="sel1">
				<c:forEach var="brand" items="${brands}">
					<option>${brand }</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label for="Name">Модел:</label> <input type="text"
				class="form-control" name="Model" id="Model" placeholder="Модел">
		</div>
		<div class="form-group">
			<label for="Name">Серия:</label> <input type="text"
				class="form-control" name="Seria" id="Seria" placeholder="Серия">
		</div>
		<div class="form-group">
			<label for="Price">Цена:</label> <input type="text"
				class="form-control" name="Price" id="Price" placeholder="Цена">
		</div>
		<div class="form-group">
			<label for="Data">Дата на производство:</label> <input type="date"
				class="form-control" name="Data" id="Data"
				placeholder="Дата на производство">
		</div>
		<div class="form-group">
			<label for="Img">Добави снимка:</label> <span
				class="btn btn-default btn-file"><input type="file"
				name="fileToUpload" id="fileToUpload"> </span>
		</div>
		<div class="form-group">
			<label for="Info">Информация:</label>
			<textarea class="form-control" rows="5" name="Info" id="Info"></textarea>
		</div>
		<button type="submit" name="add" class="btn btn-default">
			<span class="glyphicon glyphicon-plus"></span> Добави
		</button>
	</form>
</div>
<%@ include file="includes/footer.jsp"%>