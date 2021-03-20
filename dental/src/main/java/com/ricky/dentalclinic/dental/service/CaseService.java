package com.ricky.dentalclinic.dental.service;

import java.util.Date;

public interface CaseService {
    /*
    添加病人信息
     */
    int insertCase(String name, String sex, String birthday, String phoneNumber);

    /*
    删除病人信息
     */
    int deleteCase(int id);
}
