package com.ricky.dentalclinic.dental.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis配置类
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.ricky.dentalclinic.dental.mbg.mapper","com.ricky.dentalclinic.dental.dao"})
public class MybatisConfig {
}
