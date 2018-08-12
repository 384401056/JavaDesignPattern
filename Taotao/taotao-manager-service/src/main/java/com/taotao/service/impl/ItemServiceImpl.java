package com.taotao.service.impl;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 商品管理的Service
 * Created by Administrator on 2018/8/12.
 */
public class ItemServiceImpl implements ItemService {

    @Autowired
    TbItemMapper itemMapper;

    @Override
    public TbItem getItemById(long itemId) {
        //使用mybatis查询数据
        TbItem item = itemMapper.selectByPrimaryKey(itemId);
        return item;
    }
}
