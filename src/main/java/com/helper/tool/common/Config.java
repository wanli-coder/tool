package com.helper.tool.common;

import com.alibaba.druid.filter.config.ConfigTools;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/config.properties")
public class Config {

    @Value("${app_id}")
    public String appId;

    @Value("${db_encode__key}")
    public String dbEncodeKey;

    public static void main(String[] args) throws Exception {
        String[] arr = ConfigTools.genKeyPair(512);
        System.out.println("privateKey:" + arr[0]);
        System.out.println("publicKey:" + arr[1]);
        System.out.println("password:" + ConfigTools.encrypt(arr[0], "123456"));

        String publicKey="MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAMttr07gD7YAPYqBk3yEKnH2G3rqQTGoR/v+utrOLlI6uLmWqFU2+T3djA81xaoyLIhHeIo4WnTVBJLx5zFldcUCAwEAAQ==";
        String password="esu+Uv7A+y49DA580fYPMlvRQtJwx8tZVXlHrZa9WHbkUnAigy4Capo38yuxPIG/vlVvZ7IeuUSjkqiJyjZ9JQ==";
        System.out.println(ConfigTools.decrypt(publicKey,password));
    }
}
