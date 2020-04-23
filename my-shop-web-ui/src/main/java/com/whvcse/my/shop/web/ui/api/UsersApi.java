package com.whvcse.my.shop.web.ui.api;

import com.whvcse.my.shop.commons.dto.BaseResult;
import com.whvcse.my.shop.commons.utils.HttpClientUtils;
import com.whvcse.my.shop.commons.utils.MapperUtils;
import com.whvcse.my.shop.web.ui.dto.TbUser;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: 会员管理接口
 *
 * @author JavaMan
 * @date 2020/4/3 12:46
 */
public class UsersApi {
    //会员登录
    public static TbUser login(TbUser tbUser) throws Exception {

        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("username",tbUser.getUsername()));
        params.add(new BasicNameValuePair("password",tbUser.getPassword()));
        //将集合转换成数组进行doPost请求
        String json = HttpClientUtils.doPost(API.API_USERS_LOGIN, params.toArray(new BasicNameValuePair[params.size()]));
        TbUser user = MapperUtils.json2pojoByTree(json, "data", TbUser.class);
        return user;
    }

    /**
     * 会员名注册验证是否已被注册
     * @param tbUser
     * @return
     */
    public static TbUser repeat(TbUser tbUser) throws Exception {
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("username",tbUser.getUsername()));
        String json = HttpClientUtils.doPost(API.API_USERS_REPEAT,params.toArray(new BasicNameValuePair[params.size()]));
        TbUser user = MapperUtils.json2pojoByTree(json,"data",TbUser.class);
        return user;
    }

    //会员注册
    public static TbUser register(TbUser tbUser) throws Exception {
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("username",tbUser.getUsername()));
        params.add(new BasicNameValuePair("password",tbUser.getPassword()));
        params.add(new BasicNameValuePair("phone",tbUser.getPhone()));
        String json = HttpClientUtils.doPost(API.API_USERS_REGISTER,params.toArray(new BasicNameValuePair[params.size()]));
        TbUser user = MapperUtils.json2pojoByTree(json,"data",TbUser.class);
        return user;
    }

}
