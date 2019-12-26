package org.study.java.designpattern.structure.state;

/**
 * @Auther: Stone
 * @Date: 2019-07-16 14:46
 * @Description: 类描述
 */
public class RunState extends LiftState {
    public void open() {

    }

    public void close() {

    }

    public void run() {
        System.out.println("电梯运行");
    }

    public void stop() {
        super.context.setLiftState(Context.stopState);
        super.context.getLiftState().stop();
    }
}
