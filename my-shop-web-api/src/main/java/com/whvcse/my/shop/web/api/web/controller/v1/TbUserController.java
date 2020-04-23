package com.whvcse.my.shop.web.api.web.controller.v1;

import com.whvcse.my.shop.commons.dto.BaseResult;
import com.whvcse.my.shop.domain.TbUser;
import com.whvcse.my.shop.web.api.service.TbUserService;
import com.whvcse.my.shop.web.api.web.dto.TbUserDTO;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * TODO: 会员管理
 *
 * @author JavaMan
 * @date 2020/4/2 21:50
 */
@RestController
@RequestMapping(value = "${api.path.v1}/users")
public class TbUserController {

    @Autowired
    private TbUserService tbUserService;

    /**
     * 登录
     * @param tbUser
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public BaseResult login(TbUser tbUser){
        TbUser user = tbUserService.login(tbUser);
        System.out.println(user);
        if (user == null){
            return BaseResult.fail("用户名或密码错误！请重新输入！");
        }

        else{
            TbUserDTO dto = new TbUserDTO();
            BeanUtils.copyProperties(user,dto);
            return BaseResult.success("成功",dto);
        }
    }



    @RequestMapping(value = "repeat",method = RequestMethod.POST)
    public BaseResult findByName(TbUser tbUser) {
        String username = tbUser.getUsername();
        TbUser user = tbUserService.findByName(username);
        if (user != null) {
            TbUserDTO dto = new TbUserDTO();
            BeanUtils.copyProperties(user,dto);
            return BaseResult.success("用户名已存在，请重新输入",dto);
        }
        else {
            return BaseResult.success("成功");
        }

    }



    @RequestMapping(value = "register",method = RequestMethod.POST)
    public BaseResult register(TbUser tbUser){
        if (!tbUser.equals(null)){
            tbUser.setCreated(new Date());
            tbUser.setUpdated(new Date());
            //密码进行md5加密
            tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
            tbUserService.insert(tbUser);
            TbUserDTO dto = new TbUserDTO();
            BeanUtils.copyProperties(tbUser,dto);
            return BaseResult.success("OK",dto);
        }
        else {
            return BaseResult.fail("用户名创建失败");
        }
    }
}
