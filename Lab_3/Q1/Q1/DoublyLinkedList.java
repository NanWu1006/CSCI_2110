package Q1;

/**
 * Created by KanzakiMirai on 1/21/16.
 */
public class DoublyLinkedList<E> {
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

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
            return header.getNext().getElement();
        }
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        else {
            return trailer.getPrev().getElement();
        }
    }

    public Node<E> getFirstNode() {
        if (isEmpty()) {
            return null;
        }
        else {
            return header.getNext();
        }
    }

    public Node<E> getLastNode() {
        if (isEmpty()) {
            return null;
        }
        else {
            return trailer.getPrev();
        }
    }

    /**
     * perform an ADD operation on this linked list
     * @param newValue new value
     * @return the new value
     */
    public E add(E newValue) {
        addBetween(newValue, trailer.getPrev(), trailer);
        return newValue;
    }

    /**
     * return the element on specific position
     * @param count the expected index
     * @return NULL if cannot find, otherwise that value
     */
    public E get(int count) {
        Node<E> currentNode = header;
        for (int i = 0; i <= count; i++) {
            currentNode = currentNode.getNext();
        }
        if (currentNode == null) {
            return null;
        }
        else {
            return currentNode.getElement();
        }
    }

    public Node<E> getNode(int count) {
        Node<E> currentNode = header;
        for (int i = 0; i <= count; i++) {
            currentNode = currentNode.getNext();
        }
        if (currentNode == null) {
            return null;
        }
        else {
            return currentNode;
        }
    }

    /**
     * setting the new value on index count
     * @param count the expected index
     * @param newValue the expected new value
     * @return NULL if cannot find, otherwise that value
     */
    public E set(int count, E newValue) {
        Node<E> currentNode = header;
        for (int i = 0; i <= count; i++) {
            currentNode = currentNode.getNext();
        }
        if (currentNode != null) {
            Node<E> newNode = new Node<>(newValue, currentNode.getPrev(), currentNode.getNext());
            currentNode.getNext().setPrev(newNode);
            currentNode.getPrev().setNext(newNode);
            return newNode.getElement();
        }
        else {
            return null;
        }
    }

    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        else {
            return remove(header.getNext());
        }
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        else {
            return remove(trailer.getPrev());
        }
    }

    public void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    public Node<E> getHeader() {
        return header;
    }

    public Node<E> getTrailer() {
        return trailer;
    }

    public String toString() {
        if (isEmpty()) {
            return "()";
        }
        else {
            String result = "";
            Node<E> currentNode = header;
            while (currentNode.getNext() != trailer) {
                currentNode = currentNode.getNext();
                result = result + currentNode.getElement() + ", ";
            }
            return String.format("(%s)", result.substring(0, result.length() - 2));
        }
    }
}