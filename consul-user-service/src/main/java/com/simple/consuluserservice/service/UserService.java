package com.simple.consuluserservice.service;


import com.simple.common.vo.CommonResult;
import com.simple.common.vo.User;

public interface UserService {
    public CommonResult create(User user);
    public CommonResult getUser(Long id);
}
