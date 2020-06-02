package com.evan.wj.service.impl;

import com.evan.wj.dao.UserDao;
import com.evan.wj.pojo.User;
import com.evan.wj.reult.Result;
import com.evan.wj.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserDao userDao;

    @Override
    public Result login(User user) {
        String userName = user.getUserName();
        userName = HtmlUtils.htmlEscape(userName);
        User userInfo = userDao.findByUserName(userName);
        if (ObjectUtils.isEmpty(userInfo) || !Objects.equals(userInfo.getUserName(), userName) || !Objects.equals(userInfo.getPassword(), user.getPassword())) {
            return new Result(500,"账号或密码错误",null);
        } else {
            return new Result(200,"登录成功",user);
        }
    }
}
