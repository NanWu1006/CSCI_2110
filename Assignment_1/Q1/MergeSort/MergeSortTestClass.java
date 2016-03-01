package MergeSort;

import Helper.DLList;

import java.util.Comparator;
import java.util.Random;

/**
 * @author Diqi Zeng
 */
public class MergeSortTestClass {
    /**
     * Creates a list of 10 random Longs and sorts it
     *
     * Prints out the original list and the result.
     *
     */
    public static void main(String[] args) {
        System.out.println("Test Class for MERGE SORT");
        integerTestPart();
        System.out.println();
        doubleTestPart();
    }

    static void integerTestPart() {
        System.out.println("Start INTEGER TEST:");
        DLList<Integer> integerDLList = new DLList<>();
        for(int i = 0; i < 50; i++) {
            integerDLList.add((new Random()).nextInt(1000));
        }
        Comparator<Integer> integerComparator = (o1, o2) -> o1 - o2;
        System.out.println("Before: " + integerDLList);
        MergeSort<Integer> mergeSort = new MergeSort<Integer>();
        DLList<Integer> sorted = mergeSort.mergeSort(integerDLList, integerComparator);
        System.out.println("After: " + sorted);
    }

    static void doubleTestPart() {
        System.out.println("Start DOUBLE TEST:");
        DLList<Double> doubleDLList = new DLList<>();
        for(int i = 0; i < 50; i++) {
            doubleDLList.add((new Random()).nextDouble());
        }
//        Comparator<Double> doubleComparator = (o1, o2) -> {
//            if (o1 < o2) {
//                return -1;
//            }
//            if (o1 > o2) {
//                return 1;
//            }
//            else {
//                return 0;
//            }
//        };
        Comparator<Double> doubleComparator = Double::compare;
        System.out.println("Before: " + doubleDLList);
        MergeSort<Double> mergeSort = new MergeSort<Double>();
        DLList<Double> sorted = mergeSort.mergeSort(doubleDLList, doubleComparator);
        System.out.println("After: " + sorted);
    }
}
