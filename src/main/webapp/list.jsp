<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="org.example.dto.ResponseUserDTO" %>
<%@ page import="org.example.dto.RequestUserDTO" %>
<%@ page errorPage="./error.jsp"%>

<!DOCTYPE>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
          crossorigin="anonymous">
</head>

<body>
    <table class = "table">
        <thead>
        <tr>
            <th>아이디</th><th>패스워드</th><th>이름</th>
        </tr>
        </thead>

        <%
            // 쓸 때는 get, 넣을 때는 set
            ArrayList<ResponseUserDTO> list = (ArrayList<ResponseUserDTO>)request.getAttribute("list");
            for(int i = 0; i<list.size(); i++){
        %>
        <tr>
            <td><%=list.get(i).getId()%></td>
            <td><%=list.get(i).getPwd()%></td>
            <td><%=list.get(i).getName()%></td>
        </tr>
        <%
            }
        %>

    </table>
</body>
</html>