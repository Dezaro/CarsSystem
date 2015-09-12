<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="includes/header.jsp"%>
<%@ include file="includes/sidebar.jsp"%>

<div id="content">
	<c:forEach var="model" items="${brandModels }">
		<div class="post">
			<h3 class="title">
				<a href="<%=IConstants.INFO_URL%>?car_id=${model.id }">${model.brand }
					${model.model }</a>
			</h3>
			<div class="entry">
				<p>
					<a href="<%=IConstants.INFO_URL%>?car_id=${model.id }"><img
						class="ims" src="images/${model.picture }"></a><label
						style="color: #326B7E;">Цена:</label> ${model.price } <label
						style="color: #326B7E;"> лв.</label>
				</p>
			</div>
		</div>
		<c:set var="brand" value="${model.brand }"></c:set>
	</c:forEach>
	<ul class="pagination" style="margin-bottom: 50px;">
		<c:if test="${currentPage != 1}">
			<li><a
				href="<%=IConstants.BRAND_MODELS %>?brand=${brand }&page=${currentPage - 1}">Предишна</a></li>
		</c:if>
		<c:forEach begin="${startLink}" end="${endLink}" var="i">
			<c:choose>
				<c:when test="${currentPage eq i}">
					<li class="active"><a>${i}</a></li>
				</c:when>
				<c:otherwise>
					<li><a
						href="<%=IConstants.BRAND_MODELS %>?brand=${brand }&page=${i}">${i}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${currentPage lt pages}">
			<li><a
				href="<%=IConstants.BRAND_MODELS %>?brand=${brand }&page=${currentPage + 1}">Следваща</a>
			<li>
		</c:if>
	</ul>
</div>
<%@ include file="includes/footer.jsp"%>