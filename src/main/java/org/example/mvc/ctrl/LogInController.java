package org.example.mvc.ctrl;

import org.example.LoginController;
import org.example.dto.RequestUserDTO;
import org.example.dto.ResponseUserDTO;
import org.example.fordispatcher.Controller;
import org.example.mvc.service.util.MvcService;
import org.example.mvc.service.util.MvcServiceImpl;
import org.example.mvc.view.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogInController implements Controller {

    // DI (Dependency Inject - Constructor Injection)
    private MvcService service;

    public LogInController(){

    }

    public LogInController(MvcService service) {
        this.service = service;
    }

    // Controller 역할
    // 1. 파람미터가 있으면 값을 전달받고 이걸 DTO 바인딩한다.
    // 2. DTO 객체를 SERVICE에 전달하여 특정 결과를 반환 받는다.
    // 3. 전달받은 값을 jsp 에 출력한다면 데이터를 심어 (request, session)
    // 4. View 객체를 이용해서 분기방식과 렌더링될 페이지 정보를 FrontController 전달하면 됌.
    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("debug >>> LogInCtrl execute()");
        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");
        System.out.println("debug param id : " + id);
        System.out.println("debug param pwd : " + pwd);
        // getParam 을 해서, id와 pwd를 request에서 getParameter 로 id와 pwd 를 가져와서, String id와 pwd로 담는다.
        // 이걸 dto 에 넣어서,
        RequestUserDTO dto = new RequestUserDTO(id, pwd);
        //////// 서비스로 부터 반환 받은 값
        ResponseUserDTO user = service.login(dto);
        //
        View view = new View();

        if(user != null){
            // 로그인이 정상적으로 됌.
            req.setAttribute("user", user);
            view.setFlag(true);
            view.setResponseJsp("./ok.jsp");
            return view;
        }else{
            // 로그인이 정상적으로 작동되지 않음.
            view.setFlag(true);
            view.setResponseJsp("./error.jsp");
            return view;
        }

    }
}
