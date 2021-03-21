package com.xiaoxiaoning.demo.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class CopyUtils {

    /**
     * 单体复制
     */
    //一个是复制对象
    //一个是目标类
    public static <T> T copy(Object source, Class<T> clazz) {
        if (source == null) {
            return null;
        }
        T obj = null;
        try {
            //用的是反射机制，来创建目标类的实例
            obj = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        //再调用工具类BeanUtils中的copy方法
        BeanUtils.copyProperties(source, obj);
        return obj;
    }

    /**
     * 列表复制
     */
    public static <T> List<T> copyList(List source, Class<T> clazz) {
        List<T> target = new ArrayList<>();
        if (!CollectionUtils.isEmpty(source)){
            for (Object c: source) {
                //调用上面单个复制的方法，将遍历出来的复制对象和目标类传入自己定义的copy
                T obj = copy(c, clazz);
                target.add(obj);
            }
        }
        return target;
    }
}
