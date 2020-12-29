package com.geekStudy.week7.config;

import java.lang.annotation.*;

/**
 * 自定义注解：DS
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(
        {ElementType.METHOD}
)
@Inherited
public @interface DS {
    String value() default "";
}
