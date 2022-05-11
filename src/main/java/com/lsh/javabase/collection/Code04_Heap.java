package com.lsh.javabase.collection;

import java.util.PriorityQueue;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/11 6:39 下午
 * @desc ：
 *  PriorityQueue 无界队列 初始值为11 可以一直扩容
 */
public class Code04_Heap {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();//默认小根堆
        priorityQueue.add(99);
        priorityQueue.add(1);
        priorityQueue.add(54);
        priorityQueue.add(6);
        System.out.println(priorityQueue);
    }
}
