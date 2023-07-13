package com.example.spring02;

import com.example.spring02.component.MyDao;
import com.example.spring02.component.MyService;
import com.example.spring02.component.MyUtil;
import exam.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplicationContextExam3 {
    public static void main(String[] args){
        // AnnotationConfigApplicationContext의 생정자는 base package
        ApplicationContext context = new AnnotationConfigApplicationContext("com.example.spring02");
        Book book1 = context.getBean("book1", Book.class);
        book1.setTitle("즐거운 Spring Boot");
        book1.setPrice(5000);

        System.out.println(book1.getTitle());
        System.out.println(book1.getPrice());

        // 스프링 컨테이너는 Bean을 기본적으로 싱글턴으로 관리한다. -> 메모리에 하나만 올린다.
        Book book11 = context.getBean("book1", Book.class);
        System.out.println(book11.getTitle());
        System.out.println(book11.getPrice());

        Book book2 = context.getBean("book2", Book.class);
        System.out.println(book2.getTitle());

        MyDao myDao = context.getBean("myDao", MyDao.class);
        myDao.get();

        MyService myService = context.getBean("myService2", MyService.class);
        myService.Service();

//        MyUtil myUtil = context.getBean("myUtil2", MyUtil.class);
//        myUtil.print();

        MyUtil myUtil = context.getBean("myUtil", MyUtil.class);
        myUtil.print();
    }
}
