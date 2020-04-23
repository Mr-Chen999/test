package com.whvcse.my.shop.web.admin.dao;

import com.whvcse.my.shop.commons.persistence.BaseDao;
import com.whvcse.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

@Repository
public interface TbUserDao extends BaseDao<TbUser> {
    /**
     * 根据邮箱查询用户信息
     *
     * @param email
     * @return
     */
    TbUser getByEmail(String email);
}
