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

// ------RESULT------
// INSERTION SORT
// Array Length: 5000  |  Avg. Time: 7ms
// Array Length: 10000  |  Avg. Time: 18ms
// Array Length: 15000  |  Avg. Time: 39ms
// Array Length: 20000  |  Avg. Time: 70ms
// Array Length: 25000  |  Avg. Time: 111ms
// Array Length: 30000  |  Avg. Time: 161ms
// Array Length: 35000  |  Avg. Time: 221ms
// Array Length: 40000  |  Avg. Time: 288ms
// Array Length: 45000  |  Avg. Time: 367ms8
// Array Length: 50000  |  Avg. Time: 453ms
// Array Length: 55000  |  Avg. Time: 548ms
// Array Length: 60000  |  Avg. Time: 655ms
// Array Length: 65000  |  Avg. Time: 768ms
// Array Length: 70000  |  Avg. Time: 890ms
// Array Length: 75000  |  Avg. Time: 1022ms
// Array Length: 80000  |  Avg. Time: 1163ms
// Array Length: 85000  |  Avg. Time: 1315ms
// Array Length: 90000  |  Avg. Time: 1475ms
// Array Length: 95000  |  Avg. Time: 1644ms
// Array Length: 100000  |  Avg. Time: 1822ms
//
// SELECTION SORT
// Array Length: 5000  |  Avg. Time: 28ms
// Array Length: 10000  |  Avg. Time: 102ms
// Array Length: 15000  |  Avg. Time: 248ms
// Array Length: 20000  |  Avg. Time: 290ms
// Array Length: 25000  |  Avg. Time: 394ms
// Array Length: 30000  |  Avg. Time: 567ms
// Array Length: 35000  |  Avg. Time: 772ms
// Array Length: 40000  |  Avg. Time: 1007ms
// Array Length: 45000  |  Avg. Time: 1275ms
// Array Length: 50000  |  Avg. Time: 1573ms
// Array Length: 55000  |  Avg. Time: 1904ms
// Array Length: 60000  |  Avg. Time: 2265ms
// Array Length: 65000  |  Avg. Time: 2658ms
// Array Length: 70000  |  Avg. Time: 3082ms
// Array Length: 75000  |  Avg. Time: 3538ms
// Array Length: 80000  |  Avg. Time: 4028ms
// Array Length: 85000  |  Avg. Time: 4544ms
// Array Length: 90000  |  Avg. Time: 5096ms
// Array Length: 95000  |  Avg. Time: 5677ms
// Array Length: 100000  |  Avg. Time: 6288ms