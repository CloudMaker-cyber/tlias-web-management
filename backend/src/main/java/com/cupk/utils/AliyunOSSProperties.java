package com.cupk.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")//注解作用：批量将多个属性注入到Bean对象中。(application.yml中配置的前缀)
public class AliyunOSSProperties {// 阿里云OSS配置属性，需要这些东西时直接注入使用，不需要再用@Value一个个去赋值；方便维护管理和复用
    private String endpoint;// 阿里云OSS的域名
    private String bucketName;// 阿里云OSS的存储空间
    private String region;// 阿里云OSS的区域
}
