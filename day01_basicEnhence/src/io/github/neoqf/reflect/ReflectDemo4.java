package io.github.neoqf.reflect;

import io.github.neoqf.domain.Person;

import java.lang.reflect.Method;

public class ReflectDemo4 {
    public static void main(String[] args) throws Exception {
        // 0.获取person的class对象
        Class<Person> personClass = Person.class;
        /*
            3. 获取成员方法们：
			* Method[] getMethods()
			* Method getMethod(String name, 类<?>... parameterTypes)

			* Method[] getDeclaredMethods()
			* Method getDeclaredMethod(String name, 类<?>... parameterTypes)
         */
        // 获取指定名称的方法
        Method eat_method = personClass.getMethod("eat");
        Person p = new Person();
        eat_method.invoke(p);

        // 获取指定名称的方法
        Method eat_method2 = personClass.getMethod("eat", String.class);
        eat_method2.invoke(p, "饭");

        System.out.println("--------------");

        // 获取所有public修饰方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            String name = method.getName();
            System.out.println(name);
            System.out.println(method);
        }

        // 获取类名
        String className = personClass.getName();
        System.out.println(className);
    }
}
