package com.ricky.dentalclinic.dental.service.impl;

import com.ricky.dentalclinic.dental.mbg.mapper.TUserMapper;
import com.ricky.dentalclinic.dental.mbg.model.TUser;
import com.ricky.dentalclinic.dental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TUserMapper userMapper;

    @Override
    public TUser getPersonalInfo(int id) {
        TUser userInfo = userMapper.selectByPrimaryKey(id);
        return userInfo;
    }
    /*@Override
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
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
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
    }*/
}
