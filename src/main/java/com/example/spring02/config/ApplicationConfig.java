package com.example.spring02.config;

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
}
