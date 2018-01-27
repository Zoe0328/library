package com.library.service;

import com.library.common.ServerResponse;
import com.library.dao.UserMapper;
import com.library.pojo.User;

import javax.servlet.http.HttpSession;

/**
 * Created by zoe on 2018/1/27.
 */
public interface IUserService {
    public ServerResponse login(String username, String password);
    public ServerResponse<String> register(User user);
    public ServerResponse<String> checkValid(String str,String type);




}
