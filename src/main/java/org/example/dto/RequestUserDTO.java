package org.example.dto;

public class RequestUserDTO {

    private String id;
    private String pwd;
    public RequestUserDTO(){

    }
    public RequestUserDTO(String id, String pwd){
        this.id = id;
        this.pwd = pwd;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }
}
