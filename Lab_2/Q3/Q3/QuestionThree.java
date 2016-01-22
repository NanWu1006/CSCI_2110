package Q3;

/**
 * Created by KanzakiMirai on 1/21/16.
 */
public class QuestionThree {
    public static SinglyLinkedList<Integer> addSLists (SinglyLinkedList<Integer> L1,
                                                       SinglyLinkedList<Integer> L2) {
        Integer firstVal = parseIntFromList(L1);
        Integer secondVal = parseIntFromList(L2);

        System.out.println("firstVal = " + firstVal);
        System.out.println("secondVal = " + secondVal);

        /**
         * ADD OPERATION
         */
        String resultVal = Integer.toString(firstVal + secondVal);

        SinglyLinkedList<Integer> resultLL = new SinglyLinkedList<>();

        for (char eachChar : resultVal.toCharArray()) {
            resultLL.add(Integer.parseInt(String.valueOf(eachChar)));
        }

        System.out.println("result = " + resultVal);

        return resultLL;
    }

    static Integer parseIntFromList(SinglyLinkedList<Integer> inputL) {
        Integer result = 0;
        /**
         * FOR EXAMPLE number 123
         * presented as [3, 2, 1]
         * equals to 1 * 10^0 + 2 * 10^1 + 3 * 10^2
         *
         * which can presented as 10^i
         */
        for (int i = 0; i < inputL.size(); i++) {
            result = result + ( inputL.get(i) * ((Double)Math.pow(10, i)).intValue() );
        }
        return result;
    }
}