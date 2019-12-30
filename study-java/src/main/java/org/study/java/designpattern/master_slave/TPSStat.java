package org.study.java.designpattern.master_slave;

import javafx.concurrent.Worker;

import java.io.BufferedReader;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by shitao on 2018/4/2.
 */
public class TPSStat {
    public static void main(String[] args) {
        String logBaseDir = args[0];//介绍日志文件所在目录
        String excludedOpeartionNames = "";//忽略的操作名列表
        String includedOpeartionNames = "*";//指定要统计在内的操作名列表
        String destinationSysName = "";//指定要统计在内的目标设备名
        int argc = args.length;//
        if (argc > 2) {
            excludedOpeartionNames = args[1];
        } else if (argc > 3) {
            excludedOpeartionNames = args[2];
        } else if (argc > 4) {
            excludedOpeartionNames = args[3];
        }
    }
}

/**
 * 模式角色：Master-Slave.Master
 */
class Master {
    private final String logFileBaseDir;
    private final String excludedOpeartionNames;
    private final String includedOpeartionNames;
    private final String destinationSysName;


    private static final int NUMBER_OF_FILES_FOR_EACH_DISPATCH = 5;//每次派发给Slave线程的文件个数
    private static final int WORKER_COUNT = Runtime.getRuntime().availableProcessors();

    public Master(String logFileBaseDir, String excludedOpeartionNames, String includedOpeartionNames, String destinationSysName) {
        this.logFileBaseDir = logFileBaseDir;
        this.excludedOpeartionNames = excludedOpeartionNames;
        this.includedOpeartionNames = includedOpeartionNames;
        this.destinationSysName = destinationSysName;
    }

    public ConcurrentMap<String, AtomicInteger> calculate(BufferedReader fileNamesReader) {
        ConcurrentMap<String, AtomicInteger> repository = new ConcurrentSkipListMap<String, AtomicInteger>();
        //创建工作者线程
        Worker[] workers = createAndStartWorkders(repository);
        return null;

    }

    private Worker[] createAndStartWorkders(ConcurrentMap<String, AtomicInteger> repository) {
        Worker[] workers = new Worker[WORKER_COUNT];
        Worker worker;
        Thread.UncaughtExceptionHandler eh = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                e.printStackTrace();
            }
        };
        for (int i = 0; i < WORKER_COUNT; i++) {
//            worker = new WOr;
//            workers[i] = worker;
//            worker.set();
//            worker.start();
        }
        return workers;
    }
}
