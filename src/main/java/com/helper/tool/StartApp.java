package com.helper.tool;

import com.alibaba.druid.pool.DruidDataSource;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan("com.helper.tool.mapper")
@ServletComponentScan("com.helper.tool.common.filter")
@EnableSwagger2Doc public class StartApp {

    public static void main(String[] args) {
        SpringApplication.run(StartApp.class, args);
    }

    @Bean(name = "dataSource") @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setPassword("123");
        return dataSource;
    }
}
