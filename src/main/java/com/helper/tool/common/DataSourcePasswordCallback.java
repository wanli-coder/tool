package com.helper.tool.common;

import com.alibaba.druid.util.DruidPasswordCallback;
import com.helper.tool.common.utils.AESUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class DataSourcePasswordCallback extends DruidPasswordCallback {
    @Autowired
    public Config config;

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        String password = properties.getProperty("password");
        String key = config.dbEncodeKey;
        if (StringUtils.isNotEmpty(password) && StringUtils.isNotEmpty(key)) {
            password = AESUtil.decode(password, key);
            setPassword(password.toCharArray());
        }
    }
}
