package Q1;

/**
 * Created by KanzakiMirai on 1/21/16.
 *
 * The question 1 for Lab 2 assignment
 *
 * @author Diqi Zeng
 */
public class QuestionOne {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> integerDoublyLinkedList = new DoublyLinkedList<>();
        integerDoublyLinkedList.add(5);
        integerDoublyLinkedList.add(1);
        integerDoublyLinkedList.add(3);
        System.out.println(integerDoublyLinkedList);
        insertionSort(integerDoublyLinkedList);
        System.out.println(integerDoublyLinkedList);
    }

    /**
     * apply insertion sort
     * @param integerDoublyLinkedList input list
     */
    public static void insertionSort(DoublyLinkedList<Integer> integerDoublyLinkedList) {
        Integer currentInt;
        int j;
        for (int i = 1; i < integerDoublyLinkedList.size(); i++) {
            currentInt = integerDoublyLinkedList.get(i);
            j = i;

            while ( (j > 0) && (integerDoublyLinkedList.get(j - 1) > currentInt) ) {
                integerDoublyLinkedList.set(j, integerDoublyLinkedList.get(j - 1));
                j = j - 1;
            }
            integerDoublyLinkedList.set(j, currentInt);
        }
    }
}