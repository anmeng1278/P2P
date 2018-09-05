package com.am.p2p.dataService.cache;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;

/**
 * Author:DELL
 * Date : 2018/8/29
 **/
public class RedisCacheConfig extends CachingConfigurerSupport {

   /* @Override
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            //自动生成的key为：类名——方法名——参数列表
            @Override
            public Object generate(Object target, Method method, Object... params) {
                String className = target.getClass().getName();
                String methodName = method.getName();
                return  className + "_" + methodName + params.toString();
            }
        };
    }*/


    @Override
    public KeyGenerator keyGenerator() {
        return (target,method,params) -> {
            String className = target.getClass().getName();
            String methodName = method.getName();
            return  className + "_" + methodName + params.toString();
        };
    }
}
