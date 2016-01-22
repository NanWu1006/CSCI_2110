package Q4;

import Q3.SinglyLinkedList;
/**
 * A test class for Q4
 *
 * @author Diqi Zeng
 */
public class Test {
    static QuestionFour<Integer> questionThree = new QuestionFour<>();
    static SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

    public static void main(String[] args) {
        singlyLinkedList.add(3);
        singlyLinkedList.add(1);
        singlyLinkedList.add(5);
        singlyLinkedList.add(4);
        singlyLinkedList.add(324);
        singlyLinkedList.add(121);
        singlyLinkedList.add(321);

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
        myAssert(questionThree.findntoLast(singlyLinkedList, 3) == 4, "Test #1");
    }

    static void Test2() {
        myAssert(questionThree.findntoLast(singlyLinkedList, 5) == 1, "Test #2");
    }

    static void Test3() {
        myAssert(questionThree.findntoLast(singlyLinkedList, 0) == 321, "Test #3");
    }

    static void Test4() {
        myAssert(questionThree.findntoLast(singlyLinkedList, 1) == 121, "Test #4");
    }

    static void Test5() {
        myAssert(questionThree.findntoLast(singlyLinkedList, 2) == 324, "Test #5");
    }
}
