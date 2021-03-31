package com.helper.tool.service.impl;

import com.helper.tool.mapper.UserInfoMapper;
import com.helper.tool.model.UserInfo;
import com.helper.tool.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("demoServiceTest")
public class DemoServiceImpl implements DemoService {
    Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    private final UserInfoMapper userInfoMapper;

    public DemoServiceImpl(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    public void insertDemo(UserInfo record) {
        logger.debug("begin serviceTest");
        userInfoMapper.insert(record);
        logger.debug("end serviceTest");
    }

    @Override
    public UserInfo queryUserInfo(Integer userId) {
        return userInfoMapper.selectByPrimaryKey(userId);
    }
}
