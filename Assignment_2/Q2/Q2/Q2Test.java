package Q2;

import Q1.BinaryTree;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author Diqi Zeng
 *
 */
public class Q2Test {
    public static void main(String[] args) throws FileNotFoundException {
        testOne();
        testTwo();
        testThree();
        testFour();
        testFive();
    }

    public static void testOne() throws FileNotFoundException {
        /**
         * equals to second line + " " + third line
         */
        int TEST_NO = 1;
        String inAndPreOrderSignatureSample = generateTestFileOne();
        BinaryTree<String> binaryTree = TestBTClass.readTraversals("Q2_test_tmp/test_" + TEST_NO);
        String inAndPreOrderSignature = getSignature(binaryTree);
        if (inAndPreOrderSignatureSample.equals(inAndPreOrderSignature)) {
            System.out.printf("Test #%s passed\n", TEST_NO);
        }
        else {
            System.out.printf("Test #%s failed\n", TEST_NO);
        }
    }

    public static void testTwo() throws FileNotFoundException {
        /**
         * equals to second line + " " + third line
         */
        int TEST_NO = 2;
        String inAndPreOrderSignatureSample = generateTestFileTwo();
        BinaryTree<String> binaryTree = TestBTClass.readTraversals("Q2_test_tmp/test_" + TEST_NO);
        String inAndPreOrderSignature = getSignature(binaryTree);
        if (inAndPreOrderSignatureSample.equals(inAndPreOrderSignature)) {
            System.out.printf("Test #%s passed\n", TEST_NO);
        }
        else {
            System.out.printf("Test #%s failed\n", TEST_NO);
        }
    }

    public static void testThree() throws FileNotFoundException {
        /**
         * equals to second line + " " + third line
         */
        int TEST_NO = 3;
        String inAndPreOrderSignatureSample = generateTestFileThree();
        BinaryTree<String> binaryTree = TestBTClass.readTraversals("Q2_test_tmp/test_" + TEST_NO);
        String inAndPreOrderSignature = getSignature(binaryTree);
        if (inAndPreOrderSignatureSample.equals(inAndPreOrderSignature)) {
            System.out.printf("Test #%s passed\n", TEST_NO);
        }
        else {
            System.out.printf("Test #%s failed\n", TEST_NO);
        }
    }

    public static void testFour() throws FileNotFoundException {
        /**
         * equals to second line + " " + third line
         */
        int TEST_NO = 4;
        String inAndPreOrderSignatureSample = generateTestFileFour();
        BinaryTree<String> binaryTree = TestBTClass.readTraversals("Q2_test_tmp/test_" + TEST_NO);
        String inAndPreOrderSignature = getSignature(binaryTree);
        if (inAndPreOrderSignatureSample.equals(inAndPreOrderSignature)) {
            System.out.printf("Test #%s passed\n", TEST_NO);
        }
        else {
            System.out.printf("Test #%s failed\n", TEST_NO);
        }
    }

    public static void testFive() throws FileNotFoundException {
        /**
         * equals to second line + " " + third line
         */
        int TEST_NO = 5;
        String inAndPreOrderSignatureSample = generateTestFileFive();
        BinaryTree<String> binaryTree = TestBTClass.readTraversals("Q2_test_tmp/test_" + TEST_NO);
        String inAndPreOrderSignature = getSignature(binaryTree);
        if (inAndPreOrderSignatureSample.equals(inAndPreOrderSignature)) {
            System.out.printf("Test #%s passed\n", TEST_NO);
        }
        else {
            System.out.printf("Test #%s failed\n", TEST_NO);
        }
    }

    public static String generateTestFileOne() throws FileNotFoundException {
        BinaryTree<Integer> root = new BinaryTree<Integer>();
        root.makeRoot(10);

        root.attachLeftChain(BinaryTree.initWithIntegerRootValue(9))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(8))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(7))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(6))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(5))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(4))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(3))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(2))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(1));

        root.attachRightChain(BinaryTree.initWithIntegerRootValue(11))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(12))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(13))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(14))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(15))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(16))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(17))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(18))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(19))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(20));

        return saveTestFileWithFileName(root, "Q2_test_tmp/test_1");
    }

    public static String generateTestFileTwo() throws FileNotFoundException {
        BinaryTree<Integer> root = new BinaryTree<Integer>();
        root.makeRoot(10);

        root.attachLeftChain(BinaryTree.initWithIntegerRootValue(9))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(8))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(7))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(6))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(5))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(4))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(3))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(2))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(1));

        root.attachRightChain(BinaryTree.initWithIntegerRootValue(11))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(12))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(13))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(14))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(15))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(16))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(17))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(18))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(19));

        return saveTestFileWithFileName(root, "Q2_test_tmp/test_2");
    }

    public static String generateTestFileThree() throws FileNotFoundException {
        BinaryTree<Integer> root = new BinaryTree<Integer>();
        root.makeRoot(10);

        root.attachLeftChain(BinaryTree.initWithIntegerRootValue(9))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(8))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(7))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(6))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(5))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(4))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(3))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(2))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(1));

        root.attachRightChain(BinaryTree.initWithIntegerRootValue(11))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(12))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(13))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(14))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(15))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(16))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(17))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(18));

        return saveTestFileWithFileName(root, "Q2_test_tmp/test_3");
    }

    public static String generateTestFileFour() throws FileNotFoundException {
        BinaryTree<Integer> root = new BinaryTree<Integer>();
        root.makeRoot(10);

        root.attachLeftChain(BinaryTree.initWithIntegerRootValue(9))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(8))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(7))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(6))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(5))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(4))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(3))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(2))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(1));

        root.attachRightChain(BinaryTree.initWithIntegerRootValue(11))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(12))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(13))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(14))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(15))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(16))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(17));

        return saveTestFileWithFileName(root, "Q2_test_tmp/test_4");
    }

    public static String generateTestFileFive() throws FileNotFoundException {
        BinaryTree<Integer> root = new BinaryTree<Integer>();
        root.makeRoot(10);

        root.attachLeftChain(BinaryTree.initWithIntegerRootValue(9))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(8))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(7))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(6))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(5))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(4))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(3))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(2))
                .attachLeftChain(BinaryTree.initWithIntegerRootValue(1));

        root.attachRightChain(BinaryTree.initWithIntegerRootValue(11))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(12))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(13))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(14))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(15))
                .attachRightChain(BinaryTree.initWithIntegerRootValue(16));

        return saveTestFileWithFileName(root, "Q2_test_tmp/test_5");
    }

    public static String saveTestFileWithFileName(BinaryTree<Integer> binaryTree, String filePath) throws FileNotFoundException {
        ArrayList<String> preOrder = binaryTree.getPreorder();
        ArrayList<String> inOrder = binaryTree.getInorder();
        String firstLine = Integer.toString(preOrder.size());
        String secondLine = String.join(" ", preOrder);
        String thirdLine = String.join(" ", inOrder);

        PrintWriter printWriter = new PrintWriter(filePath);
        printWriter.println(firstLine);
        printWriter.println(secondLine);
        printWriter.println(thirdLine);
        printWriter.close();
        return secondLine + " " + thirdLine;
    }

    public static String getSignature(BinaryTree<String> binaryTree) {
        ArrayList<String> preOrder = binaryTree.getPreorder();
        ArrayList<String> inOrder = binaryTree.getInorder();
        String secondLine = String.join(" ", preOrder);
        String thirdLine = String.join(" ", inOrder);
        return secondLine + " " + thirdLine;
    }
}