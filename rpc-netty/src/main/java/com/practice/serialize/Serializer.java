package com.practice.serialize;

/**
 * @author yeyulin
 * @description: 序列化接口
 * @date 2020/1/7 10:25
 * @since 2.0.7
 **/
public interface Serializer<T> {
    /**
     * 计算对象序列化后的长度，主要用于申请存放序列化数据的字节数组
     * @param entry 待序列化对象
     * @return 序列化数组的长度
     */
    int size(T entry);

    /**
     * 将对象序列化到数据
     * @param entry 对象
     * @param bytes 保存对象的数组
     * @param offset 起始位
     * @param length 对象序列化长度 {@link Serializer#size(Object)}
     * @return
     */
    void serialize(T entry,byte[]bytes,int offset,int length);

    /**
     * 反序列化对象
     * @param bytes 存放序列化数据的字节数组
     * @param offset 数组的偏移量，从这个位置开始写入序列化数据
     * @param length 对象序列化数组长度
     * @return 反序列化后生成的对象
     */
    T parse(byte[]bytes,int offset,int length);

    /**
     * @return 用一个字节标识对象类型，每种类型的数据应该具有不同的类型值
     */
    byte type();

    /**
     * @return 返回序列化对象类型的Class对象
     */
    Class<T> getSerializeClass();


}
