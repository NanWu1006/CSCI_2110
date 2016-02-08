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
        System.out.println("ALL TEST PASSED!");
    }

    static void Test1() {
        String[] testStrings = new String[]{"abc","abcd","abcde","abcdee","abcdeff"};
        for (String eachString : testStrings) {
            System.out.println("Listing String of \"" + eachString + "\"");
            Q2.QuestionTwo.startListing(eachString);
            System.out.println();
        }
    }
}