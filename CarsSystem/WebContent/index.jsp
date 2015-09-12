<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="carsSystem.model.IConstants"%>
<%@ include file="includes/header.jsp"%>
<%@ include file="includes/sidebar.jsp"%>

<div id="content">
	<%
		String error = (String) session.getAttribute(IConstants.LAST_ERROR);
		if (error != null) {
	%>
	<div class="alert alert-danger" role="alert"><%=error%></div>
	<%
		session.removeAttribute(IConstants.LAST_ERROR);
		}
	%>
	<h2 style="margin-bottom: 20px;">Нови модели</h2>
	<c:forEach var="model" items="${newModels }">
		<div class="post">
			<h3 class="title">
				<a href="<%=IConstants.INFO_URL%>?car_id=${model.id }">${model.brand }
					${model.model }</a>
			</h3>
			<div class="entry">
				<p>
					<a href="<%=IConstants.INFO_URL%>?car_id=${model.id }"><img class="ims" src="images/${model.picture }"></a>
					<label style="color: #326B7E;">Цена:</label>${model.price } <label
						style="color: #326B7E;"> лв.</label>
				</p>
			</div>
		</div>
	</c:forEach>
</div>
<%@ include file="includes/footer.jsp"%>