package com.whvcse.my.shop.web.api.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

/**
 * TODO: 会员用户传输对象
 *
 * @author JavaMan
 * @date 2020/4/3 12:16
 */
@Data
public class TbUserDTO implements Serializable {
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    private String phone;
    private String email;
}
