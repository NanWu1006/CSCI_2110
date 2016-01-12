/**
 * Created by KanzakiMirai on 1/12/16.
 */
public class SqrtProgression extends Progression {
    public SqrtProgression() {
        this(65536);
    }

    public SqrtProgression(double start) {
        current = start;
    }

    protected void advance() {
        current = Math.sqrt(current);
    }
}

class Progression {
    protected double current;

    public Progression() {
        this(0);
    }

    public Progression(long start) {
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