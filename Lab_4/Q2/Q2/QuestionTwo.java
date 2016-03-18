package Q2;

/**
 * Created by KanzakiMirai on 1/21/16.
 * @author Diqi Zeng
 */
public class QuestionTwo {
    public static void startListing(String string) {
        listPermutation("", string);
    }

    /**
     *
     * @param strPrefix input string prefix
     * @param string string body
     */
    private static void listPermutation(String strPrefix, String string) {
        System.out.printf("1st: %s\n", strPrefix);
        System.out.printf("2nd: %s\n", string);

        int n = string.length();
        if (n == 0) {
            System.out.println(strPrefix);
        }
        else {
            /**
             * change porssibilities
             */
            for (int i = 0; i < n; i++) {
                listPermutation(strPrefix + String.valueOf(string.charAt(i)),
                        string.substring(0, i) + string.substring(i + 1, n));
            }
            System.out.println();
        }
        System.out.println();
    }
}