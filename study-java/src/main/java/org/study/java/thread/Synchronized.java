package org.study.java.thread;


/**
 * Synchronized方法的弊端
 * Created by shitao on 2018/7/2.
 */
public class Synchronized {
    public static void main(String[] args) {
        Task task = new Task();
        MyThread12 thread12 = new MyThread12(task);
        thread12.start();
        MyThread12 thread121 = new MyThread12(task);
        thread121.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long beginTime = CommonUtils.beginTime1;
        if (CommonUtils.beginTime2 < CommonUtils.beginTime1) {
            beginTime = CommonUtils.beginTime2;
        }
        long endTime = CommonUtils.endTime1;
        if (CommonUtils.endTime2 < CommonUtils.beginTime1) {
            endTime = CommonUtils.endTime2;
        }
        System.out.println("耗时：" + ((endTime - beginTime) / 1000));
    }
}

class Task {
    private String getData1;
    private String getData2;

    public synchronized void doLongTimeTask() {
        try {
            System.out.println("begin task");
            Thread.sleep(3000);
            getData1 = "长时间处理任务后从远程返回的值1 threadName=" + Thread.currentThread().getName();
            getData2 = "长时间处理任务后从远程返回的值2 threadName=" + Thread.currentThread().getName();
            System.out.println(getData1);
            System.out.println(getData2);
            System.out.println("end task");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CommonUtils {
    public static long beginTime1;
    public static long endTime1;
    public static long beginTime2;
    public static long endTime2;
}

class MyThread12 extends Thread {
    private Task task;

    public MyThread12(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        CommonUtils.beginTime1 = System.currentTimeMillis();
        task.doLongTimeTask();
        CommonUtils.endTime1 = System.currentTimeMillis();
    }
}
