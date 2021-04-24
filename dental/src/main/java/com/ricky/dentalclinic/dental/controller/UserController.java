package com.ricky.dentalclinic.dental.controller;

import com.ricky.dentalclinic.dental.api.CommonPage;
import com.ricky.dentalclinic.dental.api.CommonResult;
import com.ricky.dentalclinic.dental.domain.CaseQueryParam;
import com.ricky.dentalclinic.dental.domain.UserInfoParam;
import com.ricky.dentalclinic.dental.domain.UserQueryParam;
import com.ricky.dentalclinic.dental.mbg.model.TCase;
import com.ricky.dentalclinic.dental.mbg.model.TUser;
import com.ricky.dentalclinic.dental.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Api(tags = "UserController", description = "用户管理")
@Controller
@RequestMapping("/user")
public class UserController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private UserService userService;

    @ApiOperation("用户注册")
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
    }

    @ApiOperation(value = "刷新token")
    @RequestMapping(value = "/refreshToken", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = userService.refreshToken(token);
        if (refreshToken == null) {
            return CommonResult.failed("token已经过期！");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation("登陆后修改密码")
    @RequestMapping(value = "/easyUpdatePassword", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult easyUpdatePassword(@RequestParam int id,
                                           @RequestParam String password) {
        int count = userService.easyUpdatePassword(id, password);
        if (count > 0) {
            return CommonResult.success(count,"密码修改成功");
        }
        return CommonResult.failed();
    }

    @ApiOperation(value = "登出功能")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult logout() {

        return CommonResult.success(null);
    }

    @ApiOperation("获取用户个人信息")
    @GetMapping("/getPersonalInfo")
    @ResponseBody
    public CommonResult gerPersonalInfo(int id) {
        TUser userInfo = userService.getPersonalInfo(id);
        return CommonResult.success(userInfo);
    }

    @ApiOperation("修改个人信息")
    @PostMapping("/updateInfo")
    @ResponseBody
    public CommonResult updateInfo(@RequestBody UserInfoParam userInfo) {
        int count = userService.updateInfo(userInfo);
        if (count > 0) {
            return CommonResult.success(count,"修改成功");
        }
        return CommonResult.failed();
    }

    @ApiOperation("获取登录用户信息")
    @RequestMapping(value = "/getCurrentInfo", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getCurrentInfo(Principal principal) {
        if (principal == null) {
            return CommonResult.unauthorized(null);
        }
        TUser user = userService.getCurrentInfo();
        return CommonResult.success(user);
    }

    @ApiOperation("查询用户列表")
    @RequestMapping(value = "/listUser", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<TUser>> list(UserQueryParam queryParam,
                                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<TUser> userList = userService.listUser(queryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(userList));
    }

    @ApiOperation("删除用户")
    @PostMapping("/deleteUser")
    @ResponseBody
    public CommonResult deleteUser(@RequestParam int id) {
        int count = userService.deleteUser(id);
        if (count > 0) {
            return CommonResult.success(count,"删除成功");
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改用户类型")
    @PostMapping("/modifyUserPermissions")
    @ResponseBody
    public CommonResult modifyUserPermissions(@RequestParam int id,
                                              @RequestParam int type) {
        int count = userService.modifyUserPermissions(id, type);
        if (count > 0) {
            return CommonResult.success(count,"修改成功");
        }
        return CommonResult.failed();
    }
}
