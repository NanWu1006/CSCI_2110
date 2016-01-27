package Q2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by KanzakiMirai on 1/21/16.
 * @author Diqi Zeng
 */
public class QuestionTwo {
    /**
     * apply the insertion sort
     * @param array the ARRAY
     */
    static int[] insertionSort(int[] array) {
        int j = 0;

        int element;
        for (int i = 1; i < array.length; i++) {
            element = array[i];
            j = i;
            while ( (j > 0) && (array[j - 1] > element) ) {
                array[j] = array[j - 1];
                j = j - 1;
            }
            array[j] = element;
        }
        return array;
    }

    /**
     * apply the selection sort
     * @param array the ARRAY
     */
    static int[] selectionSort(int[] array) {
        int minIndex;
        for (int i = 1; i < array.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = tmp;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        ArrayList<HashMap<String, String>> is = insertionSortStat();
        ArrayList<HashMap<String, String>> ss = selectionSortStat();

        System.out.println();
        System.out.println("------RESULT------");
        System.out.println("INSERTION SORT");
        for (HashMap<String, String> eachData : is) {
            System.out.println(String.format("Array Length: %s  |  Avg. Time: %sms", eachData.get("LENGTH"), eachData.get("TIME")));
        }
        System.out.println();
        System.out.println("SELECTION SORT");
        for (HashMap<String, String> eachData : ss) {
            System.out.println(String.format("Array Length: %s  |  Avg. Time: %sms", eachData.get("LENGTH"), eachData.get("TIME")));
        }
    }

    /**
     * generate rand int from -X to X
     *
     * EG.
     *      rand(-100, 50)
     *
     *      getRandInt(-100, 50)
     *
     * @param start range starting value
     * @param end range ending value
     * @return the rand int
     */
    public static int getRandInt(int start, int end) {
        return ((Double)(Math.floor(Math.random() * (end - start)) + start)).intValue();
    }

    public static ArrayList<HashMap<String, String>> insertionSortStat() {
        ArrayList<HashMap<String, String>> statData = new ArrayList<>();

        for (int i = 5000; i <= 100000; i+=5000) {
//        for (int i = 5000; i <= 10000; i+=5000) {
            System.out.println("Running insertion sort stat for array length " + i);
            long timesum = 0;
            for (int x = 0; x < 5; x++) {
                System.out.println((x+1) + "/5");
                int[] array = new int[i];
                for (int j = 0; j < i; j++) {
                    array[j] = getRandInt(-1000, 1000);
                }
                long startTime = System.currentTimeMillis();
                insertionSort(array);
                long endTime = System.currentTimeMillis();
                long duration = endTime - startTime;
                timesum += duration;
            }
            long avgTime = timesum / 5;

            HashMap<String, String> eachResult = new HashMap<>();
            eachResult.put("LENGTH", Integer.toString(i));
            eachResult.put("TIME", Long.toString(avgTime));

            statData.add(eachResult);
        }
//        System.out.println("STAT RESULT IS");
//        System.out.println(statData);
        return statData;
    }

    public static ArrayList<HashMap<String, String>> selectionSortStat() {
        ArrayList<HashMap<String, String>> statData = new ArrayList<>();

        for (int i = 5000; i <= 100000; i+=5000) {
//        for (int i = 5000; i <= 10000; i+=5000) {
            System.out.println("Running insertion sort stat for array length " + i);
            long timesum = 0;
            for (int x = 0; x < 5; x++) {
                System.out.println((x+1) + "/5");
                int[] array = new int[i];
                for (int j = 0; j < i; j++) {
                    array[j] = getRandInt(-1000, 1000);
                }
                long startTime = System.currentTimeMillis();
                selectionSort(array);
                long endTime = System.currentTimeMillis();
                long duration = endTime - startTime;
                timesum += duration;
            }
            long avgTime = timesum / 5;

            HashMap<String, String> eachResult = new HashMap<>();
            eachResult.put("LENGTH", Integer.toString(i));
            eachResult.put("TIME", Long.toString(avgTime));

            statData.add(eachResult);
        }
//        System.out.println("STAT RESULT IS");
//        System.out.println(statData);
        return statData;
    }
}