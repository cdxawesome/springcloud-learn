package com.simple.consuluserservice.controller;

import com.simple.common.vo.CommonResult;
import com.simple.common.vo.User;
import com.simple.consuluserservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {
    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public CommonResult create(@RequestBody User user) {
        userService.create(user);
        return new CommonResult(null, "操作成功", 200);
    }

    @GetMapping("/{id}")
    public CommonResult getUser(@PathVariable Long id) {
        CommonResult commonResult = userService.getUser(id);
        User user = (User) commonResult.getData();
        LOGGER.info("根据id获取用户信息，用户名称为：{}", user.getUsername());
        return commonResult;
    }
}
