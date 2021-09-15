package cc.maystudio.febs.common.annotation;

import cc.maystudio.febs.common.condition.OnRedisCacheCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @author mayStudio
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Conditional(OnRedisCacheCondition.class)
public @interface ConditionOnRedisCache {
}
