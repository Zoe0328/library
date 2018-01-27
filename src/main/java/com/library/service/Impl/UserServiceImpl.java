package com.library.service.Impl;

import com.library.common.ServerResponse;
import com.library.common.Const;
import com.library.dao.UserMapper;
import com.library.pojo.User;
import com.library.service.IUserService;
import com.library.utils.MD5Util;
import org.apache.commons.lang3.StringUtils;
//import org.apache.tomcat.util.bcel.Const;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.*;
import org.springframework.stereotype.Service;
import sun.security.provider.MD5;

import javax.servlet.http.HttpSession;
//import org.springframework.util.StringUtils;

/**
 * Created by zoe on 2018/1/27.
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public ServerResponse<User> login(String username, String password) {
        int resultCount = userMapper.checkByUserName(username);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("用户名不存在");

        }

        //MD5 password

        String md5pw = MD5Util.MD5EncodeUtf8(password);

        User user = userMapper.selectLogin(username, md5pw);
        if (user == null) {
            return ServerResponse.createByErrorMessage("密码错误");

        }

        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登录成功", user);


    }

    public ServerResponse<String> register(User user) {
       ServerResponse validResponse=checkValid(user.getName(),Const.USERNAME);
        if (!validResponse.isSuccess()){
            return validResponse;
        }

       validResponse=checkValid(user.getPhone(),Const.PHONE);
        if (!validResponse.isSuccess()){
            return validResponse;
        }
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
        int insertCount = userMapper.insert(user);
        if (insertCount == 0) {
            return ServerResponse.createByErrorMessage("注册失败");

        }


        return ServerResponse.createBySuccess("注册成功");


    }


    public ServerResponse<String> checkValid(String str, String type) {

        if (!StringUtils.isBlank(type)) {
            //type不等于空开始校验

            if (Const.USERNAME.equals(type))

            {
                int resultCount = userMapper.checkByUserName(str);

                if (resultCount > 0) {
                    return ServerResponse.createByErrorMessage("用户已存在");


                }
                if (Const.PHONE.equals(type))

                {
                    resultCount = userMapper.checkByPhone(str);

                    if (resultCount > 0) {

                    }
                    return ServerResponse.createByErrorMessage("该手机号已存在");
                }
            }
        }
        return ServerResponse.createBySuccess();
    }



}