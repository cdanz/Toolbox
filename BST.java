/*
 * Craig Danz
 * CPSC 5003, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package danzc_p1;

import java.util.ArrayList;

/**
 * This is a generic class that implements a binary search tree. It has 
 * many functions to help explore and make use of a BST.
 * @author danzc
 *
 * @param <E>				Generic class. You are able to call various types.
 */
public class BST <E extends Comparable<E>>{
	private Node root;
	private static int count; //Used for various count methods. 
	private ArrayList<E> list = new ArrayList<E>(); //Used to create various lists.

	/*
	 * Nested Node class.
	 */
	public class Node {
		private E value;
		private Node left;
		private Node right;
		
		/**
		 * Single argument constructor of a node.
		 * @param val			Value to be stored only.
		 */
		public Node(E val) {
			value = val;
			left = null;
			right = null;
		}
		
		/**
		 * Node constructor where you can define its left and right pointers.
		 * @param val			Value to be stored
		 * @param l				Pointer to left node.
		 * @param r				Pointer to right node.
		 */
		public Node(E val, Node l, Node r) {
			value = val;
			left = l;
			right = r;
		}
	}
		
	/**
	 * Nested class that represents the result of a binary tree with
	 * a node removed. 
	 */
	private class RemovalResult {
		Node node;
		Node tree;
		
		/**
		 * Constructor for the RemovalResult class.
		 * @param node			Removed Node
		 * @param tree			Remaining tree.
		 */
		RemovalResult(Node node, Node tree) {
			this.node = node;
			this.tree = tree;
		}
	}
	
	/**
	 * Inserts a new value stored in its own node in the binary search tree.
	 * Single argument method calls an overloaded helper method to recursively
	 * find the new node's proper place.
	 * @param insertValue		Value you want to store.
	 * @return boolean			True if successfully inserted.
	 */
	public boolean insert(E insertValue) {
		root = insert(insertValue, root);
		return true;
	}
	/**
	 * Helper method to its sister single argument method. 
	 * @param insertValue		Value you wish to store.
	 * @param bstree				Remaining subtree to search for its spot
	 * @return bstree			Root of remaining tree
	 */
	private Node insert(E insertValue, Node bstree) {
		if (bstree == null) {
			return new Node(insertValue);
		}
		//bstree is not null.
		if (insertValue.compareTo(bstree.value) == 0)  {
			bstree.value = insertValue;
		}
		else if (insertValue.compareTo(bstree.value) < 0)  {
			bstree.left = insert(insertValue, bstree.left);
		}
		else {
			//Add x to the right subtree
			bstree.right = insert(insertValue, bstree.right);
		}
		return bstree;
		
	} 
	
	/**
	 * Checks to see if the tree is empty
	 * @return boolean 			True if you have an empty tree.
	 */
	public boolean empty() {
		return root == null;
	}
	
	/**
	 * This method searches the tree for a value. It uses its overloaded 
	 * sister method to recursively search various branches.
	 * @param searchValue			Target value to find. 
	 * @return boolean				If matching value is found: true. 
	 */
	public boolean contains(E searchValue) {
		return contains(searchValue, root);
	}
	
	/**
	 * Helper method to sister method. Recursively searches down various 
	 * subtrees until the value is found or it reaches a leaf.
	 * @param searchValue			Target value.
	 * @param bstree					Subtree to search down.
	 * @return boolean				True if matching value found.
	 */
	private boolean contains(E searchValue, Node bstree) {
		if (bstree == null) {
			return false;
		}
		if (searchValue.compareTo(bstree.value) == 0) {
			return true;
		}
		if (searchValue.compareTo(bstree.value) < 0) {
			//Recursively look in left subtree.
			return contains(searchValue, bstree.left);
		}
		else {
			//Recursively look right.
			return contains(searchValue, bstree.right);
		}
	}
	
	/**
	 * Removes a value from the binary search tree. Calls sister function 
	 * to recursively search the tree.
	 * @param removeValue			Target value to find and remove
	 * @return boolean				If target is successfully removed.
	 */
	public boolean remove(E removeValue) {
		RemovalResult result = remove(root, removeValue);
		if (result == null) {
			return false;
		}
		else {
			root = result.tree;
			return true;
		}
	}
	
	/**
	 * Sister function that recursively searches a tree. 
	 * @param bTree				Remaining subtree to go down.
	 * @param removeValue		Target value to remove.
	 * @return result			Custom type RemovalResult
	 */
	private RemovalResult remove(Node bTree, E removeValue) {
		if (bTree == null) {
			return null;
		}
		if (removeValue.compareTo(bTree.value) < 0) {
			//Remove x from left subtree
			RemovalResult result = remove(bTree.left, removeValue);
			if (result == null) {
				return null;
			}
			bTree.left = result.tree;
			result.tree = bTree;
			return result;
		}
		if (removeValue.compareTo(bTree.value) > 0) {
			//Remove X from the right
			RemovalResult result = remove(bTree.right, removeValue);
			if (result == null) {
				return null;
			}
			bTree.right = result.tree;
			result.tree = bTree;
			return result;
		}
		//x is in this root node.
		//Is it a leaf?
		if (bTree.right == null && bTree.left == null) {
			return new RemovalResult(bTree, null);
		}
		
		//Does the node have two children?
		if (bTree.right != null && bTree.left !=null) {
			//Remove largest node in left subtree and make
			//it the root of the remaining tree.
			RemovalResult remResult = removeLargest(bTree.left);
			Node newRoot = remResult.node;
			newRoot.left = remResult.tree;
			newRoot.right = bTree.right;
			
			//Prepare the result to be returned.
			bTree.left = null;
			bTree.right = null;
			return new RemovalResult(bTree, newRoot);
		}
		//The node has one child
		Node node = bTree;
		Node tree;
		if (bTree.left != null) {
			tree = bTree.left;
		}
		else {
			tree = bTree.right;
		}
		node.left = null;
		node.right = null;
		return new RemovalResult(node, tree);
	}
	
	/**
	 * Finds the largest remaining node to replace the removed node with.
	 * @param bTree				Current Node on the rightward traversal. 
	 * @return new RemovalResult	The node that is the largest, wrapped in
	 * 							custom type RemovalResult
	 */
	private RemovalResult removeLargest(Node bTree) {
		if (bTree == null) {
			return null;
		}
		if (bTree.right == null) {
			//root is the largest node
			Node tree = bTree.left;
			bTree.left = null;
			return new RemovalResult(bTree, tree);
		}
		else {
			//Remove the largest node from the right subtree.
			RemovalResult remResult = removeLargest(bTree.right);
			bTree.right = remResult.tree;
			remResult.tree = bTree;
			return remResult;
		}
	}
	
	/**
	 * Finds the total number of values being stored in a tree. 
	 * @return count				The number of values in the tree.
	 */
	public int size() {
		count = 0;
		Node tree = root;
		size(tree);
		return count;
	}
	
	/**
	 * Helper function for size() that traverses the tree inorder and counts
	 * the nodes
	 * @param tree				subtree to visit
	 */
	public void size(Node tree) {
		if (tree != null) {
			size(tree.left);
			count++;
			size(tree.right);
		}
	}
	
	/**
	 * Find the number of leaves in the a tree.
	 * @return count			Integer representing count of leaves
	 */
	public int getLeafNodeCount() {
		count = 0;
		Node tree = root;
		getLeafNodeCount(tree);
		return count;
	}
	
	/**
	 * Helper method to traverse tree inorder and find leaves.
	 * @param tree			Subtree to continue to traverse.
	 */
	public void getLeafNodeCount(Node tree) {
		if (tree != null) {
			getLeafNodeCount(tree.left);
			if (tree.left == null && tree.right == null)
				count++;
			getLeafNodeCount(tree.right);
		}
	}
	
	/**
	 * Find the number of levels in a binary search tree.
	 * @return count			Number of levels.
	 */
	public int getTreeHeight() {
		count = 0;
		Node tree = root;
		getTreeHeight(tree);
		return count;
	}
	
	/**
	 * Helper function that recursively traverses the tree to the 
	 * leftmost leave to find its number of levels. 
	 * @param tree				Remaining subtree to traverse.
	 */
	public void getTreeHeight(Node tree) {
		if (tree != null) {
			getTreeHeight(tree.left);
			count++;
		}
	}
	
	/**
	 * Find the level where the target search element is found.
	 * @param target				Search term to look for.
	 * @return	count			Integer number of level where term is 
	 * 							found or -1 if not found. 
	 */
	public int getElementLevel(E target) {
		count = 0;
		Node tree = root;
		getElementLevel(target, tree);
		return count;
	}
	
	/**
	 * Helper method to recursively traverse the tree for the search term
	 * @param target				Search term
	 * @param bstree				Remaining subtree to search
	 */
	private void getElementLevel(E target, Node bstree) {
		if (bstree == null) {
			count = -1;
		}
		else if (target.compareTo(bstree.value) == 0) {
			count++;
		}
		else if (target.compareTo(bstree.value) < 0) {
			count++;
			getElementLevel(target, bstree.left);
		}
		else {
			count++;
			getElementLevel(target, bstree.right);
		}
	}
	
	/**
	 * Creates a list of every ancestor value of a given search term.
	 * @param target					Search value
	 * @return list					An Arraylist of all the found search
	 * 								term's ancestors. Empty if term is not
	 * 								found.
	 */
	public ArrayList<E> getAncestorsOf(E val) {
		list.clear();
		Node tree = root;
		getAncestorsOf(val, tree);
		return list;
	}
	
	/**
	 * Helper function to recursively traverse a tree, adding ancestors to a 
	 * list along the way.
	 * @param target					Target search term.
	 * @param bstree					Remaining subtree to search.
	 */
	private void getAncestorsOf(E target, Node bstree) {
		if (bstree == null) {
			list.clear(); //if a null is reached then the term is not in the
							//tree, clear the non-ancestors out of the list.
		}
		else if (target.compareTo(bstree.value) == 0) {
			list.add(0,bstree.value);
		}
		else if (target.compareTo(bstree.value) < 0) {
			list.add(0,bstree.value);
			getAncestorsOf(target, bstree.left);
		}
		else {
			list.add(0,bstree.value);
			getAncestorsOf(target, bstree.right);
		}
	}
	
	/**
	 * Traverse the tree using preorder (CLR) traversal and loads an ArrayList
	 * with all values in the tree.
	 * return list				ArrayList of all values. 
	 */
	public ArrayList<E> getPreOrderTraversal() {
		list.clear();
		Node tree = root;
		getPreOrderTraversal(tree);
		return list;
	}
	
	/**
	 * Helper method that recursively traverses the tree using preorder
	 * traversal.
	 * @param tree				Remaining subtree to visit.
	 */
	public void getPreOrderTraversal(Node tree) {
		if (tree != null) {
			list.add(tree.value);
			getPreOrderTraversal(tree.left);
			getPreOrderTraversal(tree.right);
		}
	}
	
	/**
	 * Traverse the tree using inorder (LCR) traversal and loads an ArrayList
	 * with all values in the tree.
	 * return list				ArrayList of all values. 
	 */
	public ArrayList<E> getInOrderTraversal() {
		list.clear();
		Node tree = root;
		getInOrderTraversal(tree);
		return list;
	}
	
	/**
	 * Helper method that recursively traverses the tree using inorder
	 * traversal.
	 * @param tree				Remaining subtree to visit.
	 */
	public void getInOrderTraversal(Node tree) {
		if (tree != null) {
			getInOrderTraversal(tree.left);
			list.add(tree.value);
			getInOrderTraversal(tree.right);
		}
	}
	
	/**
	 * Traverse the tree using postorder (LRC) traversal and loads an 
	 * ArrayList with all values in the tree.
	 * return list				ArrayList of all values. 
	 */
	public ArrayList<E> getPostOrderTraversal() {
		list.clear();
		Node tree = root;
		getPostOrderTraversal(tree);
		return list;
	}
	
	/**
	 * Helper method that recursively traverses the tree using postorder
	 * traversal.
	 * @param tree				Remaining subtree to visit.
	 */
	public void getPostOrderTraversal(Node tree) {
		if (tree != null) {
			getPostOrderTraversal(tree.left);
			getPostOrderTraversal(tree.right);
			list.add(tree.value);
		}
	}
}
