package com.dragon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @date: 2024/4/19 08:16
 * @author: ybl
 * 这个类如果不做特殊处理，spring是扫描不到的
 * 方式一：手动import
 */
@Configuration
public class WebServerAutoConfiguration {
    @Bean
//    @Conditional(TomcatCondition.class)
    @ConsumeConditionOnClass("org.apache.catalina.startup.Tomcat")
    public TomcatWebServer tomcatWebServer() {
        return new TomcatWebServer();
    }

    @Bean
//    @Conditional(JettyCondition.class)
    @ConsumeConditionOnClass("org.eclipse.jetty.server.Server")
    public JettyWebServer jettyWebServer() {
        return new JettyWebServer();
    }

}
