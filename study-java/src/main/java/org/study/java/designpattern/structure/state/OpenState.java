package org.study.java.designpattern.structure.state;

/**
 * @Auther: Stone
 * @Date: 2019-07-16 14:40
 * @Description: 类描述
 */
public class OpenState extends LiftState {
    public void open() {
        System.out.println("电梯门开着");
    }

    public void close() {
        super.context.setLiftState(Context.closeState);
        super.context.getLiftState().stop();
    }

    public void run() {
    }

    public void stop() {

    }
}
