package com.ricky.dentalclinic.dental.service;

import java.util.Date;

public interface CaseService {
    int insertCase(String name, String sex, String birthday, String phoneNumber);
}
