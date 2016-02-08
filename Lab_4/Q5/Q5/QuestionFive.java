package Q5;

/**
 * Created by KanzakiMirai on 1/12/16.
 */


import java.util.ArrayList;

/**
 * Q5 class
 *
 * @author Diqi Zeng
 */
public class QuestionFive {
    private static ArrayList<String> outputList = new ArrayList<>();

    /**
     * find solution recursively
     * @param leftCount left parenthesis count
     * @param rightCount right parenthesis count
     * @param shouldDisplay last display cache
     */
    private static void showParenthesis(int leftCount, int rightCount, String shouldDisplay) {
        if (leftCount == 0 && rightCount == 0) {
            outputList.add(shouldDisplay);
        }
        if (leftCount > 0) {
            showParenthesis(leftCount - 1, rightCount + 1, shouldDisplay + "(");
        }
        if (rightCount > 0) {
            showParenthesis(leftCount, rightCount - 1, shouldDisplay + ")");
        }
    }

    private static void showParenthesis(int num) {
        showParenthesis(num, 0, "");
        System.out.printf("There are %s possibilities\n", outputList.size());
        outputList.forEach(System.out::println);
    }

    public static void main(String[] args) {
        showParenthesis(3);
    }
}