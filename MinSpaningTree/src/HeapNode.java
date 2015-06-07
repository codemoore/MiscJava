/**
 * Comparable node made for edges to put into a heap
 * @author Joshua Moore
 *
 */
public class HeapNode implements Comparable<HeapNode> {
	
	private Edge e;
	
	/**
	 * Creates a new heap node with an edge @param e the input edge
	 */
	public HeapNode (Edge e) {
		this.e = e;
 	}
	
	
	/**
	 * Compares the edge data to this object
	 * assumes that it can be cast to an Integer
	 * @n the edge to compare e.data to
	 */
	@Override
	public int compareTo(HeapNode n) {
		return (int)((Double)(this.e.getData()) - (Double)(n.getEdge().getData()));
	}
	
	/**
	 * @return the edge in this node
	 */
	public Edge getEdge() {
		return e;
	}

}
