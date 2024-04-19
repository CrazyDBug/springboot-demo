package com.dragon;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @date: 2024/4/19 08:18
 * @author: ybl
 */
public class TomcatCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        try {
            context.getClassLoader().loadClass("org.apache.catalina.startup.Tomcat");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
