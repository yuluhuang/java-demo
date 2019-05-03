package com.yuluhuang.demo; /**
 * @Title
 * @Project java-tutorial
 * @Package PACKAGE_NAME
 * @Description
 * @author ylh
 * @date 2018-06-28 09:26
 * @version
 */

/**
 * @author ylh
 * @Description
 * @date 2018-06-28 09:26
 */
class MyThread implements Runnable {
    /**
     * 计算类型，1表示减法，其他的表示加法
     */
    private int type;

    public MyThread(int type) {
        this.type = type;
    }

    public void run() {
        if (type == 1)
            for (int i = 0; i < 10000; i++)
                Test.num++;
        else
            for (int i = 0; i < 10000; i++)
                Test.num--;
    }
}

public class Test {
    static int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    public static int num = 1000000;

    public static void main(String[] args) {
//        hash(AA);
        Thread a = new Thread(new MyThread(1));
        Thread b = new Thread(new MyThread(2));

        a.start();
        b.start();

        /*
         * 主线程等待子线程完成，然后再打印数值
         */
        try {
            a.join();
            b.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(num);
    }

}
