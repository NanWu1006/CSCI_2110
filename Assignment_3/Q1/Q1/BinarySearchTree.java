package Q1;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * This class implements a simple (not balanced) generic binary search tree. Duplicate keys
 * are not permitted.
 * 
 * @author Sesh Venugopal
 *
 * @param <T> The type of data stored in the nodes of the tree, must implement
 * 				Comparable<T> with the compareTo method.
 */
public class BinarySearchTree<T extends Comparable<T>> {
	
	/**
	 * Binary tree component which maintains the tree structure.
	 */
	BinaryTree<T> tree;
	
	/**
	 * Number of entries in this BST.
	 */
	int size;
	
	/**
	 * Initializes this BST instance to empty.
	 */
	public BinarySearchTree() {
		tree = new BinaryTree<T>();
		size = 0;
	}
	
	/**
	 * Tells whether this BST is empty or not.
	 * 
	 * @return True if this BST is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return tree.isEmpty();
	}
	
	/**
	 * Implements a recursive binary search on a binary (search) tree given its
	 * root, looking for a given key.  
	 * 
	 * @param root Root of binary (search) tree to be searched.
	 * @param key Key that is searched for.
	 * @return The binary (search) tree node whose data matches the key, null if no match
	 * 			is found for the key in the tree.
	 */
	protected BinaryTree<T> recursiveSearch(BinaryTree<T> root, T key) {
		if (root == null) {
			return null;
		}
		int c = key.compareTo(root.data);
		if (c == 0) {
			return root;
		}
		if (c < 0) {
			return recursiveSearch(root.left, key);
		} else {
			return recursiveSearch(root.right, key);
		}
	}
	
	/**
	 * Searches this BST for a given key.
	 * 
	 * @param key Key that is searched for.
	 * @return Data entry in this BST that matches the given key, null if no match is
	 * 			found for the key in this BST.
	 */
	public T search(T key) {
		if (tree.isEmpty()) { 
			return null;
		}
		return recursiveSearch(tree, key).data;
	}

	/**
	 * search this BST iterative
	 *
	 * @param key Key that is searched for.
	 * @return Data entry in this BST that matches the given key, null if no match is found for the key in this BST.
     */
	public T nonRecSearch(T key) {
		if (tree.isEmpty()) {
			return null;
		}
		else {
			BinaryTree<T> currentNode = tree;
			while (currentNode != null) {
				int c = key.compareTo(currentNode.data);
				if (c == 0) {
					return currentNode.data;
				}
				if (c < 0) {
					currentNode = currentNode.left;
				} else {
					currentNode = currentNode.right;
				}
			}
		}
		return null;
	}
	
	/**
	 * Inserts a given item into this BST.
	 * 
	 * @param item Item to be inserted.
	 * @throws OrderViolationException If there is already a key in this BST that matches
	 * 								this item, i.e. inserting would result in duplicate keys.
	 */
	public void insert(T item) {
		
		if (tree.isEmpty()) { // insert here
			tree.makeRoot(item);
			size++;
			return;
		}
		
		// do an iterative descent
		BinaryTree<T> root = tree;
		boolean done=false;
		BinaryTree<T> newNode = null;
		while (!done) {
			int c = item.compareTo(root.data);
			if (c == 0) { // duplicate found, cannot be inserted
				throw new OrderViolationException();
			}
			if (c < 0) { // insert in left subtree
				if (root.left == null) { // insert here as left child
					newNode = new BinaryTree<T>();
					root.left = newNode;
					done=true;
				} else { // go further down left subtree
					root = root.left;
				}
			} else { // insert in right subtree
				if (root.right == null) { // insert here as right child 
					newNode = new BinaryTree<T>();
					root.right = newNode;
					done=true;
				} else { // go further down right subtree
					root = root.right;
				}
			}
		}
		// set fields of new node
		newNode.data = item;
		newNode.parent = root;
		size++;
	}

	public void recInsert(T item) {
		recursiveInsert(tree, item);
	}

	protected BinaryTree<T> recursiveInsert(BinaryTree<T> root, T item) {
		if (tree.isEmpty()) { // insert here
			tree.makeRoot(item);
			size++;
		}
		int c = item.compareTo(root.data);
		if (c == 0) {
			return root;
		}
		if (c < 0) {
			if (root.left == null) {
				BinaryTree<T> newNode = new BinaryTree<T>();
				newNode.data = item;
				root.left = newNode;
				size++;
				return root.left;
			}
			else {
				return recursiveInsert(root.left, item);
			}
		} else {
			if (root.right == null) {
				BinaryTree<T> newNode = new BinaryTree<T>();
				newNode.data = item;
				root.right = newNode;
				size++;
				return root.left;
			}
			else {
				return recursiveInsert(root.right, item);
			}
		}
	}

	/**
	 * Attaches a given tree node to the parent of another node which is deleted
	 * after this method. The attachment to the parent node will be on the side at
	 * which the to-be-deleted node is.
	 * 
	 * @param deleteNode Node whose parent will receive new node as right or left child,
	 * 					depending on whether this node is its parent's right or left child. 
	 * @param attach The node to be attached to parent of deleteNode.
	 */
	protected void deleteHere(BinaryTree<T> deleteNode, BinaryTree<T> attach) {
		
		// deleteNode has only one subtree, attach
		BinaryTree<T> parent = deleteNode.parent;
		deleteNode.clear();  // clear the fields
		if (parent == null) {
			return;
		}
		if (deleteNode == parent.left) {
			// left child of parent, attach as left subtree
			parent.detachLeft();
			parent.attachLeft(attach);
			return;
		}
		// attach as right subtree
		parent.detachRight();
		parent.attachRight(attach);
	}
	
	/**
	 * Returns the node that is the inorder predecessor of a given node, with the
	 * precondition that the given node has a non-null left child.
	 * 
	 * @param node Node whose inorder predecessor is to be found.
	 * @return Inorder predecessor of given node.
	 */
	protected BinaryTree<T> findPredecessor(BinaryTree<T> node) {
		if (node.left == null) {
			return null;
		}
		BinaryTree<T> pred = node.left; // turn left once
		while (pred.right != null) { // keep turning right
			pred = pred.right;
		}
		return pred;
	}
	
	/**
	 * Deletes from this BST the item that matches the given key,and returns the item.
	 * 
	 * @param key Key of to-be-deleted item.
	 * @return The deleted item.
	 * @throws NoSuchElementException If there is no item in this BST that matches the given key.
	 */
	public T delete(T key) {
		if (tree.isEmpty()) { // can't delete from an empty tree
			throw new NoSuchElementException();
		}
		
		// find node containing key 
		BinaryTree<T> deleteNode = recursiveSearch(tree, key);
		if (deleteNode == null) { // data not found, can't delete
			throw new NoSuchElementException();
		}
		
		BinaryTree<T> hold;
		
		// case c: deleteNode has exactly two subtrees
		if (deleteNode.right != null && deleteNode.left != null) {
			hold = findPredecessor(deleteNode);
			deleteNode.data = hold.data;
			deleteNode = hold; // fall through to case a or b
		}
		
		// case a: deleteNode is a leaf
		if (deleteNode.left == null && deleteNode.right == null) {
			deleteHere(deleteNode, null);
			size--;
			return deleteNode.data;
		}		
		
		// case b: deleteNode has exactly one subtree
		if (deleteNode.right != null) {
			hold = deleteNode.right;
			deleteNode.right = null;
		} else {
			hold = deleteNode.left;
			deleteNode.left = null;
		}
		
		deleteHere(deleteNode,hold);
		if (tree == deleteNode) { // root deleted
			tree = hold;
		}
		size--;
		return deleteNode.data;
	}
	
	/**
	 * Finds the minimum-valued key item in this BST.
	 * 
	 * @return Item in this BST that has the minimum of all key values.
	 * @throws NoSuchElementException If this BST is empty.
	 */
	public T minKey() {
		if (tree.data == null) { // tree empty, can't find min value
			throw new NoSuchElementException();
		}
		
		BinaryTree<T> root = tree;
		T min=root.data;
		root = root.left;  // turn left once
		while (root != null) {  // keep going left to leftmost node
			min = root.data;
			root = root.left;
		}
		return min;
	}
	
	/**
	 * Finds the maximum-valued key item in this BST.
	 * 
	 * @return Item in this BST that has the maximum of all key values.
	 * @throws NoSuchElementException If this BST is empty.
	 */
	public T maxKey() {
		if (tree.getData() == null) { // tree empty, can't find max value
			throw new NoSuchElementException();
		}
		
		BinaryTree<T> root=tree;
		T max=root.data;
		root = root.right;  // turn right once
		while (root != null) { // keep going to rightmost node
			max = root.data;
			root = root.right;
		}
		return max;
	}
	
	/**
	 * Returns the number of items in this BST.
	 * 
	 * @return Number of items in this BST.
	 */
	public int size() {
		return size;
	}

	/**
	 * calls the function from binary tree class
	 */
	public void preorder() {
		tree.preorder();
	}

	/**
	 * calls the function from binary tree class
	 */
	public void inorder() {
		tree.inorder();
	}

	/**
	 * calls the function from binary tree class
	 */
	public void postorder() {
		tree.postorder();
	}

	protected BinaryTree<T> findSuccessor(BinaryTree<T> node) {
		return findSuccessor(tree, node);
	}

	protected BinaryTree<T> findSuccessor(BinaryTree<T> node, BinaryTree<T> targetNode) {
		BinaryTree<T> tempSuccessor = null;
		while (node != null && node.data.compareTo(targetNode.data) != 0) {
			if (node.data.compareTo(targetNode.data) > 0) {
				tempSuccessor = node;
				node = node.left;
			}
			else {
				node = node.right;
			}
		}

		if (node == null) {
			return null;
		}

		if (node.right == null) {
			return tempSuccessor;
		}

		node = node.right;
		while (node.left != null) {
			node = node.left;
		}

		return node;
	}

	public T delete_findSucc(T key){
		if (tree.isEmpty()) { // can't delete from an empty tree
			throw new NoSuchElementException();
		}

		// find node containing key
		BinaryTree<T> deleteNode = recursiveSearch(tree, key);
		if (deleteNode == null) { // data not found, can't delete
			throw new NoSuchElementException();
		}
		BinaryTree<T> successorNode = findSuccessor(deleteNode);

		if (deleteNode.right.data.compareTo(successorNode.data) == 0) {
			// successor on right
			deleteNode.data = successorNode.data;
			deleteNode.left = successorNode.left;
			deleteNode.right = successorNode.right;
		}
		else {
			// successor on left
			deleteNode.data = successorNode.data;
			deleteNode.left = successorNode.left;
			deleteNode.right = successorNode.right;
		}

		return deleteNode.data;
	}

	public ArrayList<T> getPreorder() {
		ArrayList<T> result = new ArrayList<>();
		getPreorder(tree, result);
		return result;
	}

	private void getPreorder(BinaryTree<T> binaryTree, ArrayList<T> result) {
		if (binaryTree == null) {
			return;
		}
		result.add(binaryTree.getData());
		getPreorder(binaryTree.left, result);
		getPreorder(binaryTree.right, result);
	}

	public ArrayList<T> sort() {
		return getPreorder();
	}

	/**
	 * @param key1 max value
	 * @param key2 min value
     * @return arraylist of T in range
     */
	public ArrayList<T> between(T key1, T key2) {
		ArrayList<T> allElements = sort();
		return allElements.stream().filter(eachElement -> eachElement.compareTo(key2) <= 0 && eachElement.compareTo(key1) >= 0).collect(Collectors.toCollection(ArrayList::new));
	}
}
