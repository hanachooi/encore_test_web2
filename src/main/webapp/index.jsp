<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!-- web.xml 에서, default 페이지로 저장해놓음 -->
<!-- <!DOCTYPE>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>

<body>
<div align="center">SW 5th landing page</div>
</body>
</html>
-->

<!-- 컨트롤러를 통해서, 맨 첫 화면이 렌더링이 되는 것이 좋음 -->
<%-- 아래의 주석으로 java의 코드를 사용할 수 있고, ! 로 주석을 잡으면, 실행이 되게 되므로, % 로 잡아야 한다.
주석이 !이면, 구글 개발자도구에서 주석이 보이게 됌.
    <%!
        private int number = 10;
        public int getNumber(){
            return number;
        }
    %>
 --%>
<script>
    location.href = "index.encore";
</script>