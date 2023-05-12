<%--
  Created by IntelliJ IDEA.
  User: sexytony
  Date: 2023/05/02
  Time: 11:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Todo Read</title>
</head>
<body>
// 2-5 (3.조회) dto라는 이름으로 TodoDTO담아주고, "/todo/read?tno=1"과 같은 형태로 받음
  <div>
      <input type="text" name="tno" value="${dto.tno}" readonly>
  </div>
      <input type="text" name="title" value="${dto.title}" readonly>
  <div>
      <input type="date" name="dueDate" value="${dto.dueDate}">
  </div>
      <input type="checkbox" name="finished" ${dto.finished ? "checked" : ""} readonly>
  <div>
      <a href="/todo/modify?tno=${dto.tno}">Modify/Remove</a>
      <a href="/todo/list">List</a>
  </div>

</body>
</html>
