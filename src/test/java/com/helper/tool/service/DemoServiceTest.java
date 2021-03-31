package com.helper.tool.service;

import com.helper.tool.model.UserInfo;
import com.helper.tool.BaseTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DemoServiceTest extends BaseTest {
    @Autowired
    DemoService demoService;

    @Test
    @Rollback(value = true)
    public void testInsertDemo() {
        UserInfo record = new UserInfo();
        record.setUserId(1);
        record.setUserName("张三");
        record.setAge(18);
        record.setAddress("china");
        demoService.insertDemo(record);
    }
}
