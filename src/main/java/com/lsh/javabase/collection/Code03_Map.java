package com.lsh.javabase.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/10 11:36 下午
 * @desc ：
 */
public class Code03_Map {

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    public static void main(String[] args) {

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(null,"null");//{null=null}
//        hashMap.put(null,null);//{null=null}
        System.out.println("重地："+hash("重地"));
        System.out.println("通话："+hash("通话"));// 重地 he  通话 作为key的哈希码值相同
        hashMap.put("重地",hash("重地"));
        hashMap.put("通话",hash("通话"));

        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
        ConcurrentSkipListMap<Object, Object> concurrentSkipListMap = new ConcurrentSkipListMap<>();

        System.out.println(hashMap);
        Hashtable<String, Object> hashtable = new Hashtable<>();
//        hashtable.put(null,"null");//空指针异常，所以Hashtable不能存储null键

        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<String, Object>();

    }
}
