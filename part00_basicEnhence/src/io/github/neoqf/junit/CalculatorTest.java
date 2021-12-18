package io.github.neoqf.junit;

public class CalculatorTest {
    public static void main(String[] args) {
        // 创建对象
        Calculator c = new Calculator();

        // 调用方法
        int res = c.add(1, 2);
        System.out.println(res);
    }
}
