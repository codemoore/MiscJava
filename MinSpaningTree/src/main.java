import java.util.Hashtable;
import java.util.Set;

/**
 * contains the main method and starts the console application
 * Fines min spanning tree edge set for a graph from the input file
 * @author Joshua Moore

 *
 */
public class main {

	public static void main(String[] args) throws EmptyHeapException {
		SimpleGraph g = new SimpleGraph();
		Hashtable<String, Vertex> vertexTable = GraphInput.LoadSimpleGraph(g);
		MinSpanningTree min = new MinSpanningTree(g, vertexTable);
		Set<Edge> minSet = min.getMinTreeSet();
		System.out.println("Minumum Spanning Tree Edge Set: {");
		for(Edge e : minSet) {
			System.out.println("("+e.getFirstEndpoint().getName()+
					", "+e.getSecondEndpoint().getName()+", "+e.getData().toString()+")");
		}
		System.out.print("}");
		System.out.println("\nCost: " + min.getCost());
	}

}
