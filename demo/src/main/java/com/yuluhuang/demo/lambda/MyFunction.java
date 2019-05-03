/**
 * @Title
 * @Project java-demo
 * @Package com.yuluhuang.demo.lambda
 * @Description
 * @author yoshikouamari
 * @date 2019-05-02 18:57
 * @version
 */
package com.yuluhuang.demo.lambda;

/**
 *
 * @Description
 * @author yoshikouamari
 * @date 2019-05-02 18:57
 */
public interface MyFunction<T, R> {
    public R getValue(T t1, T t2);
}
