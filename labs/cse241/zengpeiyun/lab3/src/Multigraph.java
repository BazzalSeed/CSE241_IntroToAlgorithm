package lab3;

import java.util.*;

/**
 * A Multigraph contains a collection of Vertex objects, each of which
 * maintains its own adjacency list of edges (see the Vertex and Edge 
 * classes).
 *
 * To enumerate the vertices in the Multigraph, you can simply ask for
 * the number of vertices n, then call get() successively on 0 .. n-1.
 */
public class Multigraph {
    private ArrayList<Vertex> vertices;

    /**
     * Constructor
     */
    public Multigraph() {
       vertices = new ArrayList<Vertex>();
    }
    
    
    /**
     * @return number of vertices in graph.
     */ 
    public int nVertices() {
       return vertices.size();
    }
    
    
    /**
     * @return a specified vertex
     */
    public Vertex get(int id) {
       return vertices.get(id);
    }
        
    /**
     * Add a vertex to the graph.
     */
    public void addVertex(Vertex v) {
       vertices.add(v);
    }
}
