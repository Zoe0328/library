package com.library.controller;

import com.library.common.Const;
import com.library.common.ServerResponse;
import com.library.pojo.User;
import com.library.service.IUserService;
import com.library.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by zoe on 2018/1/27.
 */

@Controller
@RequestMapping("/user/")
public class UserController {
    /**
     * 用户登录
     * @param name
     * @param password
     * @param session
     * @return
     */

   @Autowired
   private IUserService iUserService;

    @RequestMapping(value="login.do",method = RequestMethod.POST)
    @ResponseBody

    public ServerResponse<User> login(String username, String password, HttpSession session){

        ServerResponse<User> response=iUserService.login(username,password);
        if (response.isSuccess())
        {
            session.setAttribute(Const.CURRENT_USER,response.getData());

        }


        return  response;



    }

    @RequestMapping(value="logout.do",method = RequestMethod.GET)
    @ResponseBody


    public ServerResponse<String> logout(HttpSession session){
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }


    @RequestMapping(value="register.do",method = RequestMethod.GET)
    @ResponseBody


    public ServerResponse<String> register(User user){
        return iUserService.register(user);


    }

    @RequestMapping(value="check_valid.do",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> checkValid(String str,String type){


        return iUserService.checkValid(str,type);


    }



    public ServerResponse<User> getUserInfo(HttpSession session) {

        User user= (User) session.getAttribute(Const.CURRENT_USER);
        if (user!=null)
        {
            return ServerResponse.createBySuccess(user);

        }
        return ServerResponse.createByErrorMessage("用户未登录，无法获取当前用户信息");
    }

    }
