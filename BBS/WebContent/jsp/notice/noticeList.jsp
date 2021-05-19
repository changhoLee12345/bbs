<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>noticeList.jsp</title>
	<style>
		body {
			width: 100%;
		}

		.content {
			position: relative;
			margin-left: auto;
			margin-right: auto;
			width: 80%;
		}
	</style>
</head>

<body>
	<jsp:include page="../menu/mainMenu.jsp" />
	<hr>
	<div class="content">
		<c:choose>
			<c:when test="${!empty list }">
				<table border="1">
					<tr>
						<th align="center" width="100px">공지글번호</th>
						<th width="250px">제목</th>
						<th width="150px">게시시간:from</th>
						<th width="150px">게시시간:to</th>
						<th width="150px">등록일</th>
					</tr>
					<c:forEach items="${list }" var="item">
						<tr id="${item.ntcNo }">
							<td align="center">${item.ntcNo }</td>
							<td align="center"><a href="">${item.ntcTitle }</a></td>
							<td align="center">${item.ntcFromDate }</td>
							<td align="center">${item.ntcToDate }</td>
							<td align="center">${item.ntcRegDate }</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<h3>등록된 글이 없습니다.</h3>
			</c:otherwise>
		</c:choose>
		<h3></h3>
		<a href="<%=request.getContextPath()%>/noticeForm.do">게시글 등록</a>
	</div>
</body>

</html>