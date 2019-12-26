package org.study.java.designpattern.structure.state;

/**
 * @Auther: Stone
 * @Date: 2019-07-16 14:44
 * @Description: 类描述
 */
public class CloseState extends LiftState {
    public void open() {
        super.context.setLiftState(Context.opendState);
        super.context.getLiftState().open();
    }

    public void close() {
        System.out.println("电梯门关了");
    }

    public void run() {
        super.context.setLiftState(Context.runState);
        super.context.getLiftState().run();
    }

    public void stop() {
        super.context.setLiftState(Context.stopState);
        super.context.getLiftState().stop();
    }
}
