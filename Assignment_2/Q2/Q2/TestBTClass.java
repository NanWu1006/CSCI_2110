package Q2;

import Q1.BinaryTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Diqi Zeng
 *
 * HOW TO USE:
 * enter Q2_test for testing
 *
 * Q2 (d) see Q2Test
 *
 */
public class TestBTClass {
//    public static void main(String[] args) throws FileNotFoundException {
//        BinaryTree<String> binaryTree = readTraversals("Q2_test");
//
//        binaryTree.inorder();
//        System.out.println();
//        binaryTree.preorder();
//        System.out.println();
//        binaryTree.postorder();
//        System.out.println();
//
//        ArrayList<Integer> preOrderArr = new ArrayList<>(Arrays.asList(10,1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17,18,19,20));
//        ArrayList<String> preOrder = preOrderArr.stream().map(Object::toString).collect(Collectors.toCollection(ArrayList::new));
//
//        ArrayList<Integer> inOrderArr = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
//        ArrayList<String> inOrder = inOrderArr.stream().map(Object::toString).collect(Collectors.toCollection(ArrayList::new));
//
//        BinaryTree<String> integerBinaryTree = buildBinaryTree(preOrder, inOrder);
//        integerBinaryTree.inorder();
//        System.out.println();
//        integerBinaryTree.preorder();
//        System.out.println();
//        integerBinaryTree.postorder();
//        System.out.println();
//    }

    public static BinaryTree<String> readTraversals(String filePath) throws FileNotFoundException {
//        System.out.println("Current Working Directory = " + System.getProperty("user.dir"));
//        System.out.print("Input the file path: ");
//        Scanner inputScanner = new Scanner(System.in);
//        String filePath = inputScanner.next();
//        System.out.println("filePath = " + filePath);

        ArrayList<String> preOrder = new ArrayList<>();
        ArrayList<String> inOrder = new ArrayList<>();

        Scanner fileScanner = new Scanner(new File(filePath));
        Integer nodesCount = fileScanner.nextInt();
        int i = 0;
        while (fileScanner.hasNext()) {
            if (i < nodesCount) {
                preOrder.add(fileScanner.next());
            }
            else {
                inOrder.add(fileScanner.next());
            }
            i++;
        }
        fileScanner.close();

        return buildBinaryTree(preOrder, inOrder);
    }

    public static BinaryTree<String> buildBinaryTree(ArrayList<String> preOrderArr, ArrayList<String> inOrderArr) {
        /**
         * detect if null, BASIC CASE
         */
        if (preOrderArr == null || inOrderArr == null) {
            return null;
        }
        else {
            /**
             * store in-order values
             */
            HashMap<String, Integer> dataMap = new HashMap<>();
            for (int i = 0; i < inOrderArr.size(); i++) {
                dataMap.put(inOrderArr.get(i), i);
            }
            /**
             * start recursive
             */
            return buildBinaryTree(preOrderArr, 0, preOrderArr.size() - 1, 0, inOrderArr.size() - 1, dataMap);
        }
    }
    private static BinaryTree<String> buildBinaryTree(ArrayList<String> preOrderArr,
                                                 int preOrderIndexLeft,
                                                 int preOrderIndexRight,
                                                 int inOrderIndexLeft,
                                                 int inOrderIndexRight,
                                                 HashMap<String, Integer> dataMap) {
        /**
         * BASIC CASE
         */
        if (preOrderIndexLeft > preOrderIndexRight || inOrderIndexLeft > inOrderIndexRight) {
            return null;
        }
        else {
            /**
             * add new tree
             */
            BinaryTree<String> binaryTree = BinaryTree.initWithStringRootValue(preOrderArr.get(preOrderIndexLeft));
            Integer tmpIndex = dataMap.get(binaryTree.getData());
            binaryTree.left = buildBinaryTree(preOrderArr,
                    preOrderIndexLeft + 1,
                    tmpIndex - inOrderIndexLeft + preOrderIndexLeft,
                    inOrderIndexLeft,
                    tmpIndex - 1,
                    dataMap);
            binaryTree.right = buildBinaryTree(preOrderArr,
                    preOrderIndexLeft + tmpIndex - inOrderIndexLeft + 1,
                    preOrderIndexRight,
                    tmpIndex + 1,
                    inOrderIndexRight,
                    dataMap);
            return binaryTree;
        }
    }
}
