package com.lsh.javabase.collection;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/12 12:05 上午
 * @desc ：
 */
public class User implements Delayed {
    int id;
    String name;
    Long endTime;
    @Override
    public long getDelay(TimeUnit unit) {
        //计算到期时间，如果小于等于0 说明已到期，则取出元素
        //到期时间 - 当前时间
        return this.getEndTime() - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        //按照用户的到期时间进行排序
        User user = (User) o;
        return this.endTime.compareTo(user.getEndTime());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public User() {
    }

    public User(int id, String name, Long endTime) {
        this.id = id;
        this.name = name;
        this.endTime = endTime;
    }
}
