package io.github.neoqf.reflect;

import io.github.neoqf.domain.Person;
import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import java.lang.reflect.Field;

public class ReflectDemo2 {
    public static void main(String[] args) throws Exception {
        // 1.获取person的Class对象
        Class personClass = Person.class;

        /*
            1. 获取成员变量们
			* Field[] getFields() ：获取所有public修饰的成员变量
			* Field getField(String name)   获取指定名称的 public修饰的成员变量

			* Field[] getDeclaredFields()  获取所有的成员变量，不考虑修饰符
			* Field getDeclaredField(String name)
         */
        // 1.Field[] getFields()
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("---------------");
        // 2.Field getField(String name)
        Field a = personClass.getField("a");
        // 获取成员变量a的值
        Person p = new Person();
        Object value = a.get(p);
        System.out.println(value);
        // 设置a的值
        a.set(p, "张三");
        System.out.println(p);

        System.out.println("===============");

        // Field[] getDeclaredFields()
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        // Field getDeclaredField(String name)
        Field d = personClass.getDeclaredField("d");
        // setAccessible(true)：忽略访问权限修饰符的安全检查，暴力反射
        d.setAccessible(true);
        Object value2 = d.get(p);
        System.out.println(value2);
    }
}
