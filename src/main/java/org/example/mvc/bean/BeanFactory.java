package org.example.mvc.bean;

import org.example.IndexController;
import org.example.fordispatcher.*;
import org.example.mvc.ctrl.*;
import org.example.mvc.model.util.MvcDao;
import org.example.mvc.model.*;
import org.example.mvc.service.util.MvcService;
import org.example.mvc.service.util.MvcServiceImpl;

import java.util.HashMap;
import java.util.Map;

/*
MVC Pattern 에서,
FrontController와 실제 Controller 사이에서 동작한다.
*/
/*
Bean Factory 는 스프링에서 자동으로 관리해주는데,
이때, 싱글톤 패턴이 적용되어 있음.
*/

// BeanFactory는 스프링부트에서 Spring Container가 되고, @Service, @Container, @Repository 들을 관리하는 곳이 Spring Container임.
// 스프링은 기본 생성자를 항상 생성해야함.
public class BeanFactory {

    // 사용자의 request path를 이용해서, return Controller
    // request path는 / 를 포함한다.

    private Map<String, Controller> map;
    private static BeanFactory instance;

    private MvcService service;
    private MvcDao dao;


    // join.hanwha, login.hanwha, update.hanwha, logout.hanwh
    // 싱글톤 패턴을 위해서, Controller에서 생성하는 service 객체도 BeanFactory에서 넣어주는 것이 좋음.
    private BeanFactory() {
        map = new HashMap <String,Controller>();
        dao = new MariaDao();
        // 서비스를 Controller이 아니라,
        service = new MvcServiceImpl(dao);
        // path엔 context path를 포함해야 함.
        map.put("/encore_test_web/join.hanwha",new JoinController(service));
        // 싱글톤 패턴을 적용하기 위해서, BeanFactory에서 생성자를 생성함.
        map.put("/encore_test_web/login.hanwha",new LogInController(service));
        map.put("/encore_test_web/update.hanwha",new UpdateController(service));
        map.put("/encore_test_web/logout.hanwha",new LogOutController(service));
        map.put("/encore_test_web/index.hanwha", new IndexController(service));
        map.put("/encore_test_web/select.hanwha", new SelectController(service));
    }

    // 싱글톤 패턴에서 객체를 넘겨주는 부분
    public static BeanFactory getInstance(){
        if(instance == null){
            instance = new BeanFactory();
        }
        return instance;
    }

    public Controller getCtrl(String clientPath){
        return map.get(clientPath);
    }

}
