package com.ricky.dentalClinic.controller;

import com.ricky.dentalClinic.api.CommonResult;
import com.ricky.dentalClinic.mbg.model.TUser;
import com.ricky.dentalClinic.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Api(tags = "UserController", description = "用户管理")
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /*@ApiOperation("用户注册")
    @PostMapping(value = "/register")
    @ResponseBody
    public CommonResult register(@RequestParam(value = "username") String username,
                                 @RequestParam(value = "password") String password,
                                 @RequestParam(value = "telephone") String telephone,
                                 @RequestParam(value = "name") String name,
                                 @RequestParam(value = "sex") String sex){
        userService.register(username, password, telephone, name, sex);
        return CommonResult.success(null, "注册成功");
    }

    @ApiOperation("会员登陆并返回token")
    @PostMapping(value = "/login")
    @ResponseBody
    public CommonResult login(@RequestParam String username,
                              @RequestParam String password) {
        String token = userService.login(username, password);
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }*/

    @ApiOperation("获取用户个人信息")
    @GetMapping("/getPersonalInfo")
    @ResponseBody
    public CommonResult gerPersonalInfo(int id) {
        TUser userInfo = userService.getPersonalInfo(id);
        return CommonResult.success(userInfo);
    }

}
