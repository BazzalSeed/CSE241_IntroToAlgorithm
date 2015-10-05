package lab3;

import java.util.*;

/**
 * Vertex class for the multigraph
 *
 * A Vertex is created with an integer identifier.
 * Subclass it if you want to store more complex info.
 *
 * To enumerate a vertex's adjacency list, you call its adj()
 * method, which returns an iterator "ei" of type EdgeIterator for 
 * the list. You can call ei.hasNext() to see if there is another
 * edge available, and ei.next() to get it.
 */
public class Vertex {
    private int id;
    private ArrayList<Edge> neighbors;

    /**
     * Consructor
     */
    public Vertex(int id) { 
       this.id = id;
       neighbors = new ArrayList<Edge>();
    }

    /**
     * @return id
     */
    public int id() {
        return id;
    }

    /**
     * @return an iterator to list all of our edges.
     */
    public EdgeIterator adj() {
       EdgeIterator edgeIterator = new EdgeIterator(this);
       return edgeIterator;
    }

    /**
     * Add an edge to our adjacency list.
     */
    public void addEdge(Edge e) {
       neighbors.add(e);
    }

    /**
     * @return String representation (id)
     */
    public String toString() {
        return "" + id;
    }
    
    public class EdgeIterator {
        private Vertex v;
        private int position;

        /**
         * Constructor
         */
        public EdgeIterator(Vertex v) {
            this.v = v;
            position = 0;
        }

        /**
         * @return boolean whether we have another Edge.
         */
        public boolean hasNext() {
            return (position < v.neighbors.size());
        }

        /**
         * @return the next Edge.
         */
        public Edge next() {
            return v.neighbors.get(position++); 
        }
    }
}
