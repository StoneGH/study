package org.study.java.designpattern.structure.state;

/**
 * @Auther: Stone
 * @Date: 2019-07-16 14:48
 * @Description: 类描述
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setLiftState(new CloseState());
        context.open();
        context.close();
        context.run();
        context.stop();
    }
}
