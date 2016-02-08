package Q3;

/**
 * Created by KanzakiMirai on 1/12/16.
 */

/**
 * A test class for Q3
 *
 * @author Diqi Zeng
 */
public class Test {
    public static void main(String[] args) {
        Test1();
        System.out.println("ALL TEST PASSED!");
    }

    static void Test1() {
        String[] strings = new String[]{
                "Was it a car or a cat I saw",
                "step on no pets",
                "stack cats",
                "race car",
                "stack cats",
                "In girum imus nocte et consumimur igni",
                "Do geese see God",
                "Mr Owl ate my metal worm",
                "Eva can I stab bat in a cave",
                "Go hang a salami I am a lasagna hog"
        };
        for (String eachString : strings) {
            System.out.println(String.format("\"%s\" IS %sPalindrome.",
                    eachString,
                    Q3.QuestionThree.isPalindrome(eachString) ? "" : "NOT "));
        }
    }
}
