package com.evan.wj.service;

import com.evan.wj.pojo.User;
import com.evan.wj.reult.Result;

public interface LoginService {
    Result login(User user);
}
