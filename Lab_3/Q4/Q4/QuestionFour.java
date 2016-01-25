package Q4;

import Q3.SinglyLinkedList;

/**
 * Created by KanzakiMirai on 1/21/16.
 */
public class QuestionFour<E> {
    public E findntoLast(SinglyLinkedList<E> L1, int n) {
        int expectedIndex = L1.size() - n - 1;
        return L1.get(expectedIndex);
    }
}