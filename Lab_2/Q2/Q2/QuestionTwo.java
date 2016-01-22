package Q2;

import Q1.DoublyLinkedList;

/**
 * Created by KanzakiMirai on 1/21/16.
 * @author Diqi Zeng
 */
public class QuestionTwo {
    /**
     * merge L2 into L1
     * @param L1 first list
     * @param L2 second list
     */
    public static void mergeDLists(DoublyLinkedList<Integer> L1, DoublyLinkedList<Integer> L2) {
        /**
         * DEFAULT IS ASC
         */
        boolean DESC = false;
        int oldL1Size = L1.size();

        /**
         * check if the linked list is DESC or ASC
         */
        for (int i = 0; i < L1.size() - 1; i++) {
            if (L1.get(i) > L1.get(i + 1)) {
                DESC = true;
                break;
            }
            else if (L1.get(i) < L1.get(i + 1)) {
                DESC = false;
                break;
            }
        }

        for (int i = 0; i < L2.size(); i++) {
            int currentVal = L2.get(i);

            for (int j = 0; j < L1.size(); j++) {
                boolean condition;
                if (!DESC) {
                    condition = currentVal < L1.get(j);
                }
                else {
                    condition = currentVal > L1.get(j);
                }

                if (condition || (currentVal == L1.get(j))) {
                    L1.addBetween(currentVal, L1.getNode(j).getPrev(), L1.getNode(j));
                    break;
                }
            }
        }

        if (L1.size() != oldL1Size + L2.size()) {
            L1.add(L2.get(L2.size() - 1));
        }
    }
}