package Q3;

/**
 * Created by KanzakiMirai on 1/12/16.
 */

/**
 * Q3, the testing of changing the value of SUPER-SUPER class
 *
 * @author Diqi Zeng
 */
public class QuestionThree {
    public static void main(String[] args) {
        QuestionThree.exampleOne();
        QuestionThree.exampleTwo();
        QuestionThree.exampleThree();
    }

    static void exampleOne() {
        C c = new C();
        System.out.println("Example #1");
        System.out.println(String.format("Old value in A: %s", c.getXinClassA()));
        c.setXinClassA("this variable is changed by exampleOne");
        System.out.println(String.format("New value in A: %s", c.getXinClassA()));
    }

    static void exampleTwo() {
        C c = new C();
        System.out.println("Example #2");
        System.out.println(String.format("Old value in A: %s", c.getXinClassA()));
        c.setXinClassA("this variable is changed by exampleTwo");
        System.out.println(String.format("New value in A: %s", c.getXinClassA()));
    }

    static void exampleThree() {
        C c = new C();
        System.out.println("Example #3");
        System.out.println(String.format("Old value in A: %s", c.getXinClassA()));
        c.setXinClassA("this variable is changed by exampleThree");
        System.out.println(String.format("New value in A: %s", c.getXinClassA()));
        System.out.println(String.format("Now value in C: %s", c.x));
    }
}

class A {
    String x = "I am x in A";
}

class B extends A {
    String x = "I am x in B";
}

class C extends B {
    String x = "I am x in C";

    void setXinClassA(String newValue) {
        ((A) this).x = newValue;
    }

    String getXinClassA() {
        return ((A) this).x;
    }
}