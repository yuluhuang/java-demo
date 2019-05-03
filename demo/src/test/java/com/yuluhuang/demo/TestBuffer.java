package com.yuluhuang.demo;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @author ylh
 * @create 2018-03-28
 * <p>
 * 1. 缓冲区(Buffer) 在java nio 中负责数据的存取。缓冲区就是数组。用于存储不同数据类型的数据
 * <p>
 * 根据数据类型的不同（boolean)除外， 提供了相应类型的缓冲区：
 * ByteBuffer
 * CharBuffer
 * ShortBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 * <p>
 * 上述缓冲区的管理方法几乎一致 通过allocate() 获取缓冲区
 * <p>
 * 2. 缓冲区存取数据的两个核心方法：
 * put(): 存入数据到缓冲区中
 * get(): 获取缓冲区中的数据
 * <p>
 * 3. 缓冲区中的四个核心属性：
 * capacity: 容量，表示缓冲区中最大存储数据的容量。一旦申明不能改变
 * limit: 界限，表示缓冲区中可以操作数据的大小（limit 后数据不能进行读写）
 * position: 位置，表示缓冲区中正在操作数据的位置
 * <p>
 * <p>
 * mark: 标记，表示记录当前position 的位置， 可通过reset() 恢复
 * <p>
 * position <= limit <= capacity
 */
public class TestBuffer {

    @Test
    public void test2() {
        String str = "abcde";
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.put(str.getBytes());
        buf.flip();

        byte[] dst = new byte[buf.limit()];
        buf.get(dst, 0, 2);
        System.out.println(new String(dst, 0, 2));
        System.out.println(buf.position());

        buf.mark();
        buf.get(dst, 2, 2);
        System.out.println(new String(dst, 2, 2));
        System.out.println(buf.position());

        buf.reset();
        System.out.println(buf.position());
        System.out.println();

        if (buf.hasRemaining()) {
            System.out.println(buf.remaining());
        }
    }

    @Test
    public void test1() {
        String str = "abcde";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println("------------0-1024-1024---------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        System.out.println("-------------put----5-1024-1024------------");
        // 2. 利用 put() 存入数据缓冲区中
        buffer.put(str.getBytes());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());


        // 3. 利用flip() 切换读数据模式
        System.out.println("---------------flip------5-1024-1024--------");
        buffer.flip();
        buffer.put(str.getBytes());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());


        // 4. 利用get() 读取缓冲区的数据
        System.out.println("-------------利用get------5-5-1024----------");
        byte[] dst = new byte[buffer.limit()];
        buffer.get(dst);
        System.out.println(new String(dst, 0, dst.length));
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());


        // 5. rewind() 可重复读
        System.out.println("-------------rewind----0-5-1024------------");
        buffer.rewind();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());


        // 6. clear() : 清空缓冲区 但缓冲区中的数据依然存在， 但处于 被遗忘 状态
        System.out.println("------------clear---0-1024-1024--------------");
        buffer.clear();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());


        System.out.println();


    }


}
