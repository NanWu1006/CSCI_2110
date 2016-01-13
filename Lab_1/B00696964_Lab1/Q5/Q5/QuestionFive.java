package Q5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Created by KanzakiMirai on 1/12/16.
 */

/**
 * Q5 class
 *
 * @author Diqi Zeng
 */
public class QuestionFive {
    /**
     * get a arraylist contains all chars in this string
     * @param s given string
     * @return a arraylist of all chars
     */
    public static ArrayList<Character> getCharsOfString(String s) {
        ArrayList<Character> charArray = new ArrayList<>();
        for (char eachChar : s.toCharArray()) {
            charArray.add(eachChar);
        }

        ArrayList<Character> charTempArray = new ArrayList<>();

        charArray.stream().filter(eachChar -> charTempArray.indexOf(eachChar) == -1).forEach(charTempArray::add);
        return charTempArray;
    }

    /**
     * removing the duplicate chars in given string
     * @param s input string
     * @return the string contains only unique chars
     */
    public static String removeDuplicates(String s) {
        ArrayList<Character> charTempArray = getCharsOfString(s);
        return getStringRepresentation(charTempArray);
    }

    /**
     * concat the arraylist of chars into a string
     * @param list given arraylist of chars
     * @return a output string
     */
    static String getStringRepresentation(ArrayList<Character> list) {
        StringBuilder builder = new StringBuilder(list.size());
        list.forEach(builder::append);
        return builder.toString();
    }

    /**
     * detect if two string is a ANAGRAM-GAME string pair
     * @param s first string
     * @param t second string
     * @return TRUE if is a ANAGRAM-GAME, vice versa
     */
    public static boolean anagram(String s, String t) {
        ArrayList<Character> firstStringChars = getCharsOfString(s);
        ArrayList<Character> secondStringChars = getCharsOfString(t);

        ArrayList<Character> containsChars = new ArrayList<>();

        for (Character eachCharFirst : firstStringChars) {
            containsChars.addAll(secondStringChars.stream()
                    .filter(eachCharSecond -> eachCharFirst == eachCharSecond)
                    .map(eachCharSecond -> eachCharFirst).collect(Collectors.toList()));
        }

        return containsChars.size() == firstStringChars.size();
    }

    /**
     * detect if s2 is a substring of s1
     * @param s1 a given string
     * @param s2 another given string
     * @return TRUE if s2 is a substring of s1, vice versa
     */
    public static boolean isSubstring (String s1, String s2) {
        return s1.contains(s2);
    }

    /**
     * check if s1 is a rotation of s2
     * @param s1 a given string
     * @param s2 another given string
     * @return TRUE if s2 is a rotation of s1, vice versa
     */
    public static boolean isRotation(String s1, String s2) {
        return (s1.length() == s2.length()) && (isSubstring(s1 + s1, s2));
    }
}