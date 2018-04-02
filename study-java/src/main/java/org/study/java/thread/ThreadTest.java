package org.study.java.thread;

/**
 * Created by shitao on 2018/3/19.
 */
public class ThreadTest {
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.setA("a");
        demo.setB("b");
        ThreadClass t1 = new ThreadClass(demo);
        t1.setName("A");
        t1.start();

        ThreadClass t2 = new ThreadClass(demo);
        t2.setName("B");
        t2.start();


    }
}

class Demo {

    public void method1() {
        for (int i = 0; i < 100; i++) {
            System.out.println("async print - thread:" + Thread.currentThread().getName() + ":" + i);
        }
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println("sync print - thread:" + Thread.currentThread().getName() + ":" + i);
            }
        }
    }

    private String a;
    private String b;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public void method2() {
        if ("a".equals(a)) {
            synchronized (a) {
                System.out.println("执行method2 的 a");
                synchronized (b) {
                    System.out.println("执行method2 的 a2");
                }
            }
        }
        if ("b".equals(b)) {
            synchronized (b) {
                System.out.println("执行method2 的 b");
                synchronized (a) {
                    System.out.println("执行method2 的 b2");
                }
            }
        }
    }
}

class ThreadClass extends Thread {

    Demo demo;

    public ThreadClass(Demo demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        super.run();
        demo.method2();
    }
}

class ThreadClass1 extends Thread {

    Demo demo;

    public ThreadClass1(Demo demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        super.run();
        demo.method2();
    }
}
