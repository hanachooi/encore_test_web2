package org.example.mvc.ctrl;

import org.example.LoginController;
import org.example.fordispatcher.Controller;
import org.example.mvc.service.util.MvcService;
import org.example.mvc.service.util.MvcServiceImpl;
import org.example.mvc.view.View;

public class LogInController implements Controller {

    // DI (Dependency Inject - Constructor Injection)
    private MvcService service;

    public LogInController(){

    }

    public LogInController(MvcService service) {
        this.service = service;
    }

    @Override
    public View execute() {
        System.out.println("debug >>> LogInCtrl execute()");
        service.login();
        View view = new View();
        view.setResponseJsp("./login.jsp");
        return view;
    }
}
