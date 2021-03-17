package com.ricky.dentalclinic.dental.service;


import com.ricky.dentalclinic.dental.mbg.model.TUser;

public interface UserService {
    /*
    获取用户信息
     */
    TUser getPersonalInfo(int id);
    /**
     * 用户注册
    @Transactional
    void register(String username, String password, String telephone, String name, String sex);

    *//**
     * 登录后获取token
     *//*
    String login(String username, String password);*/
}
