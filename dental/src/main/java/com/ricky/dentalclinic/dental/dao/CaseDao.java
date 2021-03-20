package com.ricky.dentalclinic.dental.dao;

import org.apache.ibatis.annotations.Param;

public interface CaseDao {
    int deleteCase(@Param("id") int id, @Param("is_delete") int is_delete);
}
