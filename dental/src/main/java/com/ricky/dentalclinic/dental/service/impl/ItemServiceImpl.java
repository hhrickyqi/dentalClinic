package com.ricky.dentalclinic.dental.service.impl;

import com.ricky.dentalclinic.dental.dao.ItemsDao;
import com.ricky.dentalclinic.dental.domain.ItemsParam;
import com.ricky.dentalclinic.dental.mbg.mapper.TItemsMapper;
import com.ricky.dentalclinic.dental.mbg.model.TItems;
import com.ricky.dentalclinic.dental.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemsDao itemsDao;
    @Autowired
    private TItemsMapper itemsMapper;

    @Override
    public List<TItems> getChargeItemList() {
        List<TItems> itemsList = itemsDao.getChargeItemList();
        return itemsList;
    }

    @Override
    public int insertChargeItem(String item, BigDecimal cost) {
        TItems items = new TItems();
        items.setItem(item);
        items.setCost(cost);
        items.setIsDelete(0);
        return itemsMapper.insert(items);
    }

    @Override
    public int deleteChargeItem(Integer id) {
        TItems items = new TItems();
        items.setId(id);
        items.setIsDelete(1);
        return itemsMapper.updateByPrimaryKeySelective(items);
    }

    @Override
    public int updateChargeItem(ItemsParam itemsParam) {
        TItems items = new TItems();
        items.setId(itemsParam.getId());
        items.setItem(itemsParam.getItem());
        items.setCost(itemsParam.getCost());
        return itemsMapper.updateByPrimaryKeySelective(items);
    }
}
