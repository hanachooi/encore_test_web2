package org.example;

import com.sun.net.httpserver.Request;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 이 서블릿의 컨트롤러를 사용자가 호출이 가능하게 함.
// 해당 링크로 넘어가면, get 방식으로 화면이 랜더링 됌.
// 해당 링크가 작동될 떄마다(사용자가 호출할 때마다), console에 sysout의 내용이 출력 됌(각각 메서드가 호출될 수 있음)
// 서블릿은 controller , jsp 는 view 역할 ( 그냥 대략 )
//@WebServlet("/test.encore")     // 이렇게, WebServlet 어노테이션을 사용해도 되고, web.xml의 servlet 태그를 이용해도 된다. ( xml 쓸거면, 어노테이션 쓰면 안됌 )
public class TestController extends HttpServlet {
    // 웹서블릿은 무조건 (요청,응답)을 객체로 받음.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("debug >>> TestController doGet() ");
        /*
        PrintWriter responseOut = response.getWriter();
        responseOut.print("<div align=\"center\">Web Application Programming(Servlet/JSP)</div>");
        responseOut.close();
        */

        // 화면 분기       request                                        jdbc, ORM
        // browser  -------> Controller  -------> Service -------> Dao ------------> DBMS

        // 분기 첫번째 방식 redirect(); 현업에서 안씀
        // test.encore 호출 시, test.jsp 로 url 경로가 바뀜
        // response.sendRedirect("./test.jsp");

        // 분기 두번째 방식 forward() : 스프링부트가 권장하는 방식
        // test.encore일 때, url 경로가 test.jsp 로 안바뀌고도 test.jsp 화면이 출력됌.
        RequestDispatcher view = request.getRequestDispatcher("./test.jsp");
        view.forward(request,response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}