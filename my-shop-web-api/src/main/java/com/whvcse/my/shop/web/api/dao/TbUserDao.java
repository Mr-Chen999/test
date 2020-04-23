package com.whvcse.my.shop.web.api.dao;

import com.whvcse.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

/**
 * TODO: 会员管理
 *
 * @author JavaMan
 * @date 2020/4/2 21:40
 */
@Repository
public interface TbUserDao {
    /**
     * 登录
     * @param tbUser
     * @return
     */
    TbUser login(TbUser tbUser);

    /**
     * 注册
     * 添加用户
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
