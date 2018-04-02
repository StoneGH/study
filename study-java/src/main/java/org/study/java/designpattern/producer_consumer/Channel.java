package org.study.java.designpattern.producer_consumer;

/**
 * 产品类型
 * Created by shitao on 2018/3/22.
 */
public interface Channel<P> {
    /**
     * 从通道中取出一个产品
     *
     * @return 产品
     * @throws InterruptedException
     */
    P take() throws InterruptedException;

    /**
     * 往通道中存入一个产品
     *
     * @param product 产品
     * @throws InterruptedException
     */
    void put(P product) throws InterruptedException;
}
