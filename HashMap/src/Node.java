/**
 * Node that hold a generic type of data and a pointer to the next node
 * 
 * @author Joshua Moore
 * @version 5/8/14
 */
public class Node<T> {
	
	/** Data of generic type T held in this node */
	public T data;
	
	/** A pointer to the next node in the sequence */
	public Node<T> next;
	
	/** the has code for the key */
	public int hashCode;
	
	/**
	 * Initiaizes Node with data and a a next Node
	 * @param data the data to store in the node
	 * @param next the Next node
	 * @param hashCode the hashCode for the key of the data
	 */
	public Node(final T data, final Node<T> next, final int hashCode) {
		this.data = data;
		this.next = next;
		this.hashCode = hashCode;
	}
	
	/**
	 * alt constructor for when there is no next;
	 * @param data the data to store in the node
	 * @param hashCode the hashCode for the key of the data
	 */
	public Node(final T data, final int hashCode) {
		this(data, null, hashCode);
	}
	
	/**
	 * Initializes a null node 
	 */
	public Node() {
		this(null, null, -1);
	}
}
