<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="includes/header.jsp"%>
<%@ include file="includes/sidebar.jsp"%>

<div id="content">

	<div class="post">
		<c:set var="car" value="${carInfo }"></c:set>
		<h2 class="title">
			<a href="">${car.brand } ${car.model }</a>
		</h2>
		<div class="entry">
			<p>
				<a href="images/${car.picture }"><img class="ims"
					src="images/${car.picture }"></a><label style="color: #326B7E;">Цена:</label>${car.price }<label
					style="color: #326B7E;"> лв.</label>
			</p>
			<p>
				<label style="color: #326B7E;">Марка:</label> ${car.brand }
			</p>
			<p>
				<label style="color: #326B7E;">Модел:</label> ${car.model }
			</p>
			<p>
				<label style="color: #326B7E;">Информация:</label> ${car.info }
			</p>
			<p>
				<label style="color: #326B7E;">Серия:</label> ${car.seria }
			</p>
			<p>
				<label style="color: #326B7E;">Дата на производство:</label>
				${car.data }
			</p>
		</div>
	</div>
</div>
<%@ include file="includes/footer.jsp"%>