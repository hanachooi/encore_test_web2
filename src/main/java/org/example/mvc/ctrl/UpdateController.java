package org.example.mvc.ctrl;

import org.example.fordispatcher.Controller;
import org.example.mvc.service.util.MvcService;
import org.example.mvc.service.util.MvcServiceImpl;
import org.example.mvc.view.View;

public class UpdateController implements Controller {

    private MvcService service;

    public UpdateController(){

    }

    public UpdateController(MvcService service){
        this.service = service;
    }

    @Override
    public View execute() {
        System.out.println("debug >>> UpdateCtrl execute()");
        View view = new View();
        view.setResponseJsp("./update.jsp");
        return view;
    }
}
