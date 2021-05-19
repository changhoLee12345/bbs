<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<jsp:include page="../menu/mainMenu.jsp" />
	<hr>
	<div align="center">
		<c:if test="${vo.name eq null }">
			<h1>${param.id } 님 로그인 실패 했습니다.</h1>
			<h1>${msg }</h1>
		</c:if>
		<c:if test="${vo.name ne null }">
			<h1>${msg }</h1>
			<h1>${vo.name } 님 안녕하세요?</h1>
		</c:if>
	</div>
</body>

</html>