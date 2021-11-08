package com.simple.userservice.service.impl;

import com.simple.userservice.service.UserService;
import com.simple.common.vo.CommonResult;
import com.simple.common.vo.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public CommonResult create(User user) {
        return new CommonResult(user, "操作成功", 200);
    }

    @Override
    public CommonResult getUser(Long id) {
        User user = new User();
        user.setId(id);
        user.setUsername("simple");
        user.setAge(27);
        user.setAddress("广西桂林市荔浦市");
        return new CommonResult(user, "操作成功", 200);
    }
}
