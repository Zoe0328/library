package com.library.common;

/**
 * Created by zoe on 2018/1/27.
 */
public class Const {
    public static final String CURRENT_USER="currentUser";

    public static final String PHONE="phone";

    //public static final String E = "email";
    public static final String USERNAME = "username";


    public interface Role{
        int ROLE_CUSTOMER=0; //普通用户

        int ROLE_ADMIN=1; //管理员
    }

}
