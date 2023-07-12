package com.example.spring02.component;

public class MyService extends MyDao {
    private MyDao myDao; // 필드

    // setter 메소드
    // myDao 프로퍼티
    public void setMyDao(MyDao myDao) {
        this.myDao = myDao;
    }

    public void Service(){
        System.out.println("MyService.service()");
        // myDao를 주입하지 않았다면 NullPointerException 발생
        myDao.get();
    }
}
