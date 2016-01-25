package Q2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by KanzakiMirai on 1/21/16.
 * @author Diqi Zeng
 */
public class QuestionTwo {
    static int X_AXIS_RATE = 1000;
    static int Y_AXIS_RATE = 10;

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
        String is = insertionSortStat();
        String ss = selectionSortStat();
        String dataString = is + "|" + ss;
        System.out.println();
        System.out.println(String.format("https://chart.googleapis.com/chart?cht=lxy&chs=1000x300&chd=t:%s&chco=3072F3,ff0000,00aaaa&chls=2,4,1&chm=s,000000,0,-1,5|s,000000,1,-1,5&chdl=InsertionSort|SelectionSort&chdlp=t&chxt=x,y&chxl=0:|5000|100000|1:||0||1000||", dataString));
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

    public static String insertionSortStat() {
        ArrayList<HashMap<String, String>> statData = new ArrayList<>();

        ArrayList<String> arraySizeList = new ArrayList<>();
        ArrayList<String> avgTimeList = new ArrayList<>();

        for (int i = 5000; i <= 100000; i+=5000) {
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
            eachResult.put("Array Length", Integer.toString(i));
            eachResult.put("Avg Time (ms)", Long.toString(avgTime));

            arraySizeList.add(Integer.toString(i / X_AXIS_RATE));
            avgTimeList.add(Long.toString(avgTime / Y_AXIS_RATE));

            statData.add(eachResult);
        }
        System.out.println("STAT RESULT IS");
        System.out.println(statData);
        return String.join(",", arraySizeList) + "|" + String.join(",", avgTimeList);
    }

    public static String selectionSortStat() {
        ArrayList<HashMap<String, String>> statData = new ArrayList<>();

        ArrayList<String> arraySizeList = new ArrayList<>();
        ArrayList<String> avgTimeList = new ArrayList<>();

        for (int i = 5000; i <= 100000; i+=5000) {
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
            eachResult.put("Array Length", Integer.toString(i));
            eachResult.put("Avg Time (ms)", Long.toString(avgTime));

            arraySizeList.add(Integer.toString(i / X_AXIS_RATE));
            avgTimeList.add(Long.toString(avgTime / Y_AXIS_RATE));

            statData.add(eachResult);
        }
        System.out.println("STAT RESULT IS");
        System.out.println(statData);
        return String.join(",", arraySizeList) + "|" + String.join(",", avgTimeList);
    }
}