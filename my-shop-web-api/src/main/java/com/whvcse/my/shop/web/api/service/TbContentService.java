package com.whvcse.my.shop.web.api.service;

import com.whvcse.my.shop.domain.TbContent;

import java.util.List;

public interface TbContentService {
    List<TbContent> selectByCategoryId(Long categoryId);
}
