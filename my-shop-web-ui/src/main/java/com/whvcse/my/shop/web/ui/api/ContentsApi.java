package com.whvcse.my.shop.web.ui.api;

import com.whvcse.my.shop.commons.utils.HttpClientUtils;
import com.whvcse.my.shop.commons.utils.MapperUtils;
import com.whvcse.my.shop.web.ui.dto.TbContent;

import java.util.List;

/**
 * TODO: 内容管理接口
 *
 * @author JavaMan
 * @date 2020/3/31 15:30
 */
public class ContentsApi {
    /**
     * 请求幻灯片
     * @return
     */
    public static List<TbContent> ppt(){
        List<TbContent> tbContents = null;
        String result = HttpClientUtils.doGet(API.API_CONTENTS_PPT);

        try {
            tbContents = MapperUtils.json2listByTree(result,"data",TbContent.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tbContents;
    }
}
