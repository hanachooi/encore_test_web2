package org.example.mvc.service.util;

import org.example.dto.RequestUserDTO;
import org.example.dto.ResponseUserDTO;

import java.util.List;

public interface MvcService {

    public void join();
    public ResponseUserDTO login(RequestUserDTO params);
    public void update();
    public void logout();

    ////
    public List<ResponseUserDTO> select();
}
