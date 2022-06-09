package com.lsh.javabase.io;

/**
 * @author ：LiuShihao
 * @date ：Created in 2022/6/9 2:20 下午
 * @desc ：在Jdk1.4之后引入了nio 新的JavaIO类库
 * 新的概念： Channel 通道 和 Buffer 缓冲器
 * 我们并不和通道直接交互，只是和缓冲器交互
 * 通道要么从缓冲器获得数据，要么向缓冲器发送数据
 * 唯一直接和通道交互的缓冲器是ByteBuffer 用于以原始的字节形式或基本数据类型输出和读取数据
 */
public class Code02_NIO {
}
