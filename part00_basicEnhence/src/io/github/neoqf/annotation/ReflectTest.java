package io.github.neoqf.annotation;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 框架类
 */
@Pro(className = "io.github.neoqf.annotation.ProDemo1", methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws Exception {
       /*
            前提：不能改变该类的任何代码。
         */


        // 1.解析注解：
        // 1.1 获取该类的字节码文件对象
        Class<ReflectTest> reflectTestClass = ReflectTest.class;

        // 2.获取被注解修饰的注解对象，传入参数为注解的具体类型
        // 其实就是在内存中，生成了一个该注解接口的子类实现对象
        Pro an = reflectTestClass.getAnnotation(Pro.class);

        // 3.调用注解对象中定义的抽象方法（属性），来获取返回值（属性值）
        String className = an.className();
        String methodName = an.methodName();
        System.out.println(className);
        System.out.println(methodName);

        // 相当于以下代码：
        /**
         public class ProImpl implements Pro {
            public String className() {
                return "io.github.neoqf.annotation.ProDemo1";
            }
            public String methodName() {
                return "show";
            }
         }
         */

        // 3 加载该类进内存
        Class cls = Class.forName(className);
        // 4 创建对象
        Object obj = cls.newInstance();
        // 5 获取方法对象
        Method method = cls.getMethod(methodName);
        // 6 执行方法
        method.invoke(obj);
    }
}
