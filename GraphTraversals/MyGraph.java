/*
 * This class implements the graph representation by implementing the graph interface.
 */
import java.util.*;

/*
 * A representation of a graph.
 * Assumes that we do not have negative cost edges in the graph.
 */
public class MyGraph implements Graph
{
	private int size; //saves the number of vertices
	private Set<Vertex> vertices;  // saves the vertices passed in
	private Set<Edge> edges;  // saves the edges passed in
	private Map<Vertex, Integer> vertexIndex; //assign each vertex with index, able to locate
	private Map<VertexTuple, Edge> edgesMap; //stores edges, able to find edge by key vertexTuple
	private ArrayList<LinkedList<Vertex>> adjacencyList;  //stores the graph

	/*
	 * Creates a MyGraph object with the given collection of vertices
	 * and the given collection of edges.
	 * @param v a collection of the vertices in this graph
	 * @param e a collection of the edges in this graph
	 */
	public MyGraph(Collection<Vertex> vs, Collection<Edge> es)
   {
		// set up, assign all global variables
		// i.e HashSet to avoid duplicates
		size = vs.size();
		vertices = new HashSet<Vertex>();
		edges = new HashSet<Edge>();
		vertexIndex = new HashMap<Vertex, Integer>();
		edgesMap = new HashMap<VertexTuple, Edge>();
		adjacencyList = new ArrayList<LinkedList<Vertex>>();
		int i = 0;

		// adds each vertex in vs into vertices and updates the corresponding data
		for (Vertex v : vs)
      {
			vertices.add(v);
			vertexIndex.put(v, i);
			adjacencyList.add(new LinkedList<Vertex>());
			i++;
		}

		// adds each edge in es into edgeMap and updates the corresponding data
		for (Edge e : es)
      {
			Vertex from = e.getSource();
			Vertex to = e.getDestination();
			VertexTuple vt = new VertexTuple(from, to);
			//if(edgesMap.containsKey(vt) && edgesMap.get(vt).getWeight()!=e.getWeight())
				//throw new IllegalArgumentException("duplicate edges with different weight!");
			int fromIndex = vertexIndex.get(from);
			adjacencyList.get(fromIndex).add(to); //goes to the vertex from bucket, add to
			edgesMap.put(new VertexTuple(from, to), e);
			edges.add(e);
		}
	}

	/*
	 * Return the collection of vertices of this graph
	 * @return the vertices as a collection (which is anything iterable)
	 */
	public Collection<Vertex> vertices()
   {
		Set<Vertex> result = new HashSet<Vertex>();
		for(Vertex v: vertices)
			result.add(v);
		return result;
	}


	/*
	 * Return the collection of edges of this graph
	 * @return the edges as a collection (which is anything iterable)
	 */
	public Collection<Edge> edges()
   {
		Set<Edge> result = new HashSet<Edge>();
		for(Edge e: edges) //copies out
			result.add(e);
		return result;
	}

	/*
	 * Return a collection of vertices adjacent to a given vertex v.
	 *   i.e., the set of all vertices w where edges v -> w exist in the graph.
	 * Return an empty collection if there are no adjacent vertices.
	 * @param v one of the vertices in the graph
	 * @return an iterable collection of vertices adjacent to v in the graph
	 * @throws IllegalArgumentException if v does not exist.
	 */
	public Collection<Vertex> adjacentVertices(Vertex v)
   {
		checkExceptions(v);
		Set<Vertex> s = new HashSet<Vertex>(); //copies out
		for(Vertex temp: adjacencyList.get(vertexIndex.get(v)))
			s.add(temp);
		return s;
	}

   /*
    * Breadth-First Search
    */
    /* procedure Breadth-First Search (G, v) :
     let Q be a queue
     Q.enqueue(v)
     label v as discovered
     list v
     while Q is not empty
          v = Q.dequeue( )
          for all edges from v to w in G.adjacentEdges(v) do
               if w is not labeled as discovered :
                    Q.enqueue(w)
                    label w as discovered
                    list w
 */
   public void BreadthFirstSearch(Vertex start)
   {
      HashSet<Vertex> discovered = new HashSet<Vertex>();
      Queue<Vertex> queue = new ArrayDeque<Vertex>();

      queue.add(start);
      discovered.add(start);
      //label v as discovered?:??????????
      //list v???????????????

      while(!queue.isEmpty()){
        start = queue.poll();
        for(Vertex nodes:adjacentVertices(start)){
          if(!discovered.contains(nodes)){
            queue.add(nodes);
            discovered.add(nodes);
            System.out.print(nodes+"\t");
          }
        }
      }
   }

   /*
    * Depth-First Search
    */
    /* procedure Depth-First Search iterative(G, v):
     let S be a stack
     S.push(v)
          while S is not empty
               v = S.pop()
               if v is not labeled as discovered :
                    label v as discovered
                    list v
                    for all edges from v to w in G.adjacentEdges(v) do
                         S.push(w)
 */
   public void DepthFirstSearch(Vertex start)
   {
      HashSet<Vertex> discovered = new HashSet<Vertex>();
      Stack<Vertex> stack = new Stack<Vertex>();

      stack.push(start);

      while(!stack.isEmpty()){
        start = stack.pop();
        if(!discovered.contains(start)){
          discovered.add(start);
          System.out.print(start+"\t");
          for(Vertex edges:adjacentVertices(start)){
            stack.push(edges);
          }
        }
      }
   }

	// helper method, checks if parameter vertex a and b are vertices exist in the graph
	private void checkExceptions(Vertex a)
   {
		if((!vertices.contains(a)))
			throw new IllegalArgumentException("vertex passed in does not exist!");
	}

	// Implementation of vertexTuple so we can construct vertexTuple, get hash code, and compare
	private class VertexTuple
   {
		private final Vertex from; //stores the starting vertex
		private final Vertex to; //stores the destination vertex

		//constructor
		public VertexTuple(Vertex from, Vertex to)
      {
			this.from = from;
			this.to = to;
		}

		//auto-generated: hashes on from and to
		public int hashCode()
      {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((from == null) ? 0 : from.hashCode());
			result = prime * result + ((to == null) ? 0 : to.hashCode());
			return result;
		}

		// makes it comparable by comparing from and to vertices
		public boolean equals(Object obj)
      {
			if (this == obj) //if equal
				return true;
			if (obj == null) //if obj passed in null
				return false;
			if (getClass() != obj.getClass()) //compares the runtime class of the object
				return false;
			final VertexTuple other = (VertexTuple) obj;

			if (from == null)
         {
				if (other.from != null)
					return false;  //from: a.null b.not null
			}
         else if (!from.equals(other.from))
         {
				return false; //from are different
			}
			if (to == null) //two from are same here
				return other.to == null; //if both to null
			else
				return to.equals(other.to); //if two to are the same
		}
   }
}
