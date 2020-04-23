package com.whvcse.my.shop.web.ui.api;

/**
 * TODO: API接口常量
 *
 * @author JavaMan
 * @date 2020/3/31 15:17
 */
public class API {
    // 主机地址
    public static final String HOST = "http://localhost:8081/api/v1";

    // 内容查询接口 - 幻灯片
    public static final String API_CONTENTS_PPT = HOST + "/contents/ppt";

    // 会员管理接口 - 登录
    public static final String API_USERS_LOGIN = HOST + "/users/login";

    //会员注册接口 —去重
    public static final String API_USERS_REPEAT = HOST + "/users/repeat";

    //会员注册接口 —注册
    public static final String API_USERS_REGISTER = HOST + "/users/register";
}
