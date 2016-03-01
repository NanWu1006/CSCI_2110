package QuickSort;

import Helper.DLList;
import MergeSort.MergeSort;

import java.util.Comparator;
import java.util.Random;

/**
 * @author Diqi Zeng
 */
public class QuickSortTestClass {
    /**
     * Creates a list of 10 random Longs and sorts it
     *
     * Prints out the original list and the result.
     *
     */
    public static void main(String[] args) {
        System.out.println("Test Class for QUICK SORT");
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
        QuickSort<Integer> quickSort = new QuickSort<Integer>();
        quickSort.sort(integerDLList, integerComparator);
        System.out.println("After: " + integerDLList);
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
        QuickSort<Double> quickSort = new QuickSort<Double>();
        quickSort.sort(doubleDLList, doubleComparator);
        System.out.println("After: " + doubleDLList);
    }
}
