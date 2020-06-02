package com.evan.wj.controller;

import com.evan.wj.pojo.User;
import com.evan.wj.reult.Result;
import com.evan.wj.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    @CrossOrigin
    public Result login(@RequestBody User user){
        return loginService.login(user);
    }
}
