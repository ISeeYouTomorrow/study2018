package com.lxl;

/**
 * @author lxl lukas
 * @description sleep方法是否会释放锁
 * @create 2018/4/17
 */
public class SleepTest {

    static Object lock = new Object();


    static class SleepThread implements Runnable {

        @Override
        public void run() {
            System.out.println("SleepThread "+Thread.currentThread().getName());

            try {
                Thread.sleep(5000);
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName()+ " take the lock");
                    System.out.println(Thread.currentThread().getName()+ " finish work");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class NotSleepThread implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName()+ " take the lock");
                System.out.println(Thread.currentThread().getName()+ " finish work");
            }
        }
    }

    public static void main(String[] args) {
        Thread sleep = new Thread(new SleepThread());

        Thread notSleep = new Thread((new NotSleepThread()));

        sleep.start();

        notSleep.start();

    }

}
