package org.example.mvc.ctrl;

import org.example.dto.RequestUserDTO;
import org.example.dto.ResponseUserDTO;
import org.example.fordispatcher.Controller;
import org.example.mvc.service.util.MvcService;
import org.example.mvc.service.util.MvcServiceImpl;
import org.example.mvc.view.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JoinController implements Controller {

    private MvcService service;

    public JoinController(){

    }

    public JoinController(MvcService service){
        this.service = service;
    }

    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("debug >>> JoinCtrl execute()");
        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");
        System.out.println("debug param id : " + id);
        System.out.println("debug param pwd : " + pwd);

        RequestUserDTO params = new RequestUserDTO(id, pwd);
        //////// 서비스로 부터 반환 받은 값
        ResponseUserDTO user = service.login(params);

        service.join();
        View view = new View();
        view.setFlag(true);
        view.setResponseJsp("./join.jsp");

        return view;
    }
}
