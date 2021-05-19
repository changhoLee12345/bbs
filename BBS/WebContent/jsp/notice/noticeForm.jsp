<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>noticeForm.jsp</title>
</head>

<body>
	<jsp:include page="../menu/mainMenu.jsp"></jsp:include>
	<hr>
	<h3>관리자 등록/ 사용자 조회</h3>
	<form action="<%=request.getContextPath() %>/noticeInsert.do" method="post">
		<table border="1">
			<tr>
				<td>공지제목</td>
				<td><input type="text" style="display:inline-block; width:350px;" name="ntcTitle"></td>
			</tr>
			<tr>
				<td>게시기간</td>
				<td><input type="date" name="ntcFromDate"> ~
					<input type="date" name="ntcToDate">
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea cols="100" rows="20" name="ntcContent"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="공지등록">
					<input type="reset" value="초기화">
				</td>
			</tr>
		</table>
	</form>
</body>

</html>