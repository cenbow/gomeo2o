package io.terminus.ecp.common.exception;

/**
 * Created by yangzefeng on 15/1/12
 */
public class StateMachineException extends RuntimeException {

    public StateMachineException() {
        super();
    }

    public StateMachineException(String message) {
        super(message);
    }

    public StateMachineException(Throwable t) {
        super(t);
    }

    public StateMachineException(String message, Throwable t) {
        super(message, t);
    }
}
