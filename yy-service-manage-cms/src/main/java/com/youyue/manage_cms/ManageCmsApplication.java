package com.youyue.manage_cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.youyue.framework.domain.cms")//扫描实体类
@ComponentScan(basePackages = {"com.youyue.api","com.youyue.manage_cms"})//扫描接口和扫描本项目下的所有类
//@ComponentScan(basePackages = {"com.youyue.manage_cms"})
public class ManageCmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageCmsApplication.class);
    }
}
