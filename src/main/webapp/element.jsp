<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="org.example.mvc.model.*" %>
<%@ page import="org.example.dto.RequestUserDTO" %>
<%@ page import="org.example.dto.ResponseUserDTO" %>
<!DOCTYPE>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>
    <%-- JSP 주석 --%>
    <%-- 선언문(변수, 메서드) --%>
    <%!
        private MariaDao dao;
        private RequestUserDTO params;
        private ResponseUserDTO user;

        private String msg;
        public void setMsg(String msg){
            this.msg = msg;
        }
        public String getMsg(){
            return this.msg;
        }
        public String getName(){
            return user.getName();
        }

    %>
    <%--
    scriplet tag (서블릿 메서드(doGet | doPost))
    사용자가 jsp를 호출하게 되면 수행되는 영역
    doGet(HttpServletRequest request, HttpServletResponse response){ }
    --%>
    <%
        dao = new MariaDao();
        params = new RequestUserDTO("jslim", "jslim");
        user = dao.loginRow(params);

        setMsg("저는 JSP 입니다.");
        out.print("<div align = 'center'>");
        out.print(getMsg());
        out.print("</div>");
    %>
    <!-- 표현식 코드 -->
    <%= this.getName() + "님 환영합니다."%>
</body>
</html>