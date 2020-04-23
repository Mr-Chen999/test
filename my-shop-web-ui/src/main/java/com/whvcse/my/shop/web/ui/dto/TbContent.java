package com.whvcse.my.shop.web.ui.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * TODO: 类描述
 *
 * @author JavaMan
 * @date 2020/3/31 15:24
 */
@Data
public class TbContent implements Serializable {
    private Long id;
    private String title;
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
    private String content;
}
