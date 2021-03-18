package com.ricky.dentalclinic.dental.dao;

import com.ricky.dentalclinic.dental.mbg.model.TUser;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    TUser getUser(@Param("username") String username);
}
