package org.study.java.designpattern.producer_consumer;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 生产者
 * Created by shitao on 2018/3/22.
 */
public class AttachmentProcess {
    private final String attachment_store_base_dir = "/Users/shitao/Downloads/";
    /**
     * channel
     */
    private final Channel<File> channel = new BlockingQueueChannel<File>(new ArrayBlockingQueue<File>(200));

    private final AbstractTerminatableThread indexingThread = new AbstractTerminatableThread() {
        @Override
        protected void doRun() throws Exception {
            File file = null;
            file = channel.take();
            try {
                indexFile(file);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }

        }

        @Override
        public void terminate() {

        }

        private void indexFile(File file) throws Exception {

        }

    };

    public void init() {
        indexingThread.start();
    }


    public void shutdown() {
        indexingThread.terminate();
    }

}
