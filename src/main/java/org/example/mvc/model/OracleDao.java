package org.example.mvc.model;

import org.example.dto.RequestUserDTO;
import org.example.dto.ResponseUserDTO;
import org.example.mvc.model.util.MvcDao;

import java.util.List;

public class OracleDao implements MvcDao {


    @Override
    public void joinRow() {
        System.out.println("debug >>> OracleDB joinRow()");
    }

    @Override
    public ResponseUserDTO loginRow(RequestUserDTO dto) {
        System.out.println("debug >>> OracleDB loginRow()");
        ResponseUserDTO user = new ResponseUserDTO("jslim", "jslim", "d");


        return user;
    }

    @Override
    public void updateRow() {
        System.out.println("debug >>> OracleDB updateRow()");
    }

    @Override
    public void deleteRow() {
        System.out.println("debug >>> OracleDB deleteRow()");
    }

    @Override
    public List<ResponseUserDTO> selectRow() {
        return null;
    }
}
