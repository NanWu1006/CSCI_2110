import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by KanzakiMirai on 1/12/16.
 */
public class QuestionFive {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("SBBBBBBBBK"));

        System.out.println(anagram("AAB", "ABA"));

        System.out.println("MyNameIsDickyDesu".contains("Dicky"));

        System.out.println(isRotation("waterbottle", "erbottlewat"));
    }

    public static ArrayList<Character> getCharsOfString(String s) {
        ArrayList<Character> charArray = new ArrayList<Character>();
        for (char eachChar : s.toCharArray()) {
            charArray.add(eachChar);
        }

        ArrayList<Character> charTempArray = new ArrayList<>();

        charArray.stream().filter(eachChar -> charTempArray.indexOf(eachChar) == -1).forEach(charTempArray::add);
        return charTempArray;
    }

    public static String removeDuplicates(String s) {
        ArrayList<Character> charTempArray = getCharsOfString(s);
        return getStringRepresentation(charTempArray);
    }

    static String getStringRepresentation(ArrayList<Character> list) {
        StringBuilder builder = new StringBuilder(list.size());
        list.forEach(builder::append);
        return builder.toString();
    }

    public static boolean anagram(String s, String t) {
        ArrayList<Character> firstStringChars = getCharsOfString(s);
        ArrayList<Character> secondStringChars = getCharsOfString(t);

        ArrayList<Character> containsChars = new ArrayList<>();

        for (Character eachCharFirst : firstStringChars) {
            for (Character eachCharSecond : secondStringChars) {
                if (eachCharFirst == eachCharSecond) {
                    containsChars.add(eachCharFirst);
                }
            }
        }

        return containsChars.size() == firstStringChars.size();
    }

    public static boolean isSubstring (String s1, String s2) {
        return s1.contains(s2);
    }

    public static boolean isRotation(String s1, String s2) {
        return (s1.length() == s2.length()) && (isSubstring(s1 + s1, s2));
    }
}