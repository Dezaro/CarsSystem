<%@page import="carsSystem.model.IConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="includes/header.jsp"%>
<%@ include file="includes/sidebar.jsp"%>
<div id="content" style="float: right; width: 60%;">
	<h3 style="margin-bottom: 20px;">Редактиране на модел</h3>
	<form role="form" method="post" action="<%= IConstants.MODEL_UPDATE %>">
		<input type="hidden" name="car_id" value="${model.id }" /> <input
			type="hidden" name="url" value="${url }" /> <input type="hidden"
			name="brand_id" value="${brand_id }" />
		<div class="form-group">
			<label for="brand"> ${model.brand } ${model.model }
			</label>
		</div>
		<div class="form-group">
			<img class="ims" style="display: block; float: none;"
				src="images/${model.picture }">
		</div>
		<div class="form-group">
			<label for="model">Модел:</label> <input type="text"
				class="form-control" name="model" id="model" value="${model.model }">
		</div>
		<div class="form-group">
			<label for="seria">Серия:</label> <input type="text"
				class="form-control" name="seria" id="seria" value="${model.seria }">
		</div>
		<div class="form-group">
			<label for="price">Цена:</label> <input type="text"
				class="form-control" name="price" id="price" value="${model.price }">
		</div>
		<div class="form-group">
			<label for="info">Информация:</label>
			<textarea class="form-control" name="info" id="info">${model.info }</textarea>
		</div>
		<div class="form-group">
			<label for="date">Дата на регистрация:</label> <input type="text"
				class="form-control" name="date" id="date" value="${model.data }">
		</div>

		<div style="float: right;">
			<button type="submit" name="edit" class="btn btn-default">
				<span class="glyphicon glyphicon-pencil"></span> Редактирай
			</button>
			<button type="submit" name="cancel" class="btn btn-default"
				onclick="history.back()">
				<span class="glyphicon glyphicon-remove-circle"></span> Откажи
			</button>
		</div>
	</form>
</div>
<%@ include file="includes/footer.jsp"%>