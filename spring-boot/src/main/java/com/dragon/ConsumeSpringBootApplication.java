package com.dragon;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ComponentScan
// 单个推荐这种使用，但如果数目很多，这种就不太合适
@Import(WebServerAutoConfiguration.class)
public @interface ConsumeSpringBootApplication {
}
