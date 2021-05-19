<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>noticeInfo.jsp</title>
</head>

<body>
	<jsp:include page="../menu/mainMenu.jsp"></jsp:include>
	<h3>noticeInfo/update page</h3>
	<table border="1">
		<tr>
			<th>글번호</th>
			<td colspan="3">${notice.ntcNo }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${notice.ntcTitle }</td>
			<th>게시기간</th>
			<td>
				<c:choose>
					<c:when test="${author eq 'admin' }">
						<input type="date" value="${notice.ntcFromDate }">
						<b>~</b>
						<input type="date" value="${notice.ntcToDate }">
					</c:when>
					<c:otherwise>
						<p>${notice.ntcFromDate }~ ${notice.ntcToDate }</p>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3" width="600px" height="180px">
				<c:choose>
					<c:when test="${author eq 'admin' }">
						<textarea cols="79" rows="20">${notice.ntcContent }</textarea>
					</c:when>
					<c:otherwise>${notice.ntcContent }</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td colspan="3">${notice.ntcRegDate }</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<button id="OK">확인</button>
				<c:if test="${author eq 'admin' }">
					<button>수정</button>
				</c:if>
			</td>
		</tr>
	</table>

</body>

</html>