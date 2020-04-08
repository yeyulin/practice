package com.jvm.utils;

import org.springframework.context.ApplicationContext;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * spring工具类
 * @author xuxu
 *
 */
public class SpringUtils {
	

	private static ApplicationContext applicationContext;
	
	private SpringUtils() {
		
	}
	
	/**
	 * 初始化上下文容器
	 * @param applicationContext
	 */
	public static void  setApplicationContext(ApplicationContext applicationContext) {
		SpringUtils.applicationContext=applicationContext;
	}
	
	/**
	 * 获取上下文容器
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {
		return SpringUtils.applicationContext;
	}
	
	/**
	 * 获取容器内对象列表
	 * @param <T>s
	 * @param clazz
	 * @return
	 */
	public static <T>  Set<T> getBeans(Class<T> clazz) {
		return applicationContext.getBeansOfType(clazz).values().stream().collect(Collectors.toSet());
	}

}
