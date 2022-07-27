<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>bulletin.jsp</title>
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="//cdn.ckeditor.com/4.16.1/full/ckeditor.js"></script>
	<script>
		$(function () {
			CKEDITOR.replace('content', {
				filebrowserUploadUrl: '${pageContext.request.contextPath }/fileUpload',
				height: '600px',
				width: '800px'
			});

			$('#btnUpdate').click(function (e) {
				e.preventDefault();
				console.log(CKEDITOR.instances.content.getData());
				
				let id = $('#id').val();
				let title = $('#title').val();
				let content = CKEDITOR.instances.content.getData();
				$.ajax({
					url: 'ajaxBulletinUpdate',
					data: {
						id: id,
						title: title,
						content: content
					},
					type: 'post',
					success: function (result) {
						console.log(result);
						location.href = 'bulletinList.do';
					},
					error: function (err) {
						console.log(err);
					}
				});
			});
		})
	</script>

</head>

<body>
	<div align="center">
		<h3>게시글 내용보기</h3>
		<form id="frm" action="bulletinUpdate.do" method="post">
			<input type="hidden" id="id" name="id" value="${bulletin.id }">
			<table border="1">
				<tr>
					<th>순번</th>
					<td id="cid">${bulletin.id }</td>
					<th>작성일자</th>
					<td>${bulletin.regDate }</td>
					<th>작성자</th>
					<td>${bulletin.writer }</td>
					<th>조회수</th>
					<td>
					<c:forEach begin="1" end="${bulletin.hit }">
						<i class="fab fa-apple" style="font-size:28px;color:red;"></i>					
					</c:forEach>
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="7">
						<c:if test="${id eq bulletin.writer }">
							<input id="title" name="title" type="text" value="${bulletin.title }">
						</c:if>
						<c:if test="${id ne bulletin.writer }">
							${bulletin.title }
						</c:if>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="7">
						<textarea id="content" name="content" rows="6" cols="90">${bulletin.content }</textarea>
					</td>
				</tr>
			</table>
			<div>
				<button type="button" onclick="location.href='noticeList.do'">목록보기</button>
				<c:if test="${id eq bulletin.writer }">
					<button type="submit">수정</button>
					<button type="button" id="btnUpdate">수정2</button>
				</c:if>
			</div>
		</form>
	</div>
</body>

</html>