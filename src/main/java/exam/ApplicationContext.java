package exam;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ApplicationContext {
    // 1. 싱글턴 패턴 적용 - 자기 자신을 참조하는 static한 필드를 선언한다. 바로 초기화
    // static한 필드는 인스턴스가 만들어지지 않아도 자동으로 만들어진다.
    private static ApplicationContext instance = new ApplicationContext(); // 자기 자신안에서는 인스턴스가 만들어지기 떄문에 이걸 써먹어야 한다.

    //3. 1.에서 만든 인스턴스를 반환하는 static 메소드를 만든다.
    public static ApplicationContext getInstance(){
        return instance;
    }
    private Properties props;
    private Map objectmap;

    // 2. 싱글턴 패턴 적용 - 생성자를 private로 바꾼다
    private ApplicationContext(){
        props = new Properties(); // 자바가 기본으로 제공해주는 Properties 객체
        objectmap = new HashMap<String, Object>(); // 키값은 String타입 Value는 Object타입
        try {
            props.load(new FileInputStream("src/main/resources/Beans.properties")); // Beans.properties를 한번에 읽어들임
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Object getBean(String id) throws Exception{
        // 싱글턴으로 만들어주는 작업 메모리 하나에 다 올라가게
        // HashMap은 Key, value로 된 자료구조
        Object o1 = objectmap.get(id);
        if (o1 == null){
            String className = props.getProperty(id); //id값에 해당하는 설정을 달라
            // class name에 해당하는 문자열을 가지고 인스턴스를 생성할 수 있다.
            // Class.forName(className)은 CLASSPATH부터 className에 해당하는 클래스를 찾은 후
            // 그 클래스 정보를 반환한다.
            Class clazz = Class.forName(className); // 물론 className에 해당하는게 없으면 not found exception이 발생한다.
//        Method[] methods =  clazz.getMethods();
//        for(Method m : methods){
//            System.out.println(m.getName());
//        }

            // ClassLoader를 이용한 인스턴스 생성. *기본생성자가 있어야 한다.*
            Object o = clazz.newInstance(); // clazz정보를 이용해 인스턴스를 생성한다.
            objectmap.put(id, o); // 만든 인스턴스를 objectmap에다가 id란 이름으로 o를 put해준다.
            o1 = objectmap.get(id);
        }
        return o1;
    }
}
