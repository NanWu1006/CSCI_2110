package Q4;

import java.util.Arrays;

/**
 * Created by KanzakiMirai on 1/21/16.
 */
public class QuestionFour {
    public static void main(String[] args) {
        /**
         * QUESTION 3
         */
        testFunction();
        /**
         * QUESTION 4
         */
        largeAmountTest();
    }

    private static long depth = 0L;
    private static void testMaxRecursive() {
        ++depth;
        testMaxRecursive();
    }
    private static long getMaxRecursive() {
        try {
            testMaxRecursive();
        }
        catch (StackOverflowError e) {
            return depth;
        }
        return -1;
    }

    /**
     * method of Q1, find minimum value iteratively
     *
     * RUNNING TIME IS O(n)
     *
     * @param arr input arr
     * @return minimum value
     */
    public static int findMinIter(int[] arr) {
        int min = arr[0];
        for (int eachInt : arr) {
            if (eachInt < min) {
                min = eachInt;
            }
        }
        return min;
    }

    /**
     * method of Q2, find minimum value recursively
     *
     * RUNNING TIME IS O(n)
     *
     * @param arr input arr
     * @return minimum value
     */
    public static int findMinRcsv(int[] arr) {
        return min(arr, 0);
    }

    private static int min(int[] intArr, int minIndex) {
        if (minIndex == intArr.length - 1) {
            return intArr[minIndex];
        }
        int tmp = min(intArr, minIndex + 1);
        if (intArr[minIndex] < tmp) {
            return intArr[minIndex];
        }
        else {
            return tmp;
        }
    }

    /**
     * method of Q3, test Q1 & Q2
     */
    private static int[] getRandIntArr(int length) {
        int[] randIntArr = new int[length];
        for(int i = 0; i < randIntArr.length; i++) {
            /**
             * if length = 10, rand integer from -10 ~ 10
             * if length = 20, rand integer from -20 ~ 20
             * ...
             */
            randIntArr[i] = (int)(Math.random()*(length * 2) - (length / 2));
        }
        return randIntArr;
    }

    public static void testFunction() {
        for (int i = 1; i <= 5; i++) {
            int[] randIntArr = getRandIntArr(10);
            if (findMinIter(randIntArr) == findMinRcsv(randIntArr)) {
                System.out.println(String.format("TEST #%s PASSED", i));
            }
            else {
                System.out.println(String.format("TEST #%s FAILED", i));
            }
        }
    }


    /**
     *
     * SAMPLE OUTPUT
     *
     * *NOTE:
     *
     *        10|         0|         0
     *       100|         0|         0
     *      1000|         0|         0
     *     10000|         0|         0
     *    100000|         2|STACK OVERFLOW
     *   1000000|         5|STACK OVERFLOW
     *  10000000|         5|STACK OVERFLOW
     *
     */
    /**
     * method of Q4, large amount test
     */
    public static void largeAmountTest() {
        System.out.println("Test may lead to StackOverflow");
        System.out.println(String.format("Max call stack of current JVM is %s (estimated)", getMaxRecursive()));
        System.out.println();
        System.out.println("                   LENGTH|    Iterative Time(ms)   | Recursive Time(ms)");
        for (int i = 1; i <= 7; i++) {
            int currentLength = (int)Math.pow(10, i);
            int[] currentRandArray = getRandIntArr(currentLength);

            /**
             * START EXECUTE
             */

            long startTime;

            /**
             * DO ITERATIVE ONE FIRST
             */
            startTime = System.currentTimeMillis();
            findMinIter(currentRandArray);
            long iterativeTime = System.currentTimeMillis() - startTime;

            /**
             * DO RECURSIVE
             */
            startTime = System.currentTimeMillis();
            long recursiveTime;
            boolean execSuccess = true;
            try {
                findMinRcsv(currentRandArray);
            }
            catch (StackOverflowError e) {
                execSuccess = false;
            }
            if (execSuccess) {
                recursiveTime = System.currentTimeMillis() - startTime;
                System.out.println(String.format("% 25d|% 25d|% 25d", currentLength, iterativeTime, recursiveTime));
            }
            else {
                System.out.println(String.format("% 25d|% 25d|     STACK OVERFLOW", currentLength, iterativeTime));
            }
        }
    }
}