package com.example.spring02.component;

import org.springframework.stereotype.Component;

// Component Scan방식
//AnnotationConfigApplicationContext이 @Component를 찾아서 인스턴스를 생성한다.
// value에 있는 값이 id가 된다.
@Component(value = "myUtil")
public class MyUtil {
    public MyUtil(){
        System.out.println("MyUtil()");
    }
    public void print(){
        System.out.println("MyUtil.print()");
    }
}
