package com.example.spring02.config;

import com.example.spring02.component.MyDao;
import com.example.spring02.component.MyService;
import exam.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Java Config설정을 AnnotationConfigApplicationContext가 읽어들인다.
// ApplicationConfig에 대한 인스턴스를 만든다.
@Configuration
public class ApplicationConfig {
    public ApplicationConfig(){
        System.out.println("ApplicationConfig()");
    }

    // <bean id="book1" class="exam.Book"></bean> 와 같은거다.
    // 메소드 이름이 id
    // Spring 컨테이너가 내부적으로 관리한다.
    @Bean
    public Book book1(){
        return new Book(); // exam.Book
    }


//    <bean id="book2" class="exam.Book">
//        <property name="title" value="즐거운 자바"></property>
//        <property name="price" value="5000"></property>
//    </bean>  이 설정과 아래 설정이 같은 것이다.

    @Bean
    public Book book2(){
        Book book = new Book();
        book.setTitle("즐거운 자바.");
        book.setPrice(9000);
        return book;
    }

//    <bean id="myService" class="com.example.spring02.component.MyService">
//    <!-- setMyDao를 호출하는 프로퍼티 -->
//        <property name="myDao" ref="myDao"></property>
//    </bean>
    @Bean
    public MyService myService(MyDao myDao){ // 이 안에다가 MyDao를 주입하면 컨테이너가 MyDao를 만들고 이것을 만들어준다.
        MyService myService = new MyService();
        myService.setMyDao(myDao);
        return myService;
    }

    @Bean
    public MyDao myDao(){
        return new MyDao();
    }
}
