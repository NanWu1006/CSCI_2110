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
        Test7();
        Test8();
        Test9();
        Test10();
        Test11();
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

    static void Test7() {
        Circle2D circle2D = new Circle2D();
        circle2D.setRadius(5);
        myAssert(circle2D.getArea() == Math.PI * 25, "Test of Q7");
    }

    static void Test8() {
        Circle2D circle2D = new Circle2D();
        circle2D.setRadius(5);
        myAssert(circle2D.getPerimeter() == Math.PI * 10, "Test of Q8");
    }

    static void Test9() {
        Circle2D circle2D = new Circle2D();
        circle2D.setRadius(5);
        myAssert(circle2D.contains(0, 0), "Test of Q9");
    }

    static void Test10() {
        Circle2D circle2D = new Circle2D();
        circle2D.setRadius(5);

        Circle2D anotherCircle = new Circle2D();
        anotherCircle.setRadius(0.5);

        myAssert(circle2D.contains(anotherCircle), "Test of Q10");
    }

    static void Test11() {
        Circle2D circle2D = new Circle2D();
        circle2D.setRadius(5);

        Circle2D anotherCircle = new Circle2D(5, 0);
        anotherCircle.setRadius(2);

        myAssert(circle2D.overlaps(anotherCircle), "Test of Q11");
    }
}
