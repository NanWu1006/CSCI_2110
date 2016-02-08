package Q3;

import java.util.Arrays;

/**
 * Created by KanzakiMirai on 1/21/16.
 */
public class QuestionThree {
    /**
     * test if string is palindrome
     * @param string input string
     * @return TRUE if is palindrome, vice versa
     */
    public static boolean isPalindrome(String string) {
        /**
         * format string
         */
        String formattedString = string.replaceAll("\\s", "");
        char[] charArr = formattedString.toCharArray();
        /**
         * reverse string
         */
        reverse(charArr);
        String reversedString = String.valueOf(charArr);

        return formattedString.equalsIgnoreCase(reversedString);
    }

    private static void reverse(char[] charArr) {
        reverse(charArr, 0, charArr.length - 1);
    }

    private static void reverse(char[] charArr, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            char tmp = charArr[startIndex];
            charArr[startIndex] = charArr[endIndex];
            charArr[endIndex] = tmp;
            reverse(charArr, startIndex + 1, endIndex - 1);
        }
    }
}