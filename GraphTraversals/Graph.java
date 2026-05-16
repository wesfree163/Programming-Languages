import java.util.Collection;

/*
 * Graph Traversals
 */
public interface Graph {

  /*
   * Return a collection containing the vertices of this graph
   * @return the vertices as a collection (which is anything iterable)
   */
  public Collection<Vertex> vertices();

  /*
   * Return a collection containing the edges of this graph
   * @return the edges as a collection (which is anything iterable)
   */
  public Collection<Edge> edges();

  /*
   * Return a collection of vertices adjacent to a given vertex v.
   *   i.e., the set of all vertices w where edges v -> w exist in the graph.
   * Return an empty collection if there are no adjacent vertices.
   * @param v one of the vertices in the graph
   * @return an iterable collection of vertices adjacent to v in the graph
   * @throws IllegalArgumentException if v does not exist.
   */
  public Collection<Vertex> adjacentVertices(Vertex v);
}
