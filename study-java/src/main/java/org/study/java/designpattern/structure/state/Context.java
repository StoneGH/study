package org.study.java.designpattern.structure.state;

/**
 * @Auther: Stone
 * @Date: 2019-07-16 14:38
 * @Description: 类描述
 */
public class Context {
    public final static OpenState opendState = new OpenState();
    public final static CloseState closeState = new CloseState();
    public final static RunState runState = new RunState();
    public final static StopState stopState = new StopState();
    private LiftState liftState;

    public LiftState getLiftState() {
        return liftState;
    }

    public void setLiftState(LiftState liftState) {
        this.liftState = liftState;
        this.liftState.setContext(this);
    }

    public void open() {
        this.liftState.open();
    }

    public void close() {
        this.liftState.close();
    }

    public void run() {
        this.liftState.run();
    }

    public void stop() {
        this.liftState.stop();
    }
}
