package com.neu.edu.backend.controller;

import com.neu.edu.backend.result.Result;
import com.neu.edu.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
import com.neu.edu.backend.pojo.UserEntity;

import java.util.List;


@Controller
public class UserController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "/api/login")
    @ResponseBody
    public Result login(@RequestBody UserEntity requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        UserEntity user = userService.get(username, requestUser.getPassword());
        if (user.getAuthority()==1){
            return new Result(100,user.getId());
        }else if(user.getAuthority()==2){
            return new Result(200,user.getId());
        }else {
            return new Result(404,404);
        }

    }


    @CrossOrigin
    @GetMapping(value = "/api/doctor")
    @ResponseBody
    public List<UserEntity> doctorList() throws Exception{
        return userService.getAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/api/doctor/select")
    @ResponseBody
    public List<UserEntity> doctorSelectList(String departmentId,String registrationLevel) throws Exception{
        return userService.getByDepAndReg(departmentId,registrationLevel);
    }

}



