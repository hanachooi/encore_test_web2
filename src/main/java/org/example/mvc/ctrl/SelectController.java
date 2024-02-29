package org.example.mvc.ctrl;

import org.example.dto.ResponseUserDTO;
import org.example.fordispatcher.Controller;
import org.example.mvc.service.util.MvcService;
import org.example.mvc.view.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SelectController implements Controller {

    private MvcService service;

    public SelectController(){

    }

    public SelectController(MvcService service) {
        this.service = service;
    }

    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp) {

        System.out.println("SelectController.execute");
        List<ResponseUserDTO> list = service.select();
        System.out.println("SelectController.execute");

        for(ResponseUserDTO dto : list){
            System.out.println(dto);
        }

        // 데이터 심기
        req.setAttribute("list", list);

        View view = new View();
        view.setFlag(true);
        view.setResponseJsp("list.jsp");
        return view;
    }
}
