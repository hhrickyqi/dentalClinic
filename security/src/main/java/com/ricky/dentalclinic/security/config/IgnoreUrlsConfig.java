package com.ricky.dentalclinic.security.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于配置不需要保护的资源路径
 */

@ConfigurationProperties(prefix = "secure.ignored")
public class IgnoreUrlsConfig {
    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    private List<String> urls = new ArrayList<>();
}
