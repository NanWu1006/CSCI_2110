package Q5;

/**
 * Created by KanzakiMirai on 1/12/16.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Q5 class
 *
 * With Comparator, you can define your rule for
 * comparing / ordering against objects using Lists
 *
 * With INTERFACE Comparable, you can only define one SINGLE RULE
 * for objects for comparing / ordering
 *
 * IF you don't need to compare / order more than ONE attributes / fields
 * of them, you using Comparable can make code more simple.
 *
 * BUT if you have the demand for comparing / ordering MORE THAN ONE
 * attributes / fields, you should use Comparator
 *
 * @author Diqi Zeng
 */
public class QuestionFive {
    public static void main(String[] args) {
        System.out.println("Initial List");
        ArrayList<iPhone> iPhoneArrayList = new ArrayList<>();
        iPhoneArrayList.add(new iPhone("iPhone 5S", 500, 64));
        iPhoneArrayList.add(new iPhone("iPhone 5S", 550, 128));
        iPhoneArrayList.add(new iPhone("iPhone 6", 600, 64));
        iPhoneArrayList.add(new iPhone("iPhone 6S", 700, 64));
        iPhoneArrayList.add(new iPhone("iPhone 6S Plus", 750, 16));

        System.out.println("Comparing iPhones by PRICE DESC using Comparable");
        Collections.sort(iPhoneArrayList);
        System.out.println(iPhoneArrayList);
        System.out.println();

        System.out.println("Comparing iPhones by PRICE DESC using Comparator");
        Comparator<iPhone> priceComparatorDESC = (o1, o2) -> o1.price - o2.price;
        Collections.sort(iPhoneArrayList, priceComparatorDESC);
        System.out.println(iPhoneArrayList);
        System.out.println();

        System.out.println("Comparing iPhones by PRICE ASC using Comparator");
        Comparator<iPhone> priceComparatorASC = (o1, o2) -> o2.price - o1.price;
        Collections.sort(iPhoneArrayList, priceComparatorASC);
        System.out.println(iPhoneArrayList);
        System.out.println();

        System.out.println("Comparing iPhones by RAM SIZE DESC using Comparator");
        Comparator<iPhone> ramComparatorDESC = (o1, o2) -> o1.ramSize - o2.ramSize;
        Collections.sort(iPhoneArrayList, ramComparatorDESC);
        System.out.println(iPhoneArrayList);
        System.out.println();

        System.out.println("Comparing iPhones by RAM SIZE ASC using Comparator");
        Comparator<iPhone> ramComparatorASC = (o1, o2) -> o2.ramSize - o1.ramSize;
        Collections.sort(iPhoneArrayList, ramComparatorASC);
        System.out.println(iPhoneArrayList);
        System.out.println();
    }
}

class iPhone implements Comparable<iPhone> {
    String model;
    Integer price;
    Integer ramSize;

    public iPhone(String model, Integer price, Integer ramSize) {
        this.model = model;
        this.price = price;
        this.ramSize = ramSize;
    }

    @Override
    public int compareTo(iPhone o) {
        return o.price - this.price;
    }

    @Override
    public String toString() {
        return String.format("%s $%s %sGB", model, price, ramSize);
    }
}