package exam;

public class ApplicationContextMain {
    public static void main(String[] args) throws Exception{
        ApplicationContext context = ApplicationContext.getInstance(); // Bean을 관리하는 거다보니 이 친구도 메모리에 하나만 있게 하고싶다.
//        ApplicationContext context2 = ApplicationContext.getInstance();
//        if(context == context2){
//            System.out.println("2개의 context는 같다.");
//        }
        Book book = (Book)context.getBean("book1"); // id에 해당하는 인스턴스를 달라.
        book.setPrice(5000);
        book.setTitle("Java");

        System.out.println(book.getPrice());
        System.out.println(book.getTitle());

        System.out.println("--------------");
        // 기존 HashMap에 저장되어 있던 객체를 리턴해준다.
        Book book2 = (Book)context.getBean("book1"); // id에 해당하는 인스턴스를 달라. -> boo1과 같은 인스턴스를 줌
        System.out.println(book2.getTitle()); // getBean을 할때마다 내부적으로 인스턴스를 새로 생성하기 때문이다.

        if(book == book2){ // 원래는 같아야한다 -> 참조가 같다 == 메모리가 하나다.
            System.out.println("같은 인스턴스");

        }else {
            System.out.println("다른 인스턴스");
        }
    }
}
