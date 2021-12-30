package com.wangyunqi.controller;


import com.wangyunqi.common.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api(tags = "用户注册登录等接口")
@Slf4j
public class UserController {

    @ApiOperation("用户注册")
    @PostMapping("/sign/in")
    public Result<Object> signIn(@RequestBody @Validated Object dto) {
        return Result.success("测试成功");
    }
}
