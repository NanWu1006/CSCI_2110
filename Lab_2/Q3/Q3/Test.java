package Q3;

/**
 * Created by KanzakiMirai on 1/12/16.
 */

/**
 * A test class for Q3
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
        SinglyLinkedList<Integer> L1 = new SinglyLinkedList<>();
        L1.add(3);
        L1.add(1);
        L1.add(5);

        SinglyLinkedList<Integer> L2 = new SinglyLinkedList<>();
        L2.add(5);
        L2.add(9);
        L2.add(2);

        myAssert(QuestionThree.addSLists(L1, L2).toString().equals("[8, 0, 8]"), "Test #1");
    }

    static void Test2() {
        SinglyLinkedList<Integer> L1 = new SinglyLinkedList<>();
        L1.add(8);
        L1.add(9);
        L1.add(7);

        SinglyLinkedList<Integer> L2 = new SinglyLinkedList<>();
        L2.add(4);
        L2.add(0);
        L2.add(4);
        L2.add(1);

        myAssert(QuestionThree.addSLists(L1, L2).toString().equals("[2, 2, 0, 2]"), "Test #2");
    }

    static void Test3() {
        SinglyLinkedList<Integer> L1 = new SinglyLinkedList<>();
        L1.add(6);

        SinglyLinkedList<Integer> L2 = new SinglyLinkedList<>();
        L2.add(4);
        L2.add(9);

        myAssert(QuestionThree.addSLists(L1, L2).toString().equals("[1, 0, 0]"), "Test #3");
    }

    static void Test4() {
        SinglyLinkedList<Integer> L1 = new SinglyLinkedList<>();
        L1.add(8);
        L1.add(9);
        L1.add(7);

        SinglyLinkedList<Integer> L2 = new SinglyLinkedList<>();
        L2.add(0);

        myAssert(QuestionThree.addSLists(L1, L2).toString().equals("[7, 9, 8]"), "Test #4");
    }

    static void Test5() {
        SinglyLinkedList<Integer> L1 = new SinglyLinkedList<>();
        L1.add(1);
        L1.add(2);
        L1.add(9);

        SinglyLinkedList<Integer> L2 = new SinglyLinkedList<>();
        L2.add(9);

        myAssert(QuestionThree.addSLists(L1, L2).toString().equals("[9, 3, 0]"), "Test #5");
    }
}
