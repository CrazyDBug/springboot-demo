package com.dragon.user;

import com.dragon.ConsumeSpringApplication;
import com.dragon.ConsumeSpringBootApplication;

/**
 * springboot默认是扫描传给run方法配置类所在的包路径
 */
@ConsumeSpringBootApplication
public class ConsumeApplication {
    public static void main(String[] args) {
        ConsumeSpringApplication.run(ConsumeApplication.class);
    }
}