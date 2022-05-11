package com.lsh.javabase.collection;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/11 10:08 下午
 * @desc ：
 */
public class Code06_COW {
    public static void main(String[] args) {
        //底层通过数组实现
        CopyOnWriteArrayList<Object> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add("1");
        copyOnWriteArrayList.add("2");
        copyOnWriteArrayList.add("1");//允许元素重复
        copyOnWriteArrayList.addIfAbsent("1");//去重添加
        copyOnWriteArrayList.addIfAbsent("11");


        //底层通过Set实现
        CopyOnWriteArraySet<Object> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        copyOnWriteArraySet.add("11");
        copyOnWriteArraySet.add("11");//直接去重
        System.out.println(copyOnWriteArraySet);
    }
}
