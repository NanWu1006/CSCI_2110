package MergeSort;

import java.util.Comparator;
import Helper.DLList;
import Helper.Node;

/**
 * Assignment 1, recursively merge sort a double-linked-list
 *
 * @author Diqi Zeng
 */
public class MergeSort<T> {
    private DLList<T> tmpResult;

    /**
     * recursive sort each part
     * @param L list for sort
     * @param comp comparator defines the order
     */
    public void sort(DLList<T> L, Comparator<T> comp) {
        /**
         * basic case
         */
        if(L.size() <= 1) {
            this.tmpResult = L;
            return;
        }

        DLList<T> leftPart = new DLList<>();
        DLList<T> rightPart = new DLList<>();

        int middle = L.size() / 2;

        int added = 0;
        Node<T> item = L.getNode(added);
        for (int i = 0; i < L.size(); i++) {
            if ( added++ < middle ) {
                leftPart.add(item.getElement());
            }
            else {
                rightPart.add(item.getElement());
            }
            item = item.getNext();
        }

        /**
         * recursive sort left
         */
        sort(leftPart, comp);
        leftPart = this.tmpResult;

        /**
         * recursive sort right
         */
        sort(rightPart, comp);
        rightPart = this.tmpResult;

        DLList<T> resultList;

        merge(leftPart, rightPart, comp);
        resultList = this.tmpResult;

        this.tmpResult = resultList;
    }

    /**
     * merge left & right part into a list
     * @param left left part
     * @param right right part
     * @param comp PRE-DEFINED comparator from 'sort()'
     */
    private void merge(DLList<T> left, DLList<T> right, Comparator<T> comp) {
        DLList<T> result = new DLList<>();
        while(left.size() > 0 && right.size() > 0) {
            if (comp.compare(left.get(0), right.get(0)) < 0) {
                result.add(left.remove(0));
            }
            else {
                result.add(right.remove(0));
            }
        }

        if(left.size() > 0) {
            result.combine(left);
        }
        else {
            result.combine(right);
        }

        this.tmpResult = result;
    }

    public DLList<T> mergeSort(DLList<T> dlList, Comparator<T> comparator) {
        this.sort(dlList, comparator);
        return this.tmpResult;
    }
}
