package com.helper.tool.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.helper.tool.model.UserInfo;
import com.helper.tool.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Api("这里是测试")
@RestController
@RequestMapping("/demo")
public class DemoControl {
    private static final Logger logger = LoggerFactory.getLogger(DemoControl.class);

    @Resource(name = "demoServiceTest")
    private DemoService demoService;
    private final DataSource dataSource;

    public DemoControl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @ApiOperation("测试接口")
    @GetMapping(name = "接口测试", value = "/getDemo")
    public String getDemo() {
        logger.debug("begin interface getDemo");
        String msg = "hello，demo";
        System.out.println(((DruidDataSource) this.dataSource).getUsername());
        logger.debug("end interface getDemo");
        return msg;
    }

    @ApiOperation("用户查询")
    @GetMapping(name = "用户查询", value = "/queryUserInfo")
    public UserInfo queryUserInfo(Integer userId) {

        return demoService.queryUserInfo(userId);

    }

}
