<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>noticeList.jsp</title>
</head>

<body>
	<jsp:include page="../menu/mainMenu.jsp" />
	<hr>
	<c:choose>
		<c:when test="${!empty list }">
			<table border="1">
				<tr>
					<th>공지글번호</th>
					<th>제목</th>
					<th>게시시간:from</th>
					<th>게시시간:to</th>
					<th>등록일</th>
				</tr>
				<c:forEach items="${list }" var="item">
					<tr>
						<td>${item.ntcNo }</td>
						<td>${item.ntcTitle }</td>
						<td>${item.ntcFromDate }</td>
						<td>${item.ntcToDate }</td>
						<td>${item.ntcRegDate }</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h3>등록된 글이 없습니다.</h3>
		</c:otherwise>
	</c:choose>
	<a href="<%=request.getContextPath()%>/noticeForm.do">게시글 등록</a>
</body>

</html>