package com.lxl;

import java.util.concurrent.TimeUnit;

/**
 * @author lxl lukas
 * @description daemon线程不一定执行try{ } finally 代码块
 * @create 2018/4/17
 */
public class DaemonThread {

    static class Daemon implements Runnable{
        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(1000);
                System.out.println("DaemonThread run.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread daemon = new Thread(new Daemon());
        daemon.setDaemon(true);
        daemon.start();
        Thread.sleep(10000);
    }
}
