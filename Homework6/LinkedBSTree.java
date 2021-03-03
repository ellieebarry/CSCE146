package Homework06;
/*
 * Created by Ellie Barry
 */

public class LinkedBSTree<T extends Comparable<T>> {

	
	private class Node implements Comparable<Object> {
		private T data;
		private Node rightChild;
		private Node leftChild;

		// Default Constructor for Node class
		public Node(T data) {
			this.data = data;
			this.leftChild = this.rightChild = null;
		}
		public int compareTo(Object obj) {
			return 0;
		}
	}

	// Where everything happens (in a binary search tree) and is the starting element
	private Node root;
	
	// Default constructor for LinkedBSTree class
	public LinkedBSTree() {
		root = null;
	}

	// Insert method that calls insert using the root and data
	public void insert(T aData) {
		if(root == null)
			root = new Node(aData);
		else
			insert(root, aData);
	}
	
	// Called by void insert method
	private Node insert(Node aNode, T aData) { // Recursive insert
		if(aNode == null) { // Found a leaf
			aNode = new Node(aData);
		} 
		else if(aData.compareTo(aNode.data) < 0 ) { // LESS go LEFT
			aNode.leftChild = insert(aNode.leftChild, aData);
		}
		else if(aData.compareTo(aNode.data)>=0) { // GREATER go RIGHT
			aNode.rightChild = insert(aNode.rightChild, aData);
		}
		return aNode;
	}

	// Uses root in order to delete the node and reset the root to the next node not deleted
	public void delete(T aData) {
		root = delete(root, aData);
	}
	
	// Called by void delete method
	private Node delete(Node aNode, T aData) {
		if(aNode == null)
			return null;
		if(aData.compareTo(aNode.data) < 0) // Go left
			aNode.leftChild = delete(aNode.leftChild, aData);
		else if(aData.compareTo(aNode.data) > 0)
			aNode.rightChild = delete(aNode.rightChild, aData);
		else {
			// If there are no children or only a left child
			if(aNode.rightChild == null) 
				return aNode.leftChild;
			// This is only right child
			if(aNode.leftChild == null) {
				return aNode.rightChild;
			}
			// Has two children
			// Finds the smallest value in the right subtree
			Node temp = findMin(aNode.rightChild);
			// Replace the value
			aNode.data = temp.data;
			// Delete the smallest node in the right subtree
			aNode.rightChild = delete(aNode.rightChild, temp.data);
		}
		return aNode;
	}

	// Goes through the BS Tree left side to find the smallest value
	private Node findMin(Node node) {
		if (node == null) 
			return null;
		if (node.leftChild == null)
			return node;
		else 
			return findMin(node.leftChild);
	}

	// Goes through the BS Tree right side to find the largest value
	public double getMaxArea() {
		Node node = root;
		while (node.rightChild != null) {
			node = node.rightChild;
		}
		return ((Shape) node.data).getArea();
	}

	// Deletes all nodes that have values greater than 30
	public void deleteValuesGreaterThan(double value) {
		// Starts at the root
		Node newNode = root;
		// Amount of nodes that still need to be checked
		int checkNode = 0;
		// While there is still a node
		while (newNode != null) {
			// Deletes the node if it is larger than 30 and then adds to count to re-check it later
			if (((Shape) newNode.data).getArea() > value) { 
				checkNode++; 
				delete(newNode.data);
			}
			newNode = newNode.rightChild;
		}
		// Goes through and re-checks all the nodes that were deleted
		for (int i = 0; i < checkNode; i++) {
			deleteValuesGreaterThan(value);
		}
	}
  
	// Calls the printInOrder method using the root
	public void printInOrder() {
		printInOrder(root);
	}

	// Calls the printPreOrder method using the root
	public void printPreOrder() {
		printPreOrder(root);
	}

	// Calls the printPostOrder method using the root
	public void printPostOrder() {
		printPostOrder(root);
	}

	// Called by void preOrder method
	private void printPreOrder(Node node) {
		if (node == null) 
			return;
		System.out.println(node.data); // Process
		printPreOrder(node.leftChild); // Recursive Left
		printPreOrder(node.rightChild); // Recursive Right
	}

	// Called by void postOrder method
	private void printPostOrder(Node node) {
		if (node == null) 
			return;
		printPostOrder(node.leftChild); // Recursive Left
		printPostOrder(node.rightChild); // Recursive Right
		System.out.println(node.data); // Process
	}

	// Called by void inOrder method
	private void printInOrder(Node node) {
		if (node == null) 
			return;
		printInOrder(node.leftChild); // Recursive Left
		System.out.println(node.data); // Process
		printInOrder(node.rightChild); // Recursive Right
	}
}