package lab3;

/**
 * Edge class for the multigraph
 *
 * A (directed) edge contains four values: a unique identifier, a
 * "from" vertex, a "to" vertex, and an integer weight.  Subclass Edge 
 * if you want to store more complicated info.
 */
public class Edge {
     private int id, weight;
     private Vertex from, to;

     /**
      * Constructs an Edge with the given id, weight, and from and to.
      *
      * @param id of the edge
      * @param from Vertex this edge goes from
      * @param to Vertex this edge goes to
      * @param weight of this edge
      */
     public Edge(int id, Vertex from, Vertex to, int weight) {
          this.id = id;
          this.from = from;
          this.to = to;
          this.weight = weight;
     }

     /**
      * Returns the id of the edge
      *
      * @return id
      */
     public int id() {
          return id;
     }

     /**
      * Returns the from Vertex
      *
      * @return from
      */
     public Vertex from() {
          return from;
     }

     /**
      * Returns the to Vertex
      *
      * @return to
      */
     public Vertex to() {
          return to;
     }

     /**
      * Returns the weight of the edge
      *
      * @return weight
      */
     public int weight() {
          return weight;
     }

     /**
      * Converts the edge to a string with 
      *
      * @return String version of the edge
      */
     public String toString() {
          return "id:" + id + ", " + from + " --> " + to + ", weight: "
               + weight;
     }
}
