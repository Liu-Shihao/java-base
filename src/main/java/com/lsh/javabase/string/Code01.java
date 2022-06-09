package com.lsh.javabase.string;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/6/9 10:59 上午
 * @desc ：String、StringBuilder、StringBuffer
 *
 * 1. String 对象是不可变的，当把String对象作为方法的参数传递时，会复制一份引用，而该引用所指的对象从未改变过，
 *    String对象具有只读特性，任何指向它的引用都不可能改变它的值
 * 2. StringBuilder是JavaSE5引入的，使用StringBuilder比使用+号拼接String更加高效
 * 3. StringBuffer 是线程安全的，方法使用synchronized修饰
 * 4. 输出格式化：System.out.printf("row 1 : [%d %f]\n ",5,5.22); %s 表示字符串； %d表示整数; %f表示浮点数 float/double
 * 5. String 正则表达式
 */
public class Code01 {

    public static void main(String[] args) throws InterruptedException {
        String s1 = "hello";
        System.out.println(s1);//hello
        String s2 = toUpperCase(s1);//toUpperCase（）方法返回的引用指向一个新的对象
        System.out.println(s2);//HELLO
        System.out.println(s1);//hello

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            stringBuilder.append("a");
        }
        System.out.println(stringBuilder);//aaaaa
        StringBuffer stringBuffer = new StringBuffer();

        System.out.printf("row 1 : [%d %f %s]\n ",5,5.22,"haha");//row 1 : [5 5.220000 haha]

        /**
         * 在Java中，\\表示的意思是插入正则表达式的反斜线，
         * 在正则表达式中
         * \\d 表示数字
         * \\D 非数字
         * \\w 字符 [a-zA-Z0-9]
         * \\W 非字符  [^\\w]
         * + 表示一个或者多个
         * （） 将表达式分组   | 表示 或 操作
         * . 表示任意字符
         * [abd] 包含a,b,c的任何字符 <===> a|b|c    ：  a、b、c
         * [^abc]  除了a、b、c之外的任何字符         ：  e、f、g
         * [a-zA-Z] 表示a-z 或者 A-Z de 任何字符    ：  a、b、c...
         *
         * XY  表示Y跟在X后面
         * X|Y  X或Y
         * ^ 一行的开始
         * $ 一行的结束
         * X? 一个或者零个X
         * X* 零个或者多个X
         * X+ 一个或多个X
         * X{n} X正好n次
         * X{n,} X至少n次
         * X{n,m}  x至少n次，且不超过m次
         */
        System.out.println("-1234".matches("-?\\d+"));//true
        System.out.println("5678".matches("-?\\d+"));//true
        System.out.println("+911".matches("-?\\d+"));//false
        System.out.println("+911".matches("(-|\\+)?\\d+"));//true 表示可能是-可能是+ 或者两个符号都没有，

    }

    public static String toUpperCase(String s){
        return s.toUpperCase();
    }
}
