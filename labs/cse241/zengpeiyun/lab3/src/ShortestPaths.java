package lab3;
import java.util.ArrayList;
/**
 * Compute shortest paths in a graph.
 *
 * Your constructor should compute the actual shortest paths and
 * maintain all the information needed to reconstruct them.  The
 * returnPath() function should use this information to return the
 * appropriate path of edge ID's from the start to the given end.
 *
 * Note that the start and end ID's should be mapped to vertices using
 * the graph's get() function.
 */
class ShortestPaths {
    
    /**
     * Constructor
     */
	int Inf=(int) java.lang.Double.POSITIVE_INFINITY;
	ArrayList<Node> vlist = new ArrayList<Node>();
	PriorityQueue<Node> q = new PriorityQueue<Node>();
	
    public ShortestPaths(Multigraph G, int startId) {
       // YOUR CODE HERE
    	initialization(q,G,startId);
    	while (q.isEmpty() == false){
    		Node u = q.extractMin();
    		if (u.dist != Inf){
    		Vertex.EdgeIterator adjacent = u.vertex.adj();
    		//This is the relax step for each vertex in adjacent, followed text 
    		while (adjacent.hasNext()==true ){
    			Edge e = adjacent.next();
    			Node v = vlist.get(e.to().id());
    			relax(v,u,e);       
    		}
    		}
    		}
    	}
    public void initialization(PriorityQueue<Node> queue,Multigraph G, int startId){
    	for (int i = 0; i< G.nVertices(); i++){
    		Vertex v = G.get(i);
    		Node vNode = new Node();
    		vlist.add(vNode);
    	}
    	for (int i = 0; i< G.nVertices(); i++){
    		Vertex v = G.get(i);
    		if (v.id() == startId){
    			Node vNode = new Node(v);
    			vNode.dist = 0;
    			vNode.handle = queue.insert(0, vNode);
    			int id = v.id();
    			vlist.set(id, vNode);
    		}
    		else {
    			Node vNode = new Node(v);
        		vNode.handle = queue.insert(Inf, vNode);
        		int id = v.id();
        		vlist.set(id, vNode);
        		
    		}
    	}
    }
    public void relax(Node v, Node u,Edge e){
    	//If v has not been extracted, which means it has not been visited.
    
    	if ((v.handle.index != -1) && q.decreaseKey(v.handle, u.dist + e.weight()) ){
    		v.dist = u.dist+ e.weight();
			v.edgetohere = e.id();
			v.pred = u;
    	}
    	//if v has been visited;
    	else if ((v.handle.index == -1) && ( (u.dist + e.weight())< v.dist) ){
    		v.dist = u.dist+ e.weight();
			v.edgetohere = e.id();
			v.pred = u;
    	}
    	
    }
    /**
     * Calculates the list of edge ID's forming a shortest path from the start
     * vertex to the specified end vertex.
     *
     * @return the array
     */
    public int[] returnPath(int endId) { 
       // YOUR CODE HERE
    	Node endVertex = vlist.get(endId);
    	int i = 0;
    	ArrayList<Integer> idlist = new ArrayList<Integer>();
    	while (endVertex.pred != null){
    		idlist.add(endVertex.edgetohere);  
    		endVertex = endVertex.pred;
    		i++;
    	}
    	int path[] = new int[i];
    	for (int j = i; j> 0; j--){
    		path[j-1] = idlist.get(i-j);
    	}
    	return path;
    }
    
    public class Node{
    	public Handle handle;
    	public Vertex vertex;
    	public int dist;
    	public int edgetohere;
    	public Node pred;
    	public Node(){}
    	public Node(Vertex v){
    		pred = null;
    		dist = (int) java.lang.Double.POSITIVE_INFINITY;
    		vertex = v;
    	}
    }
}


