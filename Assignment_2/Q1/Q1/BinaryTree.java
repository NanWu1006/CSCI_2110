package Q1;

import java.util.ArrayList;

/**
 * This class implements a low-level binary tree structure that can be
 * accessed and manipulated via its nodes and its links. The structure
 * is represented in a recursive fashion, i.e. an instance of this class
 * is really a node object that is the root of a binary tree.
 *
 * @param <T> Type of objects stored in this tree.
 * @author Sesh Venugopal
 */
public class BinaryTree<T extends Comparable<? super T>> {

    /**
     * Data stored in a node.
     */
    protected T data;

    /**
     * Left child of this node.
     */
    public BinaryTree<T> left;

    /**
     * Right child of this node.
     */
    public BinaryTree<T> right;

    /**
     * Parent of this node.
     */
    public BinaryTree<T> parent;

    /**
     * Initializes this binary tree to empty.
     */
    public BinaryTree() {
        data = null;
        left = null;
        right = null;
        parent = null;
    }

    public static BinaryTree<Integer> initWithIntegerRootValue(Integer intVal) {
        BinaryTree<Integer> integerBinaryTree = new BinaryTree<Integer>();
        integerBinaryTree.makeRoot(intVal);
        return integerBinaryTree;
    }

    public static BinaryTree<String> initWithStringRootValue(String stringVal) {
        BinaryTree<String> stringBinaryTree = new BinaryTree<String>();
        stringBinaryTree.makeRoot(stringVal);
        return stringBinaryTree;
    }

    /**
     * Makes the root node of this binary tree.
     *
     * @param data Data to be stored at this root node.
     * @throws TreeViolationException If there is already a root node.
     */
    public void makeRoot(T data) {
        if (this.data != null) {
            throw new TreeViolationException();
        }
        this.data = data;
    }

    /**
     * Sets the data at this node to given data.
     *
     * @param data Data to be written into this node, replacing existing data.
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Returns the data at this node.
     *
     * @return Data at this node.
     */
    public T getData() {
        return data;
    }

    /**
     * Attaches given tree (root node of tree) as the left child of this node.
     *
     * @param tree Tree (root node) to be attached.
     * @throws TreeViolationException If this node already has a left child.
     */
    public void attachLeft(BinaryTree<T> tree) {
        if (left != null) {
            throw new TreeViolationException();
        }
        if (tree != null) {
            tree.parent = this;
            left = tree;
        }
    }

    /**
     * this 2 methods for chain calling
     * @param tree sub-tree
     * @return sub-tree
     */
    public BinaryTree<T> attachLeftChain(BinaryTree<T> tree) {
        this.attachLeft(tree);
        return tree;
    }

    public BinaryTree<T> attachRightChain(BinaryTree<T> tree) {
        this.attachRight(tree);
        return tree;
    }

    /**
     * Attaches given tree (root node of tree) as the right child of this node.
     *
     * @param tree Tree (root node) to be attached.
     * @throws TreeViolationException If this node already has a right child.
     */
    public void attachRight(BinaryTree<T> tree) {
        if (right != null) {
            throw new TreeViolationException();
        }
        if (tree != null) {
            tree.parent = this;
            right = tree;
        }
    }

    /**
     * Detaches and returns the left child of this node.
     *
     * @return Left child of this node.
     */
    public BinaryTree<T> detachLeft() {
        BinaryTree<T> retleft = left;
        left = null;
        return retleft;
    }

    /**
     * Detaches and returns the right child of this node.
     *
     * @return Right child of this node.
     */
    public BinaryTree<T> detachRight() {
        BinaryTree<T> retright = right;
        right = null;
        return retright;
    }

    /**
     * Tells whether this tree is empty or not.
     *
     * @return True if this is tree is empty, false otherwise.
     */
    public boolean isEmpty() {
        return data == null;
    }

    /**
     * Empties this tree by removing all nodes including root. To start over,
     * the makeRoot method must be called.
     */
    public void clear() {
        left = null;
        right = null;
        data = null;
        parent = null;
    }

    /**
     * Returns the root of the tree that contains this node.
     *
     * @return Root of the tree.
     */
    public BinaryTree<T> root() {
        if (parent == null) { // this itself is the root
            return this;
        }
        BinaryTree<T> nextParent = parent;
        while (nextParent.parent != null) {
            nextParent = nextParent.parent;
        }
        return nextParent;
    }

    public void inorder() {
        inorder(this);
    }

    private void inorder(BinaryTree binaryTree) {
        if (binaryTree == null) {
            return;
        }
        inorder(binaryTree.left);
        System.out.println(binaryTree.getData());
        inorder(binaryTree.right);
    }

    public ArrayList<String> getInorder() {
        ArrayList<String> result = new ArrayList<>();
        getInorder(this, result);
        return result;
    }

    private void getInorder(BinaryTree binaryTree, ArrayList<String> result) {
        if (binaryTree == null) {
            return;
        }
        getInorder(binaryTree.left, result);
        result.add(binaryTree.getData().toString());
        getInorder(binaryTree.right, result);
    }

    public void postorder() {
        postorder(this);
    }

    private void postorder(BinaryTree binaryTree) {
        if (binaryTree == null) {
            return;
        }
        inorder(binaryTree.left);
        inorder(binaryTree.right);
        System.out.println(binaryTree.getData());
    }

    public void preorder() {
        preorder(this);
    }

    private void preorder(BinaryTree binaryTree) {
        if (binaryTree == null) {
            return;
        }
        System.out.println(binaryTree.getData());
        inorder(binaryTree.left);
        inorder(binaryTree.right);
    }

    public ArrayList<String> getPreorder() {
        ArrayList<String> result = new ArrayList<>();
        getPreorder(this, result);
        return result;
    }

    private void getPreorder(BinaryTree binaryTree, ArrayList<String> result) {
        if (binaryTree == null) {
            return;
        }
        result.add(binaryTree.getData().toString());
        getPreorder(binaryTree.left, result);
        getPreorder(binaryTree.right, result);
    }

    public int depth() {
        return depth(this, 0);
    }

    private int depth(BinaryTree binaryTree, int tmp) {
        int depthCountLeft = tmp;
        int depthCountRight = tmp;

        if (binaryTree.left != null) {
           depthCountLeft = depth(binaryTree.left, tmp + 1);
        }
        if (binaryTree.right != null) {
            depthCountRight = depth(binaryTree.right, tmp + 1);
        }

        if (depthCountLeft > depthCountRight) {
            return depthCountLeft;
        }
        else {
            return depthCountRight;
        }
    }

    public void ancestors() {
        ancestors(this);
    }

    private void ancestors(BinaryTree node) {
        if (node != null) {
            if (node.left != null || node.right != null) {
                System.out.printf("DATA: %s\n", node.getData());
            }
            ancestors(node.left);
            ancestors(node.right);
        }
    }

    public boolean checkBS() {
        return checkBS(this, null, null);
    }

    private boolean checkBS(BinaryTree binaryTree, T minData, T maxData) {
        if (binaryTree == null) {
            return true;
        }

        int minCompareResult;
        int maxCompareResult;

        if (minData != null) {
            minCompareResult = binaryTree.getData().compareTo(minData);
        }
        else {
            minCompareResult = Integer.MAX_VALUE;
        }
        if (maxData != null) {
            maxCompareResult = binaryTree.getData().compareTo(maxData);
        }
        else {
            maxCompareResult = Integer.MIN_VALUE;
        }

        if (minCompareResult <= 0 || maxCompareResult >= 0) {
            return false;
        }
        else {
            return checkBS(binaryTree.left, minData, (T)binaryTree.getData()) &&
                    checkBS(binaryTree.right, (T)binaryTree.getData(), maxData);
        }
    }

    public boolean checkHB() {
        return checkHB(this);
    }

    boolean checkHB(BinaryTree binaryTree) {
        int LHSDepth;
        int RHSDepth;

        if (binaryTree == null) {
            return true;
        }

        if (binaryTree.left == null) {
            LHSDepth = 0;
        }
        else {
            LHSDepth = binaryTree.left.depth();
        }
        if (binaryTree.right == null) {
            RHSDepth = 0;
        }
        else {
            RHSDepth = binaryTree.right.depth();
        }

        return Math.abs(LHSDepth - RHSDepth) <= 1
                && checkHB(binaryTree.left)
                && checkHB(binaryTree.right);

    }
}

/* 
Example:

To create the following tree you need to use the following statements. Each node of the tree is a 
binary tree based on the recursive definition.

   A
  / \
B    C


BinaryTree<String> root = new BinaryTree<String>();
root.makeRoot("A");

BinaryTree<String> leftChild = new BinaryTree<String>();
leftChild.makeRoot("B");

BinaryTree<String> rightChild = new BinaryTree<String>();
rightChild.makeRoot("C");

root.attachLeft(leftChild);
root.attachRight(rightChild);

*/




