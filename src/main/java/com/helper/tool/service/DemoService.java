package com.helper.tool.service;

import com.helper.tool.model.UserInfo;

public interface DemoService {
    public void insertDemo(UserInfo record);

    UserInfo queryUserInfo(Integer userId);
}
