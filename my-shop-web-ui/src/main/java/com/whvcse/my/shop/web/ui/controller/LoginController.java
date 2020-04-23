package com.whvcse.my.shop.web.ui.controller;

import com.google.code.kaptcha.Constants;
import com.whvcse.my.shop.commons.dto.BaseResult;
import com.whvcse.my.shop.commons.utils.EmailSendUtils;
import com.whvcse.my.shop.web.ui.api.UsersApi;
import com.whvcse.my.shop.web.ui.dto.TbUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

import static com.whvcse.my.shop.web.ui.constant.SystemConstants.SESSION_USER_KEY;

/**
 * TODO: 会员控制器
 *
 * @author JavaMan
 * @date 2020/4/3 12:22
 */
@Controller
public class LoginController {
    /**
     * 跳转登录页
     * @return
     */

    @Autowired
    private EmailSendUtils emailSendUtils;
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        return "/login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(TbUser tbUser, Model model, HttpServletRequest request) throws Exception {
        if (!checkVerification(request,tbUser)){
            model.addAttribute("baseResult",BaseResult.fail("验证码输入有误！请重新输入！"));
            return "login";
        }

        TbUser user = UsersApi.login(tbUser);
        System.out.println(user);
        //登录失败
        if (user == null){

            BaseResult baseResult = BaseResult.fail("账号或密码错误！请重新输入！");
            model.addAttribute("baseResult",baseResult);
            return "/login";
        }
        //登录成功
        else {
            //发送邮件
            emailSendUtils.send("欢迎光临",String.format("尊敬的【%s】,欢迎登录MyShop购物商城！OVO",user.getUsername()),"1343580315@qq.com");
            //将会员信息存入session
            request.getSession().setAttribute(SESSION_USER_KEY,user);
            return "redirect:/index";
        }


    }

    /**
     * 注销
     * @param request
     * @return
     */
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        //清除session
        request.getSession().invalidate();
        return "redirect:/index";
    }

    /**
     * 校验验证码
     * @param request
     * @param tbUser
     * @return
     */
    public boolean checkVerification(HttpServletRequest request,TbUser tbUser){
        //获取session中的key
        String verification  = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        //验证码正确
        if (StringUtils.equals(verification,tbUser.getVerification())){
            return true;
        }
        //验证码错误
        else {
            return false;
        }
    }
}
