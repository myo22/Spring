## * 스프링 컨테이너의 핵심 인터페이스 ApplicationContext
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
