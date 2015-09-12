<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="includes/header.jsp"%>
<div id="content" style="float: none; width: 100%;">
	<div style="margin-bottom: 20px;">
		<h3 style="display: inline;">Потребители</h3>
		<form method="post" style="float: right; display: inline;">
			<button type="submit" name="new" class="btn btn-default" onclick="document.forms[0].action = 'add_user.jsp'; return true;">
				<span class="glyphicon glyphicon-plus"></span> Нов потребител
			</button>
		</form>
	</div>
</div>
<table
	class='table table-bordered table-striped table-condensed table-hover'
	style='display: inline-table;'>
	<tr>
		<th><label style='color: #326B7E;'> # </label></th>
		<th><label style='color: #326B7E;'> Потребителско име </label></th>
		<th><label style='color: #326B7E;'> Име </label></th>
		<th><label style='color: #326B7E;'> Фамилия </label></th>
		<th><label style='color: #326B7E;'> Поща </label></th>
		<th><label style='color: #326B7E;'> Парола </label></th>
		<th><label style='color: #326B7E;'> Роля </label></th>
		<th><label style='color: #326B7E;'> Операции </label></th>
	</tr>
	<c:forEach var="user" items="${usersList}">
		<tr>
			<td>${user.id}</td>
			<td>${user.userName}</td>
			<td>${user.firstName }</td>
			<td>${user.lastName }</td>
			<td>${user.email }</td>
			<td>${user.password }</td>
			<td>${user.role }</td>
			<th><ul class="nav navbar-nav">
					<li><a href="loadUser?user_id=${user.id}"><span class="glyphicon glyphicon-pencil"></span></a></li>
					<li><a data-toggle="modal" onClick="de(${user.id});" href=""><span
							class="glyphicon glyphicon-trash"></span></a></li>
				</ul></th>
		</tr>
	</c:forEach>
</table>
<ul class="pagination" style="margin-bottom: 50px;">
	<c:if test="${currentPage != 1}">
		<li><a href="users?page=${currentPage - 1}">Предишна</a></li>
	</c:if>
	<c:forEach begin="${startLink}" end="${endLink}" var="i">
		<c:choose>
			<c:when test="${currentPage eq i}">
				<li class="active"><a>${i}</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="users?page=${i}">${i}</a></li>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${currentPage lt pages}">
		<li><a href="users?page=${currentPage + 1}">Следваща</a>
		<li>
	</c:if>
</ul>
<script type="text/javascript">
	function de(a) {
		document.getElementById('user_id').value = a;
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
				<p>Сигурни ли сте, че желаете да изтриете потребителя?</p>
			</div>
			<div class="modal-footer">
				<form method="post" action="<%=IConstants.USERS_DELETE%>">
					<input type="hidden" id="user_id" name="user_id" />
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