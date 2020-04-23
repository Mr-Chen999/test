package com.whvcse.my.shop.web.ui.controller;

import com.whvcse.my.shop.web.ui.api.UsersApi;
import com.whvcse.my.shop.web.ui.dto.TbUser;
import javafx.scene.chart.ValueAxis;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TODO: 注册控制器
 *
 * @author JavaMan
 * @date 2020/4/12 16:23
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterController {
    /**
     * 跳转至注册页面
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String register(){
        return "/register";
    }


    /**
     * 验证用户名是否已被注册
     * @param username
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/repeat",method = RequestMethod.POST)
    public String repeat(@RequestParam("username") String username) throws Exception {
        TbUser tbUser = new TbUser();
        tbUser.setUsername(username);
        //调用api接口获取数据库信息
        TbUser result = UsersApi.repeat(tbUser);
        //如果根据输入的值查到数据库里存在这个用户名，则返回到前台字符串"1",反之则返回"0"
        if (result!=null){
            return "1";
        }
        else {
            return "0";
        }

    }


    /**
     * 会员注册
     * @param tbUser
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "toRegister",method = RequestMethod.POST)
    @ResponseBody
    public String toRegister(TbUser tbUser) throws Exception {
        TbUser user = UsersApi.register(tbUser);
        if (user!=null){
            return "OK";
        }
        return "Fail";
    }
}
