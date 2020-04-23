package com.whvcse.my.shop.web.ui.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

/**
 * TODO: 会员
 *
 * @author JavaMan
 * @date 2020/4/3 12:18
 */
@Data
public class TbUser implements Serializable {
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    private String phone;
    private String email;
    private String verification;
}
