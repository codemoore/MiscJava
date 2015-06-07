import java.util.ArrayList;

/**
 * Data structure for a collection of disjoint sets, includes operations for unions and finds
 * @author Joshua Moore
 *
 */
public class DisjointSets {
	
	private ArrayList<UpTreeNode> sets;
	

	/**
	 * Populates the disjoint set with nodes
	 * @param vertices create a node for each vertex
	 */
	public DisjointSets(Object[] vertices) {
		sets = new ArrayList<UpTreeNode>(vertices.length);
		for(Object o: vertices) {
			sets.add(new UpTreeNode((Vertex)o));
		}
	}
	
	/**
	 * returns the index of  @param v 's set index
	 */
	public int find(Vertex v) {
		int index = -1;
		// walk though the set to find the right vertex (n)
		for (int i = 0; i < sets.size(); i++) {
			UpTreeNode n = sets.get(i);
			//and call find on the index of this vertex (log n)
			if(n.getVertex().getName().equals(v.getName())){
				return find(i);
			}
		}
		return index;
	}
	
	/**
	 * @return the index of the set that index @param i belongs to
	 * if i < 0 return -1
	 */
	public int find(int i) {
		if( i < 0) return -1;
		int index = i;
		int temp = sets.get(i).getKey();
		// got through the uptree until you reach a root
		while (temp > -1) {
			index = sets.get(index).getKey();
			temp = sets.get(index).getKey();
		}
		return index;
	}
	
	/**
	 * Combines 2 root sets based on size
	 * @param i index of the first disjoint set
	 * @param j index of the second disjoint set
	 */
	public void union (int i, int j) {
		//find on i and j
		int iRoot = find(i);
		int jRoot = find(j);
		//add the smaller of the two to the bigger set
		if(sets.get(iRoot).getKey() <= sets.get(jRoot).getKey()) {
			sets.get(j).setKey(iRoot);
		} else {
			sets.get(i).setKey(jRoot);
		}
	}
}
