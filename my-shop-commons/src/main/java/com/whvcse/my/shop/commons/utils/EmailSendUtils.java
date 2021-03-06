package com.whvcse.my.shop.commons.utils;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * TODO: 邮件发送工具类
 *
 * @author JavaMan
 * @date 2020/4/5 14:25
 */
public class EmailSendUtils {
    @Autowired
    private Email email;


    public void send(String subject,String msg,String ...to) throws EmailException {
        email.setSubject(subject);
        email.setMsg(msg);
        email.addTo(to);
        email.send();
    }

}
