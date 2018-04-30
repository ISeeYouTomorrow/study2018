package com.lxl;

/**
 * 线程中断
 * @author lxl lukas
 * @description
 * @create 2018/4/17
 */
public class BlockTest {

    private static volatile boolean isBlock = true;

    static class Mytask implements Runnable {
        public void run() {
            while (isBlock && !Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(100);

                    System.out.println("current thread is :"+Thread.currentThread().getId());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupted();
                }
            }
        }

        public void cancel() {
            isBlock = false;
            Thread.currentThread().interrupt();
        }
    }


    public static void main(String[] args) {
        Mytask task = new Mytask();
        Thread mytask = new Thread(task);
        mytask.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.cancel();
    }


}
