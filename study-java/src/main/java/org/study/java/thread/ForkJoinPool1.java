package org.study.java.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

public class ForkJoinPool1 extends RecursiveAction {

    /**
     *
     */
    private static final long serialVersionUID = 8544674431352769183L;

    /**
     * 每个小任务，最多只打印50个数
     */
    private static final int threshold = 50;

    /**
     * 打印任务的开始
     */
    private int start;

    /**
     * 答应任务的结束
     */
    private int end;

    public ForkJoinPool1() {
    }

    public ForkJoinPool1(int start, int end) {
        super();
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - start < threshold) {
            for (int i = start; i < end; i++) {
                System.out.println(Thread.currentThread().getName() + "i的值：" + i);
            }
        } else {

            // 当end与start之间的差大于threshold，及打印的数超过50个时，将大任务分解成两个小任务。
            int middle = (start + end) / 2;
            ForkJoinPool1 left = new ForkJoinPool1(start, middle);
            ForkJoinPool1 right = new ForkJoinPool1(middle, end);

            // 并行执行两个小任务
            left.fork();
            right.fork();
        }
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(new ForkJoinPool1(0, 101));

        try {
            // 阻塞等待所有线程完成
            pool.awaitTermination(2, TimeUnit.SECONDS);
            // 关闭线程池
            pool.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
