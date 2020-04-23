package com.whvcse.my.shop.web.ui.interceptor;

import com.whvcse.my.shop.web.ui.constant.SystemConstants;
import com.whvcse.my.shop.web.ui.dto.TbUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TODO: 登录拦截器
 *
 * @author JavaMan
 * @date 2020/4/3 15:09
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //获取session对象
        TbUser tbUser = (TbUser) httpServletRequest.getSession().getAttribute(SystemConstants.SESSION_USER_KEY);

        //session为空，未登录状态
        if (tbUser==null){

            return true;
        }
        //session不为空,登录状态
        else {
            //重定向回主页
            httpServletResponse.sendRedirect("/index");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
