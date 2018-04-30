package com.lxl;

/**
 * @author lxl lukas
 * @description
 * @create 2018/4/17
 */
public class TestUser {

    private static User user = new User(40,User.CITY);

    private static class CheckAge implements Runnable{

        @Override
        public void run() {
            user.waitAge();
        }
    }

    private static class CheckCity implements Runnable {
        @Override
        public void run() {
            user.waitCity();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i=0;i<3;i++){
            Thread ageThread = new Thread(new CheckAge());
            ageThread.start();

            Thread city = new Thread(new CheckCity());
            city.start();
        }

        Thread.sleep(3000);

        user.changeCity();
//        user.changeAge();
    }
}
