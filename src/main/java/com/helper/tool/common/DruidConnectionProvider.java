package com.helper.tool.common;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.pool.DruidDataSource;

public class DruidConnectionProvider extends DruidDataSource {

    private static String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKfkK2hgtAKuV3uuU1wjo0kyuCFcf4QXxF4+zFUYWf4a5s6CJneKGzwE+onpUL3tsa3SB1Q1HtIlykXO+g7hlkECAwEAAQ==";

    @Override
    public void setUsername(String username) {
        try {
            username = ConfigTools.decrypt(publicKey, username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.setUsername(username);
    }
}
