package com.simple.feignservice.service;

import com.simple.common.vo.CommonResult;
import com.simple.common.vo.User;
import org.springframework.stereotype.Component;

@Component
public class UserFallbackService implements UserService {
    @Override
    public CommonResult create(User user) {
        User defaultUser = new User(-1L, "defaultUser", 20, "北京市");
        return new CommonResult(defaultUser, "操作成功", 200);
    }

    @Override
    public CommonResult getUser(Long id) {
        User defaultUser = new User(-1L, "defaultUser", 20, "北京市");
        return new CommonResult(defaultUser, "操作成功", 200);
    }
}
