## ApplicationContext
- ApplicationContext는 다양한 인터페이스를 상속받고 있다.
- 스프링 컨테이너의 핵심 인터페이스

      org.springframework.context
      Interface ApplicationContext

      
- 그중에서도 BeanFactory도 ApplicationContext는 상속받는다.

      org.springframework.beans.factory
      Interface BeanFactory

---

## ApplicationContext를 구현하고 있는 대표적인 클래스

- CLASSPATH에서 XML설정파일을 읽어들여 동작한다.

        org.springframework.context.support
        Class ClassPathXmlApplicationContext

---

## 스프링 프레임워크의 핵심 모듈

- Core Container 부분이 가장 핵심
- Gradle에서 아래의 라이브러리를 추가한다.

      implementation group: 'org.springframework', name:
      'spring-context', version: '5.3.23'

![img.png](img.png)

- 외부 개발을 위한 MVC관련 라이브러리
- 데이터베이스 정보를 읽어오기 위한 것들

---

## Spring ApplicationContext를 사용해보자

    package com.example.spring02;

    import exam.Book;
    import org.springframework.context.ApplicationContext;
    import org.springframework.context.support.ClassPathXmlApplicationContext;

    public class SpringApplicationContextExam {
        public static void main(String[] args){
        // 인스턴스를 인터페이스 타입을 참조할 수 있다.
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); <- 여기서 applicationContext.xml 설정파일은 ClassPath에 있어야 한다. 인텔리제이에서 java폴더와 resources 폴더가 ClassPath이다.
        // object 타입으로 반환하기 때문에 Book 으로 형변환을 해주는 것이다.
        // Book book1 = (Book)context.getBean("book1");
        Book book1 = context.getBean("book1", Book.class);
        book1.setTitle("즐거운 Spring Boot");
        book1.setPrice(5000);

        System.out.println(book1.getTitle());
        System.out.println(book1.getPrice());

        Book book2 = (Book)context.getBean("book2");
        System.out.println(book2.getTitle());
    }
}

---

## MyService & MyDao 클래스다이어그램
- 프로그래머가 직접 인스턴스를 생성하고 주입하는 방법
- 연관관계
    - MyService가 MyDao를 가진다.

![img_1.png](img_1.png)

- setter 주입

        MyService myService = new MyService();
        MyDao myDao = new MyDao();
        MyService.setMyDao(MyDao);

- 생성자에 주입

        MyService myService = new MyService(new MyDao());

---

## Spring 설정으로 주입

    MyService myService = new MyService();
    MyDao myDao = new MyDao();
    MyService.setMyDao(MyDao);

    <bean id="myService" class="com.example.spring02.component.MyService">
    <!-- setMyDao를 호출하는 프로퍼티 -->
        <property name="myDao" ref="myDao"></property>
    </bean>
    <bean id="myDao" class="com.example.spring02.component.MyDao"></bean>

xml파일로 선언적으로 의존성을 주입한다. -> ApplicationContext가 Bean을 관리한다.

---

스프링 초반에 xml파일을 많이 사용함 -> 어려워함, 에러 체크 안됨 -> 짜증

다른 방법은 없나? ->  AnnotationConfigApplicationContext

## Annotation을 이용한 설정

- Spring 3.0부터 등장
- Annotation 기반 (Java Config, Component Scan)

      org.springframework.context.annotation
      Class AnnotationConfigApplicationContext

---

@Configuration이 붙어있으면 설정 파일로 인식해서 인스턴스로 만들어서 관리한다.

Configuration도 Component와 사실상 같은 것이다. 다만 이름을 더 쉽게 알기위해 설정과 관련된 Component다 라는 의미 부여

@Bean이 붙은 것들은 컨테이너에서 기본적으로 싱글턴으로 생성하고 관리한다.

다양한 오픈소스를 가져다 쓰기 때문에 그 사람이 @Component가 안붙어 있을 수 있기 때문에 그걸 스프링한테 Bean으로 관리하기 위해 부탁하기 위해서는
자바 Config 설정에서 인스턴스로 만들라고 시키던가 xml설정을 해줘야 한다.

---

## Web Application

- 웹 애플리케이션 또는 웹 앱은 소프트웨어 공학적 관점에서 인터넷이나 인트라넷을 통해 웹 브라우저에서 이용할 수 있는 응용 소프트웨어를 맗한다.

---

## Web Application Server
 
- 웹 애플리케이션 서버(Web Application Server, 약자 WAS)는 웹 애플리케이션과 서버 환경을 만들어 동작시키는 기능을 제공하는 소프트웨어 프레임워크이다.[1] 인터넷 상에서 HTTP를 통해 사용자 컴퓨터나 장치에 애플리케이션을 수행해 주는 미들웨어(소프트웨어 엔진)로 볼 수 있다. 웹 애플리케이션 서버는 동적 서버 콘텐츠를 수행하는 것으로 일반적인 웹 서버와 구별이 되며, 주로 데이터베이스 서버와 같이 수행이 된다. 한국에서는 일반적으로 "WAS" 또는 "WAS S/W"로 통칭하고 있으며 공공기관에서는 "웹 응용 서버"로 사용되고, 영어권에서는 "Application Server" (약자 AS)로 불린다.

- 자바 EE 표준준수 웹 애플리케이션 서버
  - 스프링, 스프링 부트를 사용하는 사용자는 이것을 WAS라고 한다.

---

## Java EE에 대한 표준을 일부 준수

- 아파치 톰캣(Apache Tomcat): 오픈 소스 재단 아파치 소프트웨어 재단의 오픈 소스 소프트웨어

---

## Java EE Platform Specification

- https://javaee.github.io/javaee-spec/

---

## Java EE에서 Jakarta EE로의 전환

- https://www.samsungsds.com/kr/insights/java_jakarta.html

---

## Java 웹 프로그래밍

- Java언어로 웹 어플리케이션을 만들겠다.
- 웹 어플리케이션이 실행될 수 있는 WAS가 필요하다.
  - iPhone앱은 IOS위에서 동작한다.
- Servlet/JSP를 실행할 수 있는 환경(Servlet 컨테이너)
  - JSP도 알고보면 Servlet기술로 만들어진다.
  - Servlet 컨테이너는 WAS안에 있다.
  - WAS는 여러개의 웹 어플리케이션을 실행할 수 있다.
  - 대표적인 WAS는 Tomcat

---

## Tomcat?

- https://tomcat.apache.org/
  - apache-tomcat-8.5.82.tar.gz를 다운받는다.
  - 특정 폴더에 복사한 후 압축을 해제
  - apache-tomcat-8.5.82/bin
    - startup.bat파일을 실행한다.
    - shutdown.bat을 실행하면 종료된다.

---

## startup.sh을 수정한 후 실행한다.

- 마지막 줄  

      exec "$PRGDIR"/"$EXECUTABLE" start "$@"

- 다음과 같이 수정한다.

      exec "$PRGDIR"/"$EXECUTABLE" run "$@"

- 백그라운드가 아닌 포그라운드로 실행된다.

---

## Tomcat이 기본으로 제공하는 Web Application

apache-tomcat-8.5.82/webapps

Root, docs, examples등이 있다.

---

## Tomcat이 성공적으로 실행되었다면

- http://localhost:8080/
  - ROOT 웹 어플리케이션을 말한다.
  
- http://localhost:8080/docs/
  - docs 웹 어플리케이션을 말한다.
  
- http://localhost:8080/examples/
  - examples 웹 어플리케이션을 말한다.
  
---

## examples 폴더의 구조

META-INF, WEB-INF, index.html, jsp, servlets등이 있다.

---

## Tomcat을 이용한 웹 어플리케이션을 만든다는 의미는?

http://localhost:8080/
- 내가 만든 사이트가 보여지려면?
- webapps/ROOT의 내용을 내가 만든 내용으로 바꾸면 된다.
- Tomcat 서버에 내가 만든 웹 어플리케이션을 deploy한다.

---

## 서버와 브라우저의 동작




    




