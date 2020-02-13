package com.neu.edu.backend.result;

public class Result {
    //响应码
    private int code;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Result(int code,int id) {
        this.code = code;
        this.id=id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}

