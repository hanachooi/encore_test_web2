package org.example.fordispatcher;

import org.example.mvc.bean.BeanFactory;
import org.example.mvc.view.View;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// dispatcherController는 Get과 Post 방식을 모두 가지고 있어야 함.
// DispatcherController 는 프론트 컨트롤러로 사용자의 모든 요청이 여기로 모이게 됌.
// .hanwha 인 url 이면 모두 이 프론트컨트롤러로 연결 됌
// Factory 에서 요청을 처리해주는 Controller를 찾아서, dispatcher에 리턴을 해줌.
// 응답 : Controller는 View를 서블릿에 반환해주면, Servlet이 화면을 렌더링.

// 이게 서블릿의 역할.
@WebServlet("*.hanwha")
public class DispatcherController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("debug >>> FrontController process");
        System.out.println("client request path : " + req.getRequestURL());
        // BeanFactory 객체 싱글톤이 적용되기 위해서, 객체를 getInstance()로 넘겨줌.
        BeanFactory factory = BeanFactory.getInstance();
        Controller controller = factory.getCtrl(req.getRequestURI());
        // 실행되어야 할 jsp가 넘겨져야 함.
        View view = controller.execute(req, resp);

        /* 아래의 코드는 고정. getRequestDispatcher 안에, .jsp 파일이 들어가야 하는데, 이를 Controller를 골라온
        dispatcher의 반환값인 View를 넣고, 해당 View의 jsp 파일을 가져옴.
        RequestDispatcher dispatcherView = req.getRequestDispatcher(view.getResponseJsp());
        dispatcherView.forward(req, resp);
        */


        RequestDispatcher dispatcherView = req.getRequestDispatcher(view.getResponseJsp());
        dispatcherView.forward(req, resp);
        if (view.isFlag()){
            RequestDispatcher rd = req.getRequestDispatcher(view.getResponseJsp());
            rd.forward(req,resp);

        }else{
            resp.sendRedirect(view.getResponseJsp());
        }
    }
}
