import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;


/**
 * Takes a graph and finds a minimum spanning tree for it using Kruskal's algorithm
 * @author Joshua Moore
 */
public class MinSpanningTree {
	
	private SimpleGraph g;
	private Set<Edge> minTreeSet;
	private Double cost;
	private BinaryHeap heap;
	private DisjointSets disjoint;
	Hashtable<String, Vertex> vertexPairs;
	
	/**
	 * 
	 * @param g a simple Graph to find a min tree for
	 * @param vertexPairs String Vertex pair set for vertices in g
	 * @throws EmptyHeapException 
	 */
	public MinSpanningTree(SimpleGraph g, Hashtable<String, Vertex> vertexPairs) throws EmptyHeapException {
		this.g= g;
		minTreeSet = new HashSet<Edge>();
		cost = 0.0; 
		heap = new BinaryHeap(g.edgeList.size());
		//insert all Edges into heap in Heap Nodes
		for (Object O : g.edgeList) {
			heap.insert(new HeapNode((Edge)O));
		}
		disjoint = new DisjointSets(g.vertexList.toArray());
		this.vertexPairs = vertexPairs;
		//after the setup use krukals to produce a minspanning tree
		kruskal();
	}
	
	/**
	 * performs kruskal's algorithm to get a min spanning tree
	 * @throws EmptyHeapException 
	 */
	private void kruskal() throws EmptyHeapException {
		int accepted = 0;
		//while their are more edges to be accepted
		while(accepted < vertexPairs.size() - 1){
			//get min out of heap
			Edge min = ((HeapNode)(heap.deleteMin())).getEdge();
			//get both vertice in the edge
			Vertex v1 = min.getFirstEndpoint();
			Vertex v2 = min.getSecondEndpoint();
			//find on the vertices to get their sets
			int set1 = disjoint.find(v1);
			int set2 = disjoint.find(v2);
			//if they aren't in the same set add the edge, union v1 and v2 and increment accepted and cost 
			if (set1 != set2) {
				accepted++;
				disjoint.union(set1 , set2);
				minTreeSet.add(min);
				cost += (Double)min.getData();
			}
		}
	}
	
	/**
	 * @return the set of edges that make up the min spanning tree
	 */
	public Set<Edge> getMinTreeSet() {
		return minTreeSet;
	}
	
	/**
	 * @return the total cost of the edges in the min spanning tree
	 */
	public double getCost(){
		return cost;
	}
}
