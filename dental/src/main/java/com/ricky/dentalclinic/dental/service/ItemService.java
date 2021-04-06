package com.ricky.dentalclinic.dental.service;

import com.ricky.dentalclinic.dental.domain.ItemsParam;
import com.ricky.dentalclinic.dental.mbg.model.TItems;

import java.math.BigDecimal;
import java.util.List;

public interface ItemService {
    /*
    获取收费项目列表
     */
    List<TItems> getChargeItemList();

    /*
    添加收费项目
     */
    int insertChargeItem(String item, BigDecimal cost);

    /*
    删除收费项目
    */
    int deleteChargeItem(Integer id);

    /*
    修改收费项目
    */
    int updateChargeItem(ItemsParam itemsParam);
}
