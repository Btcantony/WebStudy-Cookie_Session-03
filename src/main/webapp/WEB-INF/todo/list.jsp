<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Todo List</title>
</head>
<body>
<h1>Todo List</h1>

<%--<h2>${appName}</h2>--%>
//3장 (3-6. 로그인한 사용자 이름 추가)
<h2>${appName}</h2>
<h2>${loginInfo}</h2>
<h2>${loginInfo.mname}</h2>

// 2-5 (2.목록) 컨트롤러에서 쏴준 dtoList받음
<ul>
    <c:forEach items="${dtoList}" var="dto">

        // 2-6 (3.조회) 목록페이지 게시물 링크 추가
        <li>
            <span><a href="/todo/read?tno=${dto.tno}">${dto.tno}</a> </span>
            <span>${dto.title}</span>
            <span>${dto.dueDate}</span>
            <span>${dto.finished? "DONE": "NOT YET"}</span>
        </li>
    </c:forEach>
</ul>

//3장 (2-2.로그아웃 버튼 눌르면 로그아웃)
<form action="/logout" method="post">
    <button>LOGOUT</button>
</form>

</body>
</html>
