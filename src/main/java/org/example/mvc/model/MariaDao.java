package org.example.mvc.model;

import org.example.dto.RequestUserDTO;
import org.example.dto.ResponseUserDTO;
import org.example.mvc.model.util.MvcDao;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// dao 에서 db 접근 ( 자바 때 코드 참조 )
public class MariaDao implements MvcDao {

    // url, druver, ud, pwd
    // mariadb의 url, driver, id, password 정보를 입력
    // jdbc 사용
    private static final String URL = "jdbc:mariadb://localhost:3306/encore";
    private static final String DRIVER = "org.mariadb.jdbc.Driver";
    private static final  String ID = "root";
    private static final  String PASSWORD = "netdb3230";

    public MariaDao() {
        try {
            // 드라이버 로딩 시작 부분
            // Dao 생성자 호츨 시, 드라이버 로딩
            Class.forName(DRIVER) ;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void joinRow() {
        System.out.println("debug >>> MariaDB joinRow()");
    }

    @Override
    public ResponseUserDTO loginRow(RequestUserDTO dto) {
        // dao의 dto 까지 값을 넣게 됌.
        System.out.println("debug >>> MariaDB loginRow()");
        System.out.println("debug >>> MariaDB id : " + dto.getId());
        System.out.println("debug >>> MariaDB pwd : " + dto.getPwd());

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        // 동적 바인딩
        String sql = "select * from encore_user_tbl where id = ? and pwd = ?";
        ResponseUserDTO user = null;
        try{
            conn = DriverManager.getConnection(URL, ID, PASSWORD);
            // dbms 는 sql의 결과를 테이블로 관리.
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getId());
            pstmt.setString(2, dto.getPwd());
            // rset에 sql 이 결과값인 테이블이 담기게 된다. 이를, dto에 담아야 함.
            rset = pstmt.executeQuery();

            // 디비를 한줄씩 있는지 확인
            while(rset.next()){
               user = new ResponseUserDTO(rset.getString(1), rset.getString(2), rset.getString(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            // 예외 여부 상관없이 실행됌.
            try{
                if(conn != null){ conn.close();}
            }catch (Exception e){

            }
        }

        // SQL : select * from table where id = params.getId() and params.getPwd();
        //user = new ResponseUserDTO("jslim", "jslim", "d");


        return user;
    }

    @Override
    public void updateRow() {
        System.out.println("debug >>> MariaDB updateRow()");
    }

    @Override
    public void deleteRow() {
        System.out.println("debug >>> MariaDB deleteRow()");
    }

    @Override
    public List<ResponseUserDTO> selectRow() {

        System.out.println("debug >>> MariaDB selectRow()");

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        // 동적 바인딩
        String sql = "select * from encore_user_tbl";
        // list 값을 할당
        List<ResponseUserDTO> userList = new ArrayList<ResponseUserDTO>();
        try{
            conn = DriverManager.getConnection(URL, ID, PASSWORD);
            // dbms 는 sql의 결과를 테이블로 관리.
            pstmt = conn.prepareStatement(sql);
            // rset에 sql 이 결과값인 테이블이 담기게 된다. 이를, dto에 담아야 함.
            rset = pstmt.executeQuery();

            // 디비를 한줄씩 있는지 확인
            while(rset.next()){
                // 리스트에 값을 넣을때는, ResponseUserDTO를 지역 변수로 받고, list 에 넣어주는 것이 좋다.
                ResponseUserDTO user = new ResponseUserDTO(rset.getString(1), rset.getString(2), rset.getString(3));
                userList.add(user);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            // 예외 여부 상관없이 실행됌.
            try{
                if(conn != null){ conn.close();}
            }catch (Exception e){

            }
        }

        return userList;
    }

}
