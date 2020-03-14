package com.caojianyu.timer.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author caojianyu
 * @create 2019-12-26 11:20
 * @mail jieni_cao@foxmail.com
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Timer {
	public String hour() default "0";
    public String minutes() default "0";
    public String seconds() default "0";
}
