package org.example;

import org.example.dto.TestDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login.encore")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("debug >>> client uri : " + request.getRequestURI());
        System.out.println("debug >>> client QueryString : " + request.getQueryString());
        System.out.println("debug >>> client request metod : " + request.getMethod());

        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");

        // 한글 인코딩 작업을 하면 한글이 깨지지 않는다.
        // request.setCharacterEncoding("UTF-8");

        System.out.println("debug >> params : " + id);
        System.out.println("debug >> params : " + pwd);

        if(id.equals("encore") && pwd.equals("encore")){
            // 백엔드로부터 전달받은 데이터(가정)
            TestDTO params = new TestDTO();
            params.setId("encore"); params.setPwd("encore"); params.setName("엔코아");

            // scope는 forward 되어지는 페이지까지만 데이터를 유지할 수 있다.
            request.setAttribute("user", params);

            // forward는 스코프 영역까지만 가능하다. 그러므로, 로그인 정보 등은 스코프를 session 영역으로 해야한다.
            //RequestDispatcher view = request.getRequestDispatcher("./ok.jsp");
            //view.forward(request, response);

            // jsp 의 스코프 중 session 영역에 user 정보를 넣고, forward를 하게 되면, 모든 곳에 forwarding이 가능하게 되어,
            // 로그인 정보를 유지할 수 있다.
            HttpSession session = request.getSession();
            session.setAttribute("user", params);
            RequestDispatcher view = request.getRequestDispatcher("./ok.jsp");
            view.forward(request, response);

            // redirect를 하게 되면, 데이터 유지가 되지 않게 됌.
            // response.sendRedirect("./ok.jsp");
        }else{
            RequestDispatcher view = request.getRequestDispatcher("./error.jsp");
            view.forward(request, response);
        }
    }
}
