package Q2;

/**
 * Created by KanzakiMirai on 1/12/16.
 */

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
        Test4();
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
        SqrtProgression sqrtProgression = new SqrtProgression();

        myAssert(sqrtProgression.nextValue() == 65536, "Test #1");
    }

    static void Test2() {
        SqrtProgression sqrtProgression = new SqrtProgression(16);

        myAssert(sqrtProgression.nextValue() == 16, "Test #2");
    }

    static void Test3() {
        SqrtProgression sqrtProgression = new SqrtProgression(16);
        sqrtProgression.advance();

        myAssert(sqrtProgression.nextValue() == 4, "Test #3");
    }

    static void Test4() {
        SqrtProgression sqrtProgression = new SqrtProgression();
        sqrtProgression.advance();
        sqrtProgression.advance();

        myAssert(sqrtProgression.nextValue() == 16, "Test #4");
    }
}
