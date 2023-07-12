package com.example.spring02;

import com.example.spring02.component.MyDao;
import com.example.spring02.component.MyService;
import exam.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplicationContextExam2 {
    public static void main(String[] args){
        // 인스턴스를 인터페이스 타입을 참조할 수 있다.
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyService myService = context.getBean("myService", MyService.class);
        MyDao myDao = context.getBean("myDao", MyDao.class);

        myService.Service();

    }
}
