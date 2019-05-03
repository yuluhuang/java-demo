package com.yuluhuang.quartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 这是因为添加了数据库组件，所以autoconfig会去读取数据源配置，而新建的项目还没有配置数据源，所以会导致异常出现
 * <p>
 * 解决办法：
 * 1. 去掉数据库依赖
 * <p>
 * 2.在启动类的@EnableAutoConfiguration或@SpringBootApplication中添加exclude = {DataSourceAutoConfiguration.class}，排除此类的autoconfig。启动以后就可以正常运行。
 */
@SpringBootApplication
public class QuartzApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuartzApplication.class, args);
    }

}
