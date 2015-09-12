<%@page import="carsSystem.model.IConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="sidebar">
	<ul>
		<li>
			<h2>Марки</h2>
			<ul>
				<c:forEach var="brand" items="${brands}">
					<li><a href="<%=IConstants.BRAND_MODELS%>?brand=${brand }">${brand }</a></li>
				</c:forEach>
			</ul>
		</li>
	</ul>
</div>