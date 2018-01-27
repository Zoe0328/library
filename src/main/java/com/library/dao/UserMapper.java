package com.library.dao;

import com.library.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.method.P;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int checkByUserName(String username);

    int checkByPhone(String phone);

    User selectLogin(@Param("username") String username, @Param("password") String password);
}