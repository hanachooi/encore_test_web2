package org.example;

import org.example.fordispatcher.Controller;
import org.example.mvc.service.util.MvcService;
import org.example.mvc.service.util.MvcServiceImpl;
import org.example.mvc.view.View;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// index.jsp 에서 응답이 들어오는 이름과 동일하게
// servlet을 이용한다는 가정하에,, 쓰인 코드.
/*
@WebServlet("/index.encore")
public class IndexController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("debug >>>. IndexController doGet() ");
        RequestDispatcher view = req.getRequestDispatcher("./main.jsp");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
*/

//
public class IndexController implements Controller{

    private MvcService service;


    public IndexController(MvcService service){
        this.service = service;
    }

    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("IndexController.execute");
        View view = new View();
        view.setFlag(true);
        view.setResponseJsp("./main.jsp");
        return view;
    }

}