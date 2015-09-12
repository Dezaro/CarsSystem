<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="includes/header.jsp"%>

<div id="content" style="float: none; width: 100%;">
	<h3 style="margin-bottom: 20px;">Редактиране на модел</h3>

	<table
		class='table table-bordered table-striped table-condensed table-hover'
		style='display: inline-table;'>
		<tr>
			<th><label style='color: #326B7E;'> # </label></th>
			<th><label style='color: #326B7E;'> Снимка </label></th>
			<th><label style='color: #326B7E;'> Марка </label></th>
			<th><label style='color: #326B7E;'> Модел </label></th>
			<th><label style='color: #326B7E;'> Серия </label></th>
			<th><label style='color: #326B7E;'> Цена </label></th>
			<th><label style='color: #326B7E;'> Информация </label></th>
			<th><label style='color: #326B7E;'> Дата на регистрация
			</label></th>
			<th><label style='color: #326B7E;'> Операции </label></th>
		</tr>

		<c:forEach var="model" items="${models}">
			<tr>
				<td>${model.id }</td>
				<td><img class="ims" src="images/${model.picture }"></td>
				<td>${model.brand }</td>
				<td>${model.model }</td>
				<td>${model.seria }</td>
				<td>${model.price }</td>
				<td>${model.info }</td>
				<td>${model.data }</td>
				<th><ul class="nav navbar-nav">
						<li><a href="<%=IConstants.LOAD_MODEL%>?car_id=${model.id }&brand_id=${model.brand_id }"><span
								class="glyphicon glyphicon-pencil"></span></a></li>
						<li><a data-toggle="modal" onClick="de(${model.id });"
							href=""><span class="glyphicon glyphicon-trash"></span></a></li>
					</ul></th>
			</tr>
		</c:forEach>
	</table>
<ul class="pagination" style="margin-bottom: 50px;">
	<c:if test="${currentPage != 1}">
		<li><a href="models?page=${currentPage - 1}">Предишна</a></li>
	</c:if>
	<c:forEach begin="${startLink}" end="${endLink}" var="i">
		<c:choose>
			<c:when test="${currentPage eq i}">
				<li class="active"><a>${i}</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="models?page=${i}">${i}</a></li>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${currentPage lt pages}">
		<li><a href="models?page=${currentPage + 1}">Следваща</a>
		<li>
	</c:if>
</ul>
</div>
<script type="text/javascript">
	function de(a) {
		document.getElementById('car_id').value = a;
		$('#myModal').modal('show');
	};
</script>

<div class="modal fade" id="myModal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h4 class="modal-title">Изтриване</h4>
			</div>
			<div class="modal-body">
				<p>Сигурни ли сте, че желаете да изтриете избран модел?</p>
			</div>
			<div class="modal-footer">
				<form method="post" action="<%=IConstants.MODEL_DELETE%>">
					<input type="hidden" id="car_id" name="car_id" />
					<button name="delete" type="submit" class="btn btn-danger">
						<span class="glyphicon glyphicon-trash"></span> Изтрий
					</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">
						<span class="glyphicon glyphicon-remove-circle"></span> Откажи
					</button>
				</form>
			</div>
		</div>
	</div>
</div>
<%@ include file="includes/footer.jsp"%>