package com.ricky.dentalclinic.dental.dao;

import com.ricky.dentalclinic.dental.mbg.model.TItems;

import java.util.List;

public interface ItemsDao {
    List<TItems> getChargeItemList();

}
