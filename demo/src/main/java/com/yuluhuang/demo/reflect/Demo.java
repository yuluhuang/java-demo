/**
 * @Title
 * @Project java-Demo
 * @Package com.yuluhuang.Demo.reflect
 * @Description
 * @author yoshikouamari
 * @date 2019-05-02 11:55
 * @version
 */
package com.yuluhuang.demo.reflect;

import java.lang.reflect.Method;

/**
 * 启动参数 添加 -server -Xms128M -Xmx128M
 *
 * 直接调用消耗的时间为：3毫秒
 * 不缓存Method, 反射调用消耗的时间为11毫秒
 * 缓存Method, 反射调用消耗时间为4毫秒
 *
 * 启动参数 添加 -server -Xms128M -Xmx128M -Xint
 *
 * 直接调用消耗的时间为：133毫秒
 * 不缓存Method, 反射调用消耗的时间为214毫秒
 * 缓存Method, 反射调用消耗时间为142毫秒
 *
 * 对比这段测试结果也可看出，C2 编译后代码的执行速度得到了大幅提升
 * @author yoshikouamari
 * @Description
 * @date 2019-05-02 11:55
 */
public class Demo {

    private static final int WARMUP_COUNT = 10700;
    private ForReflection testClass = new ForReflection();
    private static Method method = null;

    public static void main(String[] args) throws Exception {
        method = ForReflection.class.getMethod("execute", new Class<?>[]{String.class});
        Demo demo = new Demo();
        // 保证反射形成的字节码及相关的测试代码能够被JIT编译
        for (int i = 0; i < 20; i++) {
            demo.testDirectCall();
            demo.testCacheMethodCall();
            demo.testNoCacheMethodCall();
        }
        long beginTime = System.currentTimeMillis();
        demo.testDirectCall();
        long endTime = System.currentTimeMillis();
        System.out.println("直接调用消耗的时间为：" + (endTime - beginTime) + "毫秒");
        beginTime = System.currentTimeMillis();
        demo.testNoCacheMethodCall();
        endTime = System.currentTimeMillis();
        System.out.println("不缓存Method, 反射调用消耗的时间为" + (endTime - beginTime) + "毫秒");

        beginTime = System.currentTimeMillis();
        demo.testCacheMethodCall();
        endTime = System.currentTimeMillis();
        System.out.println("缓存Method, 反射调用消耗时间为" + (endTime - beginTime) + "毫秒");


    }

    public void testDirectCall() {
        for (int i = 0; i < WARMUP_COUNT; i++) {
            testClass.execute("hello");
        }
    }

    public void testCacheMethodCall() throws Exception {
        for (int i = 0; i < WARMUP_COUNT; i++) {
            method.invoke(testClass, new Object[]{"hello"});
        }
    }

    public void testNoCacheMethodCall() throws Exception {
        for (int i = 0; i < WARMUP_COUNT; i++) {
            Method testMethod = ForReflection.class.getMethod("execute", new Class<?>[]{String.class});
            testMethod.invoke(testClass, new Object[]{"hello"});
        }
    }
}
