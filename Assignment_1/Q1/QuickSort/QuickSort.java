package QuickSort;

import Helper.DLList;

import Helper.DLList;

import java.util.Comparator;
import java.util.Random;

/**
 * @author Diqi Zeng
 */
public class QuickSort<T> {
    private DLList<T> dlList;
    private Comparator<T> comp;

    /**
     * helper method for sort
     * @param S list itself
     * @param comp comparator
     */
    public void sort(DLList<T> S, Comparator<T> comp) {
        this.dlList = S;
        this.comp = comp;
        sort(0, S.size() - 1);
    }

    /**
     * recursive sorting
     * @param startIndex start index
     * @param endIndex end index
     */
    public void sort(int startIndex, int endIndex){
        int tmp;
        if (startIndex < endIndex) {
            tmp = partition(startIndex, endIndex);
            sort(startIndex, tmp);
            sort(tmp + 1, endIndex);
        }
    }

    int partition(int startIndex,int endIndex) {
        int currentIndex = startIndex;
        int length = endIndex;

        /**
         * get random pivot
         */
        int pivotIndex = this.getRandIntInRange(startIndex, endIndex);
        T pivotElement = dlList.get(pivotIndex);

        while(true){
            /**
             * if pivot is smaller
             */
            while (this.comp.compare(dlList.get(length), pivotElement) > 0 && length > startIndex) {
                length--;
            }
            /**
             * if pivot is bigger
             */
            while (this.comp.compare(dlList.get(currentIndex), pivotElement) < 0 && currentIndex < endIndex) {
                currentIndex++;
            }

            /**
             * process with index
             */
            if (currentIndex < length) {
                T temp;
                temp = dlList.get(currentIndex);
                dlList.set(currentIndex,dlList.get(length));
                dlList.set(length,temp);
                length--;
                currentIndex++;
            }
            else {
                return length;
            }
        }

    }

    /**
     * helper method for get random int in RANGE
     * @param min range min value
     * @param max range max value
     * @return rand int between min & max
     */
    int getRandIntInRange(int min, int max) {
        if (max - min >= 0) {
            return (min + (new Random()).nextInt(max - min + 1));
        }
        int tmp = (new Random()).nextInt();
        while (tmp < min || tmp > max) {
            tmp = (new Random()).nextInt();
        }
        return tmp;
    }
}