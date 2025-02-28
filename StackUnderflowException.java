package notationpackage;


public class StackUnderflowException extends RuntimeException {
    public StackUnderflowException() {
        super("Stack is empty.");
    }
}

