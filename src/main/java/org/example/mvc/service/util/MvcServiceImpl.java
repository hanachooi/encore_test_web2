package org.example.mvc.service.util;

public class MvcServiceImpl implements MvcService{

    @Override
    public void join() {
        System.out.println("debug >>> service join() ");
    }

    @Override
    public void login() {
        System.out.println("debug >>> service login() ");
    }

    @Override
    public void update() {
        System.out.println("debug >>> service update() ");
    }

    @Override
    public void logout() {
        System.out.println("debug >>> service.logout() ");
    }
}
