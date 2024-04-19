package com.dragon;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @date: 2024/4/19 08:21
 * @author: ybl
 */
public class JettyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        try {
            context.getClassLoader().loadClass("org.eclipse.jetty.server.Server");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
