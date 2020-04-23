package com.whvcse.my.shop.web.api.service.impl;

import com.whvcse.my.shop.domain.TbUser;
import com.whvcse.my.shop.web.api.dao.TbUserDao;
import com.whvcse.my.shop.web.api.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * TODO: 类描述
 *
 * @author JavaMan
 * @date 2020/4/2 21:42
 */
@Service
public class TbUserServiceImpl implements TbUserService {
    @Autowired
    private TbUserDao tbUserDao;
    @Override
    public TbUser login(TbUser tbUser) {
        TbUser user = tbUserDao.login(tbUser);

        if (user!=null){
            //将明文密码转为md5密码
            String password = DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes());

            if (password.equals(user.getPassword())){
                return user;
            }
        }
        return null;
    }

    @Override
    public void insert(TbUser tbUser) {

        tbUserDao.insert(tbUser);

    }

    @Override
    public TbUser findByName(String name) {
        return tbUserDao.findByName(name);
    }
}
