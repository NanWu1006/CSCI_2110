package Q1;

/**
 * Assignment 2 Part #1
 * @author Diqi Zeng
 */
public class Q1 {
    public static void main(String[] args) {
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

        root.inorder();
        System.out.println();
        root.preorder();
        System.out.println();
        root.postorder();
        System.out.println();

        System.out.printf("DEPTH: %s\n", root.depth());
        root.ancestors();
        System.out.printf("isValidBST: %s\n", root.checkBS());
        System.out.printf("checkHB: %s\n", root.checkHB());
    }
}