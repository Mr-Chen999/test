package com.whvcse.my.shop.web.api.service;

import com.whvcse.my.shop.domain.TbUser;

/**
 * TODO: 会员管理
 *
 * @author JavaMan
 * @date 2020/4/2 21:41
 */
public interface TbUserService {
    /**
     * 登录
     * @param tbUser
     * @return
     */
    TbUser login(TbUser tbUser);

    /**
     * 注册
     * @param tbUser
     */
    void insert(TbUser tbUser);

    /**
     * 注册
     * 验证用户名是否重复
     * @param name
     * @return
     */
    TbUser findByName(String name);
}
