/**
 * Node That points at it's root and contains a key
 * @author Joshua Moore
 *
 */
public class UpTreeNode {
	private int key; //size of tree below or index where the node points to
	private Vertex data; 
	
	/**
	 * default constructor, makes a disjoint size 1 node
	 * @param vertex the vertex data to put in the node
	 */
	public UpTreeNode(Vertex vertex) {
		key = -1;
		data = vertex;
	}
	
	/**
	 * @return the size of the tree (if negative) or the index where the node points
	 */
	public int getKey() {
		return key;
	}
	
	/**
	 * @return the Vertex in the node
	 */
	public Vertex getVertex(){
		return data;
	}
	
	/**
	 * Set the key to @param key the new key
	 */
	public void setKey(int key) {
		this.key = key;
	}
}
