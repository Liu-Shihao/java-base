package com.lsh.javabase.collection;

import java.util.Stack;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/5/11 9:16 下午
 * @desc ：Stack 栈 先进后出  弹夹结构
 * Stack 继承了Vector  底层也是一个数组
 */
public class Code05_Stack {
    public static void main(String[] args) {
        Stack<Object> stack = new Stack<>();
        stack.add("aa");
        stack.push("bb");
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);

    }
}
