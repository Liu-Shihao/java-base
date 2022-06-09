package com.lsh.javabase.io;

import java.io.*;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/6/9 1:30 下午
 * @desc ：Java IO
 * 输入流： InputStream 、Reader
 * 输出流： OutputStream 、Writer
 * 字节流： InputStream、OutputStream
 * 字符流： Reader、Writer
 * 1. 字节流和字符流 可以通过适配器类（adapter）进行转换：
 *     InputStreamReader 可以把 InputStream 转换为 Reader
 *     OutputStreamWriter 可以把 OutputStream 转换为 Writer
 * 2. 使用FileOutputStream 可以直接读取字符串的byte[]写到文件中;使用FileWriter可以直接将String写到文件中
 * 3. BufferedReader(new FileReader(new File())) readLine（）方法 返回null时到达文件末尾
 * 4. 读取二进制文件 使用 BufferedInputStream（new FileInputStream(new File())）
 *
 *
 */
public class Code01_Java_IO {

    public static void main(String[] args) throws IOException {
        String s = "Hello Java IO\nHello\nhahahha...\n2022年06月09日14:01:49";
//        new StringBufferInputStream()//StringBufferInputStream被弃用
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(s.getBytes());
        File file1 = new File("a.txt");
        File file2 = new File("b.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file1);
        fileOutputStream.write(s.getBytes());
        fileOutputStream.close();


        FileWriter fileWriter = new FileWriter(file2);
        fileWriter.write(s);
        fileWriter.close();

//        FileInputStream fileInputStream = new FileInputStream(file1);
//        byte[] bytes = new byte[2];
//        StringBuilder stringBuilder1 = new StringBuilder();
//        int x = 0;
//        while ((x = fileInputStream.read(bytes)) != -1){
//            stringBuilder1.append(bytes);
//        }
//        System.out.println(stringBuilder1);

        FileReader fileReader = new FileReader(file2);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder();
        String line ;
        while ((line = bufferedReader.readLine()) != null){
            stringBuilder.append(line + "\n");
        }
        System.out.println(stringBuilder);
        bufferedReader.close();
        fileReader.close();
//        BufferedWriter bufferedWriter = new BufferedWriter();

        //读取二进制文件
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File("Demo.class")));
        BufferedOutputStream bufferedOutputStream = null;
        byte[] bytes = new byte[bufferedInputStream.available()];
        try {
            bufferedInputStream.read(bytes);
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File("copy_Demo.class")));
            bufferedOutputStream.write(bytes);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            bufferedInputStream.close();
            bufferedOutputStream.close();
        }

    }
}
