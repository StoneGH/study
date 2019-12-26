package org.study.java.thread;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPool2 extends RecursiveTask<Integer> {

    /**
     *
     */
    private static final long serialVersionUID = 7976676204723621499L;

    /**
     * 每个小任务，最多只能累加20个数。
     */
    private static final int threshold = 20;

    private int arr[];

    /**
     * 开始
     */
    private int start;

    private int end;

    public ForkJoinPool2() {
    }

    public ForkJoinPool2(int[] arr, int start, int end) {
        super();
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        if (end - start < threshold) {
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
            return sum;
        } else {
            int middle = (start + end) / 2;
            ForkJoinPool2 left = new ForkJoinPool2(arr, start, middle);
            ForkJoinPool2 right = new ForkJoinPool2(arr, middle, end);
            left.fork();
            right.fork();
            return left.join() + right.join();
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int arr[] = new int[1100];
        Random random = new Random();
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            int tmp = random.nextInt(20);
            total += (arr[i] = tmp);
        }
        System.out.println("正确的total：" + total);
        ForkJoinPool pool = new ForkJoinPool();
        Future<Integer> future = pool.submit(new ForkJoinPool2(arr, 0, arr.length));
        System.out.println(future.get());
        pool.shutdown();
    }

}
