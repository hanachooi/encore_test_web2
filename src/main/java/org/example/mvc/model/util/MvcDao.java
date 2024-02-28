package org.example.mvc.model.util;

import org.example.dto.RequestUserDTO;
import org.example.dto.ResponseUserDTO;

import java.util.List;

// DML (insert, update, delete) - executeUpdate() : int
// select - executeQuery() : ResultSet
public interface MvcDao {

    public void joinRow();
    public ResponseUserDTO loginRow(RequestUserDTO dto);
    public void updateRow();
    public void deleteRow();
    public List<ResponseUserDTO> selectRow();

}
