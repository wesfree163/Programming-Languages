/*
 * Representation of a directed graph edge.
 */
public class Edge
{
	private final Vertex from, to;

	/*
	 * Construct a new edge
	 * @param from start vertex
	 * @param to end vertex
	 */
	public Edge(Vertex from, Vertex to)
   {
		if(from == null || to == null)
			throw new IllegalArgumentException("null");
		this.from = from;
		this.to = to;
	}

   /*
	 * Get the source vertex
	 * @return the Vertex that is the source of the edge
	 */
	public Vertex getSource()
   {
		return from;
	}

   /*
	 * Get the destination vertex
	 * @return the Vertex that is the destination of the edge
	 */
	public Vertex getDestination()
   {
		return to;
	}

	/*
	 * A string representation of this object
	 * @return A string of the form <from, to, weight>
	 */
	public String toString()
   {
		return "<" + from + ", " + to + ">";
	}

 	//auto-generated: hashes on all fields
	public int hashCode()
   {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		return result;
	}

	//auto-generated: compares all fields
	public boolean equals(Object obj)
   {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Edge other = (Edge) obj;
		if (from == null)
      {
			if (other.from != null)
				return false;
		}
      else if (!from.equals(other.from))
			return false;
		if (to == null)
      {
			if (other.to != null)
				return false;
		}
      else if (!to.equals(other.to))
			return false;
      return false;
   }
}    
