package com.lxl;

/**
 * @author lxl lukas
 * @description
 * @create 2018/4/17
 */
public class User {
    static String CITY = "NEW YORK";
    private int age;

    private String city;

    public User(int age, String city) {
        this.age = age;
        this.city = city;
    }

    public User() {
    }

    public synchronized void changeCity() {
        this.city = "Lon don";

        notifyAll();
    }

    public synchronized void changeAge() {
        this.age = 20;

        notifyAll();
    }

    public synchronized void waitAge() {
        while (this.age < 30) {
            try {
                wait();

                System.out.println("wait age ["+Thread.currentThread().getId()
                        +"] is notified!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("the age is "+this.age);//业务工作
    }

    public synchronized void waitCity() {
        while (this.city.equals(CITY)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("wait city ["+Thread.currentThread().getId()
                    +"] is notified!");
        }
        System.out.println("the city is "+this.city);//业务工作
    }

}
