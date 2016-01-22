package Q3;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by KanzakiMirai on 1/21/16.
 */
public class QuestionThree {
    public static SinglyLinkedList<Integer> addSLists (SinglyLinkedList<Integer> L1,
                                                       SinglyLinkedList<Integer> L2) {
        /**
         * first convert singly linked list INTO ArrayList
         */
        ArrayList<String> firstValAL = new ArrayList<>();
        for (int i = 0; i < L1.size(); i++) {
            firstValAL.add(L1.get(i).toString());
        }
        /**
         * REVERSE
         */
        Collections.reverse(firstValAL);

        /**
         * RESTORE into a normal value String
         */
        String firstVal = "";
        for (String eachStr : firstValAL) {
            firstVal += eachStr;
        }


        ArrayList<String> secondValAL = new ArrayList<>();
        for (int i = 0; i < L2.size(); i++) {
            secondValAL.add(L2.get(i).toString());
        }
        Collections.reverse(secondValAL);

        String secondVal = "";
        for (String eachStr : secondValAL) {
            secondVal += eachStr;
        }

        System.out.println("firstVal = " + firstVal);
        System.out.println("secondVal = " + secondVal);

        /**
         * ADD OPERATION
         */
        String resultVal = Integer.toString(Integer.parseInt(firstVal) + Integer.parseInt(secondVal));

        SinglyLinkedList<Integer> resultLL = new SinglyLinkedList<>();

        for (char eachChar : resultVal.toCharArray()) {
            resultLL.add(Integer.parseInt(String.valueOf(eachChar)));
        }

        return resultLL;
    }
}