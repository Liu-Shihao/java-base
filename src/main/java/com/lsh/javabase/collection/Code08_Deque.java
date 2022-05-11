package com.lsh.javabase.collection;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/12 12:20 上午
 * @desc ：Deque（接口）   双端队列  继承Queue
 *
 * LinkedList是Deque的实现类，即使双端队列 可以从头添加也可以从尾添加，
 */
public class Code08_Deque {

    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.addLast("aaa");
        deque.addFirst("head");
        deque.addLast("last");
        deque.offer("bbbb");
        //offer()与add（）方法相同 addLast =  offerLast   addFirst =  offerFirst
        System.out.println(deque);
        System.out.println(deque.getFirst());//获得第一个元素，但不弹出
        System.out.println(deque.getLast());//获得最后一个元素，但不弹出
        System.out.println(deque);

        System.out.println(deque.pollFirst());//弹出第一个元素
        System.out.println(deque.pollLast());//弹出最后一个元素
        System.out.println(deque);
    }
}
