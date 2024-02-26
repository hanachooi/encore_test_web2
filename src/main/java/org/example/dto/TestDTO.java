package org.example.dto;

// DTO == Entity
//
public class TestDTO {
    private String id;
    private String pwd;
    private String name;
    public TestDTO(){
        super();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

    public String getName() {
        return name;
    }
}
