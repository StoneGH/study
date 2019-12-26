package org.study.java.designpattern.structure.state;

/**
 * @Auther: Stone
 * @Date: 2019-07-16 14:38
 * @Description: 电梯状态
 */
public abstract class LiftState {
    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void open();

    public abstract void close();

    public abstract void run();

    public abstract void stop();
}
