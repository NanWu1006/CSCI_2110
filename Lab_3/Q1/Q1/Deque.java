package Q1;

/**
 * Created by KanzakiMirai on 1/23/16.
 */
public interface Deque<E> {
    public int size();
    public boolean isEmpty();
    public E getFirst() throws EmptyDequeException;
    public E getLast() throws EmptyDequeException;
    public void addFirst(E element);
    public void addLast(E element);
    public E removeFirst() throws EmptyDequeException;
    public E removeLast() throws EmptyDequeException;
}