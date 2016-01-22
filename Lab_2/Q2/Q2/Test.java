package Q2;

/**
 * Created by KanzakiMirai on 1/12/16.
 */

import Q1.DoublyLinkedList;

/**
 * A test class for Q2
 *
 * @author Diqi Zeng
 */
public class Test {
    public static void main(String[] args) {
        Test1();
        Test2();
        Test3();
        System.out.println("ALL TEST PASSED!");
    }

    static void myAssert(boolean expression, String name) {
        if (!expression) {
            throw new AssertionError(name + " FAIL!");
        }
        else {
            System.out.println(name + " PASS!");
        }
    }

    static void Test1() {
        /**
         * [5, 4, 3, 2]
         */
        DoublyLinkedList<Integer> L1 = new DoublyLinkedList<>();
        L1.add(5);
        L1.add(4);
        L1.add(3);
        L1.add(2);

        /**
         * [2, 4]
         */
        DoublyLinkedList<Integer> L2 = new DoublyLinkedList<>();
        L2.add(2);
        L2.add(4);

        System.out.println("L1 = " + L1);
        System.out.println("L2 = " + L2);
        QuestionTwo.mergeDLists(L1, L2);
        System.out.println("L1 = " + L1);

        myAssert(L1.toString().equals("[5, 4, 4, 3, 2, 2]"), "Test #1");
    }

    static void Test2() {
        /**
         * [1, 3, 5, 7, 9]
         */
        DoublyLinkedList<Integer> L1 = new DoublyLinkedList<>();
        L1.add(1);
        L1.add(3);
        L1.add(5);
        L1.add(7);
        L1.add(9);

        /**
         * [2, 4, 6, 8, 10]
         */
        DoublyLinkedList<Integer> L2 = new DoublyLinkedList<>();
        L2.add(2);
        L2.add(4);
        L2.add(6);
        L2.add(8);
        L2.add(10);

        System.out.println("L1 = " + L1);
        System.out.println("L2 = " + L2);
        QuestionTwo.mergeDLists(L1, L2);
        System.out.println("L1 = " + L1);

        myAssert(L1.toString().equals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]"), "Test #2");
    }

    static void Test3() {
        /**
         * [6, 6, 6]
         */
        DoublyLinkedList<Integer> L1 = new DoublyLinkedList<>();
        L1.add(6);
        L1.add(6);
        L1.add(6);

        /**
         * [5, 7]
         */
        DoublyLinkedList<Integer> L2 = new DoublyLinkedList<>();
        L2.add(5);
        L2.add(7);

        System.out.println("L1 = " + L1);
        System.out.println("L2 = " + L2);
        QuestionTwo.mergeDLists(L1, L2);
        System.out.println("L1 = " + L1);

        myAssert(L1.toString().equals("[5, 6, 6, 6, 7]"), "Test #3");
    }
}
