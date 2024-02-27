package org.example.mvc.ctrl;

import org.example.fordispatcher.Controller;
import org.example.mvc.service.util.MvcService;
import org.example.mvc.service.util.MvcServiceImpl;
import org.example.mvc.view.View;

public class JoinController implements Controller {

    private MvcService service;

    public JoinController(){

    }

    public JoinController(MvcService service){
        this.service = service;
    }

    @Override
    public View execute() {
        System.out.println("debug >>> JoinCtrl execute()");
        service.join();
        View view = new View();
        view.setFlag(true);
        view.setResponseJsp("./join.jsp");

        return view;
    }
}
