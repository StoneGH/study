package org.study.java.thread;

/**
 * Created by shitao on 2018/4/12.
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        MyThread1 myThread1 = new MyThread1(lock);
        myThread1.start();
        myThread1.sleep(3000);
        MyThread2 myThread2 = new MyThread2(lock);
        myThread2.start();
    }
}

class MyThread1 extends Thread {
    private Object lock;

    public MyThread1(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                System.out.println("开始 wait time=" + System.currentTimeMillis());
                lock.wait();
                System.out.println("结束 wait time=" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread2 extends Thread {
    private Object lock;

    public MyThread2(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("开始 notify time=" + System.currentTimeMillis());
            lock.notify();
            System.out.println("结束 notify time=" + System.currentTimeMillis());
        }
    }
}