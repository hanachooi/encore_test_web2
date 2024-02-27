<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Document</title>
</head>
<div align="center">SW 5th landing page</div>
<div align = "right">
    <%-- form 에서 메서드는 get이 아닌, post를 이용하는 것이 좋다. --%>
    <form method = "get" action = "login.encore">
        <%-- 넘어갈 때, DTO 에서 이용하려면, DTO 와 넘겨지는 변수명을 동일하게 name을 설정해야 한다. --%>
        <input type = "text"        name = "id"><br/>
        <input type = "password" name = "pwd">
        <input type = "submit" values = "login">
        <%-- 서버와 통신하는 방법은, form 과 a 를 이용해서만 가능 --%>
        &nbsp;&nbsp;
        <a href = "join.encore">JOIN</a>
    </form>
</div>
<body>
</body>
</html>