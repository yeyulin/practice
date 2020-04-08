package com.practice.rpc.api;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author yeyulin
 * @description: SPI类加载器帮助类
 * @date 2020/1/7 13:45
 * @since 2.0.7
 */
public class ServiceSupport {
  private static final Map<String, Object> singletonServices = new HashMap<>();

  public static synchronized <S> S loadFirst(Class<S> service) {
    return StreamSupport.stream(ServiceLoader.load(service).spliterator(), false)
        .map(ServiceSupport::singletonFilter)
        .findFirst()
        .orElseThrow(ServiceLoadException::new);
  }

  public static synchronized <S> Collection<S> loadAll(Class<S> service) {
    return StreamSupport.stream(ServiceLoader.load(service).spliterator(), false)
        .map(ServiceSupport::singletonFilter)
        .collect(Collectors.toList());
  }

  private static <S> S singletonFilter(S service) {

    if (service.getClass().isAnnotationPresent(Singleton.class)) {
      String className = service.getClass().getCanonicalName();
      Object singletonInstance = singletonServices.putIfAbsent(className, service);
      return singletonInstance == null ? service : (S) singletonInstance;
    } else {
      return service;
    }
  }
}
