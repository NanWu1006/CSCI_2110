package Q1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

/**
 * test case for Assignment 3
 * @author Diqi Zeng
 */
public class testBST {
    static BinarySearchTree<Integer> binarySearchTreeOne = new BinarySearchTree<>();
    static BinarySearchTree<Integer> binarySearchTreeTwo = new BinarySearchTree<>();

    public static void main(String[] args) {
        QuestionA();
        QuestionB();
        QuestionC();
    }

    public static Set<Integer> genRandUniqNumbers() {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        while (hashMap.keySet().size() < 20) {
            hashMap.put((new Random()).nextInt(100), true);
        }
        return hashMap.keySet();
    }

    public static void QuestionA() {
        Set<Integer> randDataOne = genRandUniqNumbers();
        Set<Integer> randDataTwo = genRandUniqNumbers();
        for (Integer eachRandInt : randDataOne) {
            binarySearchTreeOne.insert(eachRandInt);
        }
        for (Integer eachRandInt : randDataTwo) {
            binarySearchTreeTwo.insert(eachRandInt);
        }
    }

    public static void QuestionB() {
        System.out.printf("BST #1: %s\n", binarySearchTreeOne.sort());
        System.out.printf("BST #2: %s\n", binarySearchTreeTwo.sort());
    }

    public static void QuestionC() {
        ArrayList<Integer> resultOne = new ArrayList<>();
        ArrayList<Integer> resultTwo = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Integer tmpMin = binarySearchTreeOne.minKey();
            binarySearchTreeOne.delete(tmpMin);
            resultOne.add(tmpMin);

            tmpMin = binarySearchTreeTwo.minKey();
            binarySearchTreeTwo.delete(tmpMin);
            resultTwo.add(tmpMin);
        }
        System.out.printf("BST #1 sorted sequence: %s\n", resultOne);
        System.out.printf("BST #2 sorted sequence: %s\n", resultTwo);
    }
}
// BST #1: [0, 97, 68, 5, 9, 16, 51, 22, 27, 30, 31, 59, 60, 63, 70, 73, 75, 77, 84, 92]
// BST #2: [96, 66, 39, 9, 14, 17, 21, 22, 41, 42, 44, 45, 49, 54, 59, 69, 73, 74, 78, 92]
// BST #1 sorted sequence: [0, 5, 9, 16, 22, 27, 30, 31, 51, 59, 60, 63, 68, 70, 73, 75, 77, 84, 92, 97]
// BST #2 sorted sequence: [9, 14, 17, 21, 22, 39, 41, 42, 44, 45, 49, 54, 59, 66, 69, 73, 74, 78, 92, 96]