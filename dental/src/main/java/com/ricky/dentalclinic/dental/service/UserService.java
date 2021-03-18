package com.ricky.dentalclinic.dental.service;


import com.ricky.dentalclinic.dental.mbg.model.TUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

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
}
