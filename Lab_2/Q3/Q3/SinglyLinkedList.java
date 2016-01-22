package Q3;

/**
 * Created by KanzakiMirai on 1/21/16.
 */
public class SinglyLinkedList<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        else {
            return head.getElement();
        }
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        else {
            return tail.getElement();
        }
    }

    /**
     * return the element on specific position
     * @param count the expected index
     * @return NULL if cannot find, otherwise that value
     */
    public E get(int count) {
        Node<E> currentNode = head;
        for (int i = 0; i <= count - 1; i++) {
            currentNode = currentNode.getNext();
        }
        if (currentNode == null) {
            return null;
        }
        else {
            return currentNode.getElement();
        }
    }

    /**
     * setting the new value on index count
     * @param count the expected index
     * @param newValue the expected new value
     * @return NULL if cannot find, otherwise that value
     */
    public E set(int count, E newValue) {
        Node<E> currentNode = head;
        Node<E> oldNextNode = null;
        for (int i = 0; i <= count - 1; i++) {
            currentNode = currentNode.getNext();
        }
        if (currentNode != null) {
            oldNextNode = currentNode.getNext().getNext();
            if (oldNextNode == null) {
                Node<E> tmp = new Node<>(newValue, null);
                tail = tmp;
                currentNode.setNext(tmp);
            }
            else {
                currentNode.setNext(new Node<>(newValue, oldNextNode));
            }
            return newValue;
        }
        else {
            return null;
        }
    }

    /**
     * perform an ADD operation on this linked list
     * @param newValue new value
     * @return the new value
     */
    public E add(E newValue) {
        Node<E> newNode = new Node<>(newValue, null);
        if (head == null) {
            head = newNode;
        }
        else {
            Node<E> currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
            tail = newNode;
        }
        size++;
        return newValue;
    }

    public String toString() {
        String result = "";
        Node<E> currentNode = head;
        while (currentNode.getNext() != null) {
            result = result + currentNode.getElement() + ", ";
            currentNode = currentNode.getNext();
        }
        result = result + currentNode.getElement() + ", ";
        return String.format("[%s]", result.substring(0, result.length() - 2));
    }
}

class Node<E> {
    private E element;
    private Node<E> next;
    public Node(E e, Node<E> n) {
        element = e;
        next = n;
    }
    public E getElement() {
        return element;
    }
    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}