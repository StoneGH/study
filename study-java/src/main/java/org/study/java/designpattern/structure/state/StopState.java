package org.study.java.designpattern.structure.state;

/**
 * @Auther: Stone
 * @Date: 2019-07-16 14:46
 * @Description: 类描述
 */
public class StopState extends LiftState {
    public void open() {
        super.context.setLiftState(Context.opendState);
        super.context.getLiftState().open();
    }

    public void close() {

    }

    public void run() {
        super.context.setLiftState(Context.runState);
        super.context.getLiftState().run();
    }

    public void stop() {
        System.out.println("电梯停止");
    }
}
