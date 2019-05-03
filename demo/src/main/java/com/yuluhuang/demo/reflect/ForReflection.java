/**
 * @Title
 * @Project java-Demo
 * @Package com.yuluhuang.Demo.reflect
 * @Description
 * @author yoshikouamari
 * @date 2019-05-02 11:58
 * @version
 */
package com.yuluhuang.demo.reflect;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Description
 * @author yoshikouamari
 * @date 2019-05-02 11:58
 */
public class ForReflection {
    private Map<String, String> caches = new HashMap<String, String>();
    public void execute(String message) {
        String b = this.toString() + message;
        caches.put(b, message);
    }
}
