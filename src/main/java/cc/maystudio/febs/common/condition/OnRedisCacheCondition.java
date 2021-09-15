package cc.maystudio.febs.common.condition;

import cc.maystudio.febs.common.properties.FebsProperties;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.lang.NonNull;

/**
 * @author mayStudio
 */
public class OnRedisCacheCondition implements Condition {

    @Override
    public boolean matches(@NonNull ConditionContext context, @NonNull AnnotatedTypeMetadata metadata) {
        return Boolean.parseBoolean(context.getEnvironment().getProperty(FebsProperties.ENABLE_REDIS_CACHE));
    }
}
