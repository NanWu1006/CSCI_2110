package Q1;

import java.util.Arrays;

/**
 * Created by KanzakiMirai on 1/21/16.
 *
 * The question 1 for Lab 4 assignment, solving Hanoi Tower
 *
 * @author Diqi Zeng
 */
public class QuestionOne {
    public static void main(String[] args) {
        HanoiTower hanoiTower = new HanoiTower(5);
        hanoiTower.startMove();
    }
}

class HanoiTower {
    int[] entity;

    public HanoiTower(int initialNum) {
        entity = new int[]{initialNum, 0, 0};
    }

    /**
     * boostrap of the recursive method
     */
    public void startMove() {
        System.out.println(Arrays.toString(entity));
        this.move(entity[0], 0, 2, 1);
    }

    /**
     * recursive move the stacks
     * @param n numbers
     * @param mainStack source stack
     * @param targetStack target stack
     * @param tempStack temp stack
     */
    public void move(int n, int mainStack, int targetStack, int tempStack) {
        if (n == 1) {
            entity[mainStack]--;
            entity[tempStack]++;
            System.out.println(Arrays.toString(entity));
        }
        else {
            this.move(n - 1, mainStack, tempStack, targetStack);
            entity[mainStack]--;
            entity[tempStack]++;
            System.out.println(Arrays.toString(entity));
            this.move(n - 1, targetStack, mainStack, tempStack);
        }
    }
}