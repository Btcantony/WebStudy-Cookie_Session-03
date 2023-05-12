<%--
  Created by IntelliJ IDEA.
  User: sexytony
  Date: 2023/05/10
  Time: 11:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
//3장 (3-5.${param.result == 'error'} 을 통해 로그인 에러)
<c:if test="${param.result == 'error'}">
    <h1>로그인 에러</h1>
</c:if>

//3장 (1-3.로그인 Jsp 구현)
<form action="/login" method="post">
    <input type="text" name="mid">
    <input type="text" name="mpw">
//3장 (4-1. 자동 로그인 처리)
    <input type="checkbox" name="auto">
    <button type="submit">LOGIN</button>
</form>
</body>
</html>
