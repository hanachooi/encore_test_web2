package org.example;

import org.example.dto.TestDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        if(id.equals("encore") && pwd.equals("encore")){
            // 백엔드로부터 전달받은 데이터(가정)
            TestDTO params = new TestDTO();
            params.setId("encore"); params.setPwd("encore"); params.setName("엔코아");

            request.setAttribute("user", params);

            RequestDispatcher view = request.getRequestDispatcher("./ok.jsp");
            view.forward(request, response);
        }else{
            RequestDispatcher view = request.getRequestDispatcher("./error.jsp");
            view.forward(request, response);
        }
    }
}
