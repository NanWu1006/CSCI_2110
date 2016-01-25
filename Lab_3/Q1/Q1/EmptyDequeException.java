package Q1;

/**
 * Created by KanzakiMirai on 1/23/16.
 */
public class EmptyDequeException extends RuntimeException {
    public EmptyDequeException() {
        super("Target Deque is empty");
    }
}
