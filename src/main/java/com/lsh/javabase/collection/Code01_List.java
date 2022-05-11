package com.lsh.javabase.collection;

import java.util.*;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/10 11:34 下午
 * @desc ：
 * ArrayList:
 *  1. 底层通过数组实现，
 *  2. 初始数组长度为10，
 *  3. 扩容长度为原数组的1.5倍，在jdk1.8后，创建后没有初始化，在添加元素时才创建出长度为10的数组
 *  4. 线程不安全，效率高
 * Vector:
 *  1. 底层也是通过数组实现
 *  2. 初始长度为10
 *  3. 扩容长度为原数组的两倍
 *  4. 方法用synchronized修饰，线程是安全的，效率低，
 * LinkedList:
 *  1. 底层通过链表实现
 *
 */
public class Code01_List {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        //ArrayList线程不安全，可以使用Collections.synchronizedList(new ArrayList<>())方法将集合转换为线程安全的
        Collection<Integer> synchronizedCollection = Collections.synchronizedList(new ArrayList<>());

        arrayList.add(3);
        arrayList.add(6);
        arrayList.add(1);
        arrayList.add(9);
        for (Integer o : arrayList) {
            System.out.println(o);
        }


        Vector<Integer> vector = new Vector<>();


        System.out.println("----");
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(3);
        linkedList.add(5);
        linkedList.add(1);
        linkedList.add(8);

        for (Integer integer : linkedList) {
            System.out.println(integer);

        }

    }

    class Person{
        String name;
        int age;

    }
}
