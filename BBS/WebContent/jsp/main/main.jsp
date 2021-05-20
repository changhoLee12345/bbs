<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
        $(document).ready(function () {

            $.ajax({
                url: "<%=request.getContextPath() %>/memberListJson.do",
                dataType: "json",
                success: function (result) {
                    console.log(result);
                    let tab = $('<table />').attr('border', '1');
                    for (let i = 0; i < result.length; i++) {
                        let tr = $('<tr />').attr('id', result.id);
                        tr.append( //
                            $('<td />').html(result[i].id), //
                            $('<td />').html(result[i].name), //
                            $('<td />').html(result[i].tel), //
                            $('<td />').html(result[i].author) //
                        )
                        tab.append(tr);
                    }
                    $('#show').append(tab);
                },
                error: function (err) {
                    console.log(err);
                }
            });

        });
    </script>
</head>

<body>
    <jsp:include page="../menu/mainMenu.jsp" />
    <hr>
    홈 페이지에 오신걸 환영합니다.
    <h3>Ajax 호출로 리스트 보여주기</h3>
    <div id="show"></div>
</body>

</html>