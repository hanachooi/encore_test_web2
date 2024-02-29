package org.example.mvc.ctrl;

import org.example.fordispatcher.Controller;
import org.example.mvc.service.util.MvcService;
import org.example.mvc.service.util.MvcServiceImpl;
import org.example.mvc.view.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Provider;

// url 요청을 하면, dispatcherServlet은 Factory에서, 충족하는 컨트롤러에 따른, view를 반환하고
// 이를 dispatcherServlet에서 받아서 반환해야 함.

// 사용자의 명시적인 로그아웃이 요청되면
// 사용자 브라우저에 부여한 모든 세션을 클리어시키는 역할
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

        HttpSession session = req.getSession(false);
        session.invalidate();
        View view = new View();
        view.setFlag(true);
        // 로그아웃을 할 경우, 렌더링 되는 화면은 첫 페이지 이므로, index.jsp 로 가게 함.
        view.setResponseJsp("./index.jsp");
        return view;
    }
}
