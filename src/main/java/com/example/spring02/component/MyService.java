package com.example.spring02.component;

public class MyService {
    private MyDao myDao;

    public void setMyDao(MyDao myDao) {
        this.myDao = myDao;
    }

    public void Service(){
        System.out.println("MyService.service()");
        myDao.get();
    }
}
