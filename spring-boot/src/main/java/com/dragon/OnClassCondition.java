package com.dragon;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;

/**
 * @date: 2024/4/19 08:39
 * @author: ybl
 */
public class OnClassCondition implements Condition {
    /**
     * @param context  the condition context
     * @param metadata the metadata of the {@link org.springframework.core.type.AnnotationMetadata class}
     *                 包括所有被注解的元数据信息
     *                 or {@link org.springframework.core.type.MethodMetadata method} being checked
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        // 从metadata获取注解信息
        // string 属性名称
        // Object 属性值
        Map<String, Object> annotationAttributes =
                metadata.getAnnotationAttributes(ConsumeConditionOnClass.class.getName());

        String className = (String) annotationAttributes.get("value");

        try {
            context.getClassLoader().loadClass(className);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }


}
