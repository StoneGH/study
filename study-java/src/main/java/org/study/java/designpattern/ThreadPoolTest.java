package org.study.java.designpattern;

import java.util.concurrent.*;

/**
 * Created by shitao on 2018/3/22.
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 15, 0, TimeUnit.MINUTES, new SynchronousQueue<Runnable>());
        for (int i = 0; i < 20; i++) {
            MyTask myTask = new MyTask(i);
            executor.submit(myTask);
            System.out.println("线程池中线程数目：" + executor.getPoolSize() + ",队列中等待执行的任务数目：" + executor.getQueue().size() + ",已经执行完的任务数：" + executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
}

class MyTask extends Thread {
    private int taskNum;

    public MyTask(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public void run() {
        System.out.println("正在执行Task " + taskNum);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task " + taskNum + "执行完毕。");
    }
}
