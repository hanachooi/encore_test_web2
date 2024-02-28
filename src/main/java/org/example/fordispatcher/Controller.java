package org.example.fordispatcher;

import org.example.mvc.view.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

    // Controller에서는
    public View execute(HttpServletRequest req, HttpServletResponse resp);

}
