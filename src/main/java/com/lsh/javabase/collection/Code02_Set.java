package com.lsh.javabase.collection;

import java.util.*;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/10 11:36 下午
 * @desc ：Set集合常用实现类
 *
 * HashSet：
 *
 *
 * TreeSet：
 *
 *
 * 两种方式实现比较器
 *
 *
 */
public class Code02_Set  {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);

        LinkedHashSet linkedHashSet = new LinkedHashSet();

        TreeSet treeSet = new TreeSet<Student>(new StudentAgeComparator());
        Student zs = new Student("zs", 41);
        Student ls = new Student("ls", 14);
        treeSet.add(zs);
        treeSet.add(ls);
        for (Object o : treeSet) {
            System.out.println(o);
        }


    }

    class demo2 implements Comparable<Integer>{

        @Override
        public int compareTo(Integer o) {
            return 0;
        }
    }

    static class Student{
        String name;
        Integer age;

        public Student() {
        }

        public Student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    static class StudentAgeComparator implements Comparator<Student>{
        /**
         * o1 -o2 正序
         * o2 -o1 倒序
         *
         * 返回正数
         * 返回负数
         * @param o1
         * @param o2
         * @return
         */
        @Override
        public int compare(Student o1, Student o2) {
//            return o1.age - o2.age;
            return o2.age - o1.age;
        }
    }
}
