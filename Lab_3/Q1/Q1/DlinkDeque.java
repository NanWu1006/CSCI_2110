package Q1;

/**
 * Created by KanzakiMirai on 1/23/16.
 *
 * @author Diqi Zeng
 */
public class DlinkDeque<E> implements Deque<E> {
    DoublyLinkedList<E> data;

    public DlinkDeque() {
        this.data = new DoublyLinkedList<>();
    }

    /**
     * return the size
     * @return size
     */
    public int size() {
        return this.data.size();
    }

    /**
     * check if empty
     * @return bool
     */
    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    /**
     * get the first value
     * @return value
     * @throws EmptyDequeException
     */
    public E getFirst() throws EmptyDequeException {
        return this.data.first();
    }

    /**
     * get the last value
     * @return value
     * @throws EmptyDequeException
     */
    public E getLast() throws EmptyDequeException {
        return this.data.last();
    }

    /**
     * add in first
     * @param element value
     */
    public void addFirst(E element) {
        this.data.addFirst(element);
    }

    /**
     * add in tail
     * @param element value
     */
    public void addLast(E element) {
        this.data.addLast(element);
    }

    /**
     * remove from head
     * @return the removed value
     * @throws EmptyDequeException
     */
    public E removeFirst() throws EmptyDequeException {
        if (this.data.isEmpty()) {
            throw new EmptyDequeException();
        }
        else {
            return this.data.removeFirst();
        }
    }

    /**
     * remove from tail
     * @return the removed value
     * @throws EmptyDequeException
     */
    public E removeLast() throws EmptyDequeException {
        if (this.data.isEmpty()) {
            throw new EmptyDequeException();
        }
        else {
            return this.data.removeLast();
        }
    }

    public String toString() {
        return this.data.toString();
    }
}