package com.ricky.dentalClinic.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis配置类
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.ricky.dentalClinic.mapper","com.ricky.dentalClinic.dao"})
public class MybatisConfig {
}
