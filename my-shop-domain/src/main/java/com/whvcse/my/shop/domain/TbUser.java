package com.whvcse.my.shop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.whvcse.my.shop.commons.persistence.BaseEntity;
import com.whvcse.my.shop.commons.utils.RegexpUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

@Data
@EqualsAndHashCode(callSuper = true)
public class TbUser extends BaseEntity {
    @Length(min = 6,max = 20,message = "姓名的长度必须介于 6-20 之间!")
    private String username;
    @JsonIgnore
    @Length(min = 6,max = 30,message = "密码的长度必须介于 6-30 之间!")
    private String password;
    @Pattern(regexp = RegexpUtils.PHONE,message = "手机号码格式不正确!")
    private String phone;
    @Pattern(regexp = RegexpUtils.EMAIL,message = "邮箱格式不正确!")
    private String email;
}
