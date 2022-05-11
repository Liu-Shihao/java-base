package com.lsh.javabase.collection;

import java.util.concurrent.*;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/11 10:18 下午
 * @desc ：队列 Queue 先进先出
 * 双端队列：
 *
 * Queue(接口)  --> BlockingDeque(接口) --> ArrayBlockingQueue(实现类)
 * 阻塞队列：（即生产者/消费者模型）
 *      入队：当队列满的时候，添加新元素则会进行等待，如果有元素出队，新元素则会入队；
 *      出队：在取出数据的时候如果队列中没有元素则也会进行等待
 * 非阻塞队列：
 *      入队：当队列满的时候，再添加元素，则元素会丢失。
 *      出队：当队列没有数据时，取出元素为null
 *  ArrayBlockingQueue ：底层是数组实现，有边界队列，不支持读写同时操作（入队和出队操作使用的是同一把锁）
 *  LinkedBlockingQueue：底层是链表实现,无边界队列，支持读写同时操作，并发情况下，效率高（入队和出队使用了两把不同的锁）
 *
 *  SynchronousQueue：同步队列
 *
 *
 */
public class Code07_Queue {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>();
        ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(3);
        blockingQueue.offer(1);//入队
        System.out.println(blockingQueue.peek());//查看队列队顶元素
        System.out.println(blockingQueue.poll());//弹出
//        blockingQueue.offer(null);//注意：队列不允许添加null
        blockingQueue.add(1);
        blockingQueue.add(3);
        blockingQueue.add(4);//此时队列已满
//        blockingQueue.add(5);//如果队列已满再使用add（）方法添加元素，则会抛出异常Queue full
        blockingQueue.offer(6);//当队里已满，使用offer（）方法添加元素则不会抛出异常,但是会返回布尔值类型为false
        System.out.println(blockingQueue);
//        blockingQueue.offer(7,2, TimeUnit.SECONDS);//队列已满，此时使用offer（）方法添加元素，2s阻塞时间
//        blockingQueue.put(8);//注意：但是使用put()方法，则会一直阻塞，等待入队
        blockingQueue.poll();//从队列中弹出元素
        blockingQueue.take();//如果队列为空，则会一直阻塞
        System.out.println("end");
        System.out.println("========");

        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();
        //SynchronousQueue队列只能先取元素在添加，否则会抛出异常：Queue full
        new Thread(()->{
            try {
                while (true) {
                    //take()方法会阻塞
                    System.out.println(synchronousQueue.take());
                }
            } catch (InterruptedException e) {
            }
        }).start();

        new Thread(()->{
            try {
                //put()方法会阻塞
                synchronousQueue.put(1);
                synchronousQueue.put(2);
                synchronousQueue.put(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("已存入..");
        }).start();
        System.out.println("========");
        //优先级阻塞队列：注意：不是在put元素的时候排序，而是在取出元素的时候才排序
        PriorityBlockingQueue<String> priorityBlockingQueue = new PriorityBlockingQueue<>();

        System.out.println("=======");
        //DelayQueue中的元素必须是Delayed的子类，
        // 队列中的元素是按照到期时间进行排序的：队列头部的元素是最早到期的，尾部的元素是最晚到期的
        // 队列中的元素只有在到期的时候才能被取走
        DelayQueue<Delayed> delayeds = new DelayQueue<>();
        User user1 = new User(1, "张三", System.currentTimeMillis() + 1000 * 6);
        User user2 = new User(2, "李四", System.currentTimeMillis() + 1000 * 2);
        User user3 = new User(3, "王五", System.currentTimeMillis() + 1000 * 8);
        delayeds.add(user1);
        delayeds.add(user2);
        delayeds.add(user3);
        System.out.println(delayeds);
        while (!delayeds.isEmpty()){
            //take（）方法阻塞取出数据，只有元素过期了才能被取出
            System.out.println(delayeds.take()+" 到期。。。");
        }


    }
}
