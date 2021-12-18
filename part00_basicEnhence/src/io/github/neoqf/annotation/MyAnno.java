package io.github.neoqf.annotation;

public @interface MyAnno {

    int value();
    String show2();
    Person per();
    MyAnno2 anno2();
    String[] strs();

}
