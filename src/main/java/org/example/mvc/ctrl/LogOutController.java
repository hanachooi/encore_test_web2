package org.example.mvc.ctrl;

import org.example.fordispatcher.Controller;
import org.example.mvc.service.util.MvcService;
import org.example.mvc.service.util.MvcServiceImpl;
import org.example.mvc.view.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Provider;

// url 요청을 하면, dispatcherServlet은 Factory에서, 충족하는 컨트롤러에 따른, view를 반환하고
// 이를 dispatcherServlet에서 받아서 반환해야 함.

public class LogOutController implements Controller {

    private MvcService service;

    public LogOutController(){

    }

    public LogOutController(MvcService service){
        this.service = service;
    }

    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("debug >>> LogOutCtrl execute()");
        View view = new View();
        view.setResponseJsp("./logout.jsp");
        return view;
    }
}
