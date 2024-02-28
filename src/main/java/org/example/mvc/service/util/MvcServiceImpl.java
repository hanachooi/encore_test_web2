package org.example.mvc.service.util;

import org.example.dto.RequestUserDTO;
import org.example.dto.ResponseUserDTO;
import org.example.mvc.model.util.MvcDao;

import java.util.List;

public class MvcServiceImpl implements MvcService{

    private MvcDao dao;

    public MvcServiceImpl(){
        // 스프링은 기본 생성자가 항상 생성되어 있어야 한다.
    }

    public MvcServiceImpl(MvcDao dao){
        this.dao = dao;
    }

    @Override
    public void join() {
        System.out.println("debug >>> service join() ");
        dao.joinRow();
    }

    @Override
    public ResponseUserDTO login(RequestUserDTO dto) {
        System.out.println("debug >>> service login() ");
        // 로그인이 dao 에 dto 를 저장하게 됌.
        return dao.loginRow(dto);
    }

    @Override
    public void update() {
        System.out.println("debug >>> service update() ");
        dao.updateRow();
    }

    @Override
    public void logout() {
        System.out.println("debug >>> service.logout() ");
        dao.deleteRow();
    }

    public List<ResponseUserDTO> select(){
        System.out.println();
        return dao.selectRow();
    }
}
