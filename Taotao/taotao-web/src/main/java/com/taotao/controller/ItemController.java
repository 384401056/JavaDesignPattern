package com.taotao.controller;

import com.alibaba.dubbo.config.support.Parameter;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.LocaleEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018/8/12.
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;//接口

    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId){
        //调用远程方法.
        return itemService.getItemById(itemId);
    }
}
