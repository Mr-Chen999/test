package com.whvcse.my.shop.web.api.dao;

import com.whvcse.my.shop.domain.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbContentDao {
    List<TbContent> selectByCategoryId(TbContent tbContent);
}
