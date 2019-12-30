package org.study.java.designpattern.producer_consumer;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by shitao on 2018/7/3.
 */
public class BreadShop {
    private ArrayList<Bread> breadArrayList = new ArrayList<Bread>();
    private BreadType[] breadTypes = {BreadType.MEAT, BreadType.VEGE};
    private int count = 0;
    private final int MAX_COUNT = 20;


    enum BreadType {
        MEAT, VEGE
    }

    class Bread {
        private BreadType breadType;

        public Bread(BreadType breadType) {
            this.breadType = breadType;
        }

    }

    class Producer implements Runnable {
        private boolean isWork = false;

        public Producer() {
            this.isWork = true;
        }

        public void makeBread(Bread bread) {
            breadArrayList.add(bread);
            switch (bread.breadType) {
                case MEAT:
                    System.out.println("make a meat break");
                    break;
                case VEGE:
                    System.out.println("make a vage break");
                    break;
            }
        }

        public void run() {
            try {
                while (isWork) {
                    synchronized (breadArrayList) {
                        if (breadArrayList.size() > 0) {
                            breadArrayList.wait();
                        }
                        for (int i = 0; i < 10; i++) {
                            int type = new Random().nextInt(2);
                            Bread bread = new Bread(breadTypes[type]);
                            this.makeBread(bread);
                        }
                        count += 10;
                        breadArrayList.notifyAll();
                    }
                    if (count >= MAX_COUNT) {
                        isWork = false;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                isWork = false;
            }
        }
    }

    class Consumer implements Runnable {
        private int id;

        public Consumer(int id) {
            this.id = id;
        }

        public void eat(Bread bread) {
            BreadType breadType = bread.breadType;
            switch (breadType) {
                case MEAT:
                    System.out.println("姓 " + id + " eat a meat bread");
                    break;
                case VEGE:
                    System.out.println("姓 " + id + " eat a vage bread");
                    break;
            }
        }

        public void run() {
            while (true) {
                try {
                    synchronized (breadArrayList) {
                        if (breadArrayList.size() == 0) {
                            if (count >= MAX_COUNT) {
                                break;
                            }
                            breadArrayList.notifyAll();
                            breadArrayList.wait();
                        } else {
                            Bread bread = breadArrayList.remove(0);
                            this.eat(bread);
                        }
                    }
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }

        }
    }

    public static void main(String[] args) {
        BreadShop bs = new BreadShop();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(bs.new Consumer(i));
            t.start();
        }
        Thread producerThread = new Thread(bs.new Producer());
        producerThread.setPriority(Thread.MAX_PRIORITY);
        producerThread.start();
    }
}