package io.github.neoqf.test;

import io.github.neoqf.junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    /**
     * 初始化方法：
     *  用于资源的申请，所有的测试方法在执行之前都会执行该方法。
     */
    @Before
    public void init() {
        System.out.println("init...");
    }

    /**
     * 释放资源的方法：
     *  在所有测试方法执行完后，都会自动执行该方法。
     */
    @After
    public void close() {
        System.out.println("close...");
    }

    /**
     * 测试add方法
     */
    @Test
    public void testAdd() {
        // System.out.println("I ran!");
        // 1、创建计算器对象
        Calculator c = new Calculator();

        // 2、调用add方法
        int res = c.add(1, 2);
        System.out.println(res);

        // 3、断言，我断言此结果为3
        Assert.assertEquals(3, res);
    }
}
