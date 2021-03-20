package com.ricky.dentalclinic.dental.service;


import com.ricky.dentalclinic.dental.domain.UserInfoParam;
import com.ricky.dentalclinic.dental.domain.UserQueryParam;
import com.ricky.dentalclinic.dental.mbg.model.TUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    /*
    获取用户信息
     */
    TUser getPersonalInfo(int id);
    /*
     用户注册
     */
    @Transactional
    void register(String username, String password, String telephone, String name, String sex);

    /**
     * 登录后获取token
     */
    String login(String username, String password);

    /**
     * 刷新token
     */
    String refreshToken(String token);

    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);

    /*
    登陆后修改密码
     */
    int easyUpdatePassword(int id, String password);
    /*
    登陆后修改个人信息
     */
    int updateInfo(UserInfoParam userInfo);
    /**
     * 获取当前登录用户
     */
    TUser getCurrentInfo();
    /**
     * 查询用户列表
     */
    List<TUser> listUser(UserQueryParam queryParam, Integer pageSize, Integer pageNum);
    /**
     * 删除用户
     */
    int deleteUser(int id);
    /**
     * 修改用户类型
     */
    int modifyUserPermissions(int id, int type);
}
