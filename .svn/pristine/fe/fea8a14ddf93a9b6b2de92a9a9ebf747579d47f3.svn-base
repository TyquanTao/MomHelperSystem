package com.cn.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author:Teacher黄
 * @date:Created at 2019/11/20
 */
@Configuration
@PropertySource("classpath:config/sys.properties")
public class SystemConfig {

    @Value("${basePath}")
    private String basePath;
    @Value("${suffixs}")
    private String suffixs;

    public SystemConfig() {
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getSuffixs() {
        return suffixs;
    }

    public void setSuffixs(String suffixs) {
        this.suffixs = suffixs;
    }

    @Override
    public String toString() {
        return "SystemConfig{" +
                "basePath='" + basePath + '\'' +
                ", suffixs='" + suffixs + '\'' +
                '}';
    }
}
