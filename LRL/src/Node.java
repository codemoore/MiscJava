/*
 * Joshua Moore
 * Chris Fahlin
 * TCSS342A Spring 14
 */
/**
 * Node for an LRLTree, holds data, a left node, and a right node
 * 
 * @author Joshua Moore
 * @author Chris Fahlin
 * @version 4/29/14
 */
public class Node {

	/** Holds the operand or number for this node */
	public String data; 

	/** The left child of this node */
	public Node left;

	/** The right child of this node */
	public Node right;
	
	/**
	 * Initialize a new node with null children and a data value
	 * @param data this node's data value
	 */
	public Node (final String data) {
		this.data = data;
		left = null;
		right = null;
	}

	/**
	 * Initialize a new Node with all null fields
	 */
	public Node () {
		this(null);
	}


}
