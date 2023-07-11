package exam;

public class Book { // exam.Book 클래스
    private String title; // title 인스턴스 field
    private int price; // price 인스턴스 field

    public Book(){

    }
    // exam.Book 생성자
    public Book(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    } //getter메소드 or Title프로퍼티

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
