<h1>Java基础源码分析</h1>

# 集合
## ArrayList

## LinkedList

## Vector

## HashSet

### LinkedHashSet

## TreeSet

## HashMap

### LinkedHashMap

## Hashtable

##TreeMap

## ConcurrentHashMap
线程安全，效率高
采用了分段锁机制，降低了锁粒度，极大的提高了效率



## COW
Copy On Write，写时复制容器，实现读写分离，即在写的时候不影响读操作；
1. 创建新容器
2. 拷贝旧值
3. 将新值添加到新容器中
4. 将老容器地址引用指向新容器地址；

COW容器操作是没有锁的，提高了并发性能，只是做了额外的复制，但是如果写数据很多，则会消耗JVM资源。
并且COW容器只能保证最终一致性，无法保证数据实时一致性；
适合读多写少的场景；
### CopyOnWriteArrayList
底层通过数组实现
### CopyOnWriteArraySet
底层通过Set实现

## Queue 队列
阻塞队列：
    入队：如果队列元素已满，则会阻塞等待
    出队：如果队列没有元素，则会阻塞等待
### ArrayBlockingQueue
底层是数组实现，有边界队列，不支持读写同时操作（入队和出队操作使用的是同一把锁）

### LinkedBlockingQueue
底层是链表实现,无边界队列，支持读写同时操作，并发情况下，效率高（入队和出队使用了两把不同的锁）

### SynchronousQueue 同步队列
只能先取在存
### PriorityBlockingQueue 优先级阻塞队列
不是在put元素的时候排序，而是在取出元素的时候才排序

### DelayQueue 延时队列
根据元素的过期时间排序，越早过期的越排在前面
只有元素过期了才能被取出


### Deque 双端队列
Deque是个接口，LinkedList 是其实现类，所以LinkedList是个双端队列








