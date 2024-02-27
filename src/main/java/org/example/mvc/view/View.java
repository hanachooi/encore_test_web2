package org.example.mvc.view;

// FrontController인 DispatcherServlet이 화면의 분기방식과 응답 페이지 정보를 반환 받을 수 있도록
// view.java 역할
public class View {

    private String responseJsp;     // 응답페이지 정보
    private boolean isFlag;     // true -> forward, false -> redirect

    public void View(){

    }

    public void setResponseJsp(String responseJsp) {
        this.responseJsp = responseJsp;
    }

    public void setFlag(boolean flag) {
        isFlag = flag;
    }

    public String getResponseJsp() {
        return responseJsp;
    }

    public boolean isFlag() {
        return isFlag;
    }
}
