package Q2;

/**
 * Created by KanzakiMirai on 1/12/16.
 */

/**
 * The question 2, a square root progression class
 *
 * @author Diqi Zeng
 */
public class SqrtProgression extends Progression {
    public SqrtProgression() {
        this(65536);
    }

    /**
     * init with a starting value
     * @param start the starting value
     */
    public SqrtProgression(double start) {
        current = start;
    }

    /**
     * overriding the advance method of Progression
     */
    protected void advance() {
        current = Math.sqrt(current);
    }
}

class Progression {
    protected double current;

    public Progression() {
        this(0);
    }

    public Progression(double start) {
        current = start;
    }

    public double nextValue() {
        double answer = current;
        advance();
        return answer;
    }

    protected void advance() {
        current++;
    }

    public void printProgression(int n) {
        System.out.print(nextValue());
        for (int j = 1; j < n; j++) {
            System.out.print(" " + nextValue());
        }
        System.out.println();
    }
}