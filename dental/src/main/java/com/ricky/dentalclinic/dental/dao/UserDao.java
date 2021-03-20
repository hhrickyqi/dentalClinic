package com.ricky.dentalclinic.dental.dao;

import com.ricky.dentalclinic.dental.domain.UserQueryParam;
import com.ricky.dentalclinic.dental.mbg.model.TUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    TUser getUser(@Param("username") String username);

    List<TUser> listUser(@Param("queryParam") UserQueryParam queryParam);
}
