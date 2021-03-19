package com.ricky.dentalclinic.dental.service.impl;

import com.ricky.dentalclinic.dental.dao.UserDao;
import com.ricky.dentalclinic.dental.domain.AdminUserDetails;
import com.ricky.dentalclinic.dental.exception.Asserts;
import com.ricky.dentalclinic.dental.mbg.mapper.TUserMapper;
import com.ricky.dentalclinic.dental.mbg.model.TUser;
import com.ricky.dentalclinic.dental.mbg.model.TUserExample;
import com.ricky.dentalclinic.dental.service.UserService;
import com.ricky.dentalclinic.security.util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private TUserMapper userMapper;
    @Autowired
    private UserDao userDao;

    @Override
    public TUser getPersonalInfo(int id) {
        TUser userInfo = userMapper.selectByPrimaryKey(id);
        return userInfo;
    }

    @Override
    public void register(String username, String password, String telephone, String name, String sex) {
        //查询是否已有该用户
        TUserExample example = new TUserExample();
        example.createCriteria().andUsernameEqualTo(username);
        example.or(example.createCriteria().andPhoneNumberEqualTo(telephone));
        List<TUser> users = userMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(users)){
            Asserts.fail("该用户已存在！");
        }
        //没有该用户进行添加操作
        TUser user = new TUser();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setSex(sex);
        user.setName(name);
        user.setIcon("uploads/icon/defaultIcon.png");
        user.setPhoneNumber(telephone);
        user.setCreateTime(new Date());
        user.setType(0);
        user.setIsDelete(0);
        userMapper.insert(user);
        user.setPassword(null);
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码错误");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            LOGGER.warn("登陆异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public String refreshToken(String token) {
        return jwtTokenUtil.refreshHeadToken(token);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        TUser user = getByUsername(username);
        if (user != null) {
            return new AdminUserDetails(user);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    @Override
    public int easyUpdatePassword(int id, String password) {
        TUser user = userMapper.selectByPrimaryKey(id);
        user.setPassword(passwordEncoder.encode(password));
        return userMapper.updateByPrimaryKeySelective(user);
    }

    private TUser getByUsername(String username) {
        TUser user = userDao.getUser(username);
        if (user != null) return user;
        return null;
    }
}
