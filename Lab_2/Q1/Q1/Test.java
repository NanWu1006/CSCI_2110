package Q1;

/**
 * Created by KanzakiMirai on 1/12/16.
 */

/**
 * A test class for Q1
 *
 * @author Diqi Zeng
 */
public class Test {
    public static void main(String[] args) {
        Test1();
        Test2();
        Test3();
        Test4();
        Test5();
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
        DoublyLinkedList<Integer> integerDoublyLinkedList = new DoublyLinkedList<>();
        integerDoublyLinkedList.add(5);
        integerDoublyLinkedList.add(1);
        integerDoublyLinkedList.add(3);
        System.out.println(integerDoublyLinkedList);
        QuestionOne.insertionSort(integerDoublyLinkedList);
        System.out.println(integerDoublyLinkedList);
        myAssert(integerDoublyLinkedList.toString().equals("[1, 3, 5]"), "Test #1");
    }

    static void Test2() {
        DoublyLinkedList<Integer> integerDoublyLinkedList = new DoublyLinkedList<>();
        integerDoublyLinkedList.add(9);
        integerDoublyLinkedList.add(8);
        integerDoublyLinkedList.add(7);
        integerDoublyLinkedList.add(6);
        integerDoublyLinkedList.add(5);
        System.out.println(integerDoublyLinkedList);
        QuestionOne.insertionSort(integerDoublyLinkedList);
        System.out.println(integerDoublyLinkedList);
        myAssert(integerDoublyLinkedList.toString().equals("[5, 6, 7, 8, 9]"), "Test #2");
    }

    static void Test3() {
        DoublyLinkedList<Integer> integerDoublyLinkedList = new DoublyLinkedList<>();
        integerDoublyLinkedList.add(12450);
        integerDoublyLinkedList.add(-1);
        integerDoublyLinkedList.add(8877);
        integerDoublyLinkedList.add(1);
        integerDoublyLinkedList.add(124);
        System.out.println(integerDoublyLinkedList);
        QuestionOne.insertionSort(integerDoublyLinkedList);
        System.out.println(integerDoublyLinkedList);
        myAssert(integerDoublyLinkedList.toString().equals("[-1, 1, 124, 8877, 12450]"), "Test #3");
    }

    static void Test4() {
        DoublyLinkedList<Integer> integerDoublyLinkedList = new DoublyLinkedList<>();
        integerDoublyLinkedList.add(1);
        integerDoublyLinkedList.add(2);
        integerDoublyLinkedList.add(3);
        System.out.println(integerDoublyLinkedList);
        QuestionOne.insertionSort(integerDoublyLinkedList);
        System.out.println(integerDoublyLinkedList);
        myAssert(integerDoublyLinkedList.toString().equals("[1, 2, 3]"), "Test #4");
    }

    static void Test5() {
        DoublyLinkedList<Integer> integerDoublyLinkedList = new DoublyLinkedList<>();
        integerDoublyLinkedList.add(-10);
        integerDoublyLinkedList.add(-50);
        integerDoublyLinkedList.add(-1);
        integerDoublyLinkedList.add(45);
        integerDoublyLinkedList.add(0);
        System.out.println(integerDoublyLinkedList);
        QuestionOne.insertionSort(integerDoublyLinkedList);
        System.out.println(integerDoublyLinkedList);
        myAssert(integerDoublyLinkedList.toString().equals("[-50, -10, -1, 0, 45]"), "Test #5");
    }
}
