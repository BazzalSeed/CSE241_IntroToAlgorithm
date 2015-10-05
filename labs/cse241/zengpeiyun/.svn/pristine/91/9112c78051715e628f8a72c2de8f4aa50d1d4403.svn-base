package lab3;
import java.util.ArrayList;

/**
 * A priority queue class supporting operations needed for
 * Dijkstra's algorithm.
 */
class PriorityQueue<T> {
	
     ArrayList<Handle<T>> q = new ArrayList<Handle<T>>();
    /**
     * Constructor
     */
    public PriorityQueue() {
    }

    /**
     * @return true iff the queue is empty.
     */
    public boolean isEmpty() {
       return q.size() == 0.;
    }

    /**
     * Insert a (key, value) pair into the queue.
     *
     * @return a Handle to this pair so that we can find it later.
     */
    Handle<T> insert(int key, T value) {
    	int infinity = (int)java.lang.Double.POSITIVE_INFINITY ;
    	Handle<T> a1 = new Handle<T>(infinity, value);
    	q.add(a1);
    	int p = q.size()-1;
    	q.get(p).setIndex(p);
    	decreaseKey(q.get(q.size()-1), key);
    	int j = 0;
    	for (j=0;j<q.size();j++){
    		if(q.get(j).node.value == value && q.get(j).node.key == key){
    			break;
    		}
    	}
       return q.get(j);
    }

    /**
     * @return the min key in the queue.
     */
    public int min() {
       return q.get(0).node.key;
    }

    /**
     * Find and remove the smallest (key, value) pair in the queue.
     *
     * @return the value associated with the smallest key
     */
    public void Heapify(ArrayList<Handle<T>> q, int i){
    	int left = 2*(i) + 1;
    	int right= 2*(i) + 2;
    	int min;
    	if (left<q.size() && q.get(left).node.key<q.get(i).node.key){
    	  min = left;	
    	}
    	else{
    		min = i;
    	}
    	if (right<q.size() && q.get(right).node.key<q.get(min).node.key){
      	  min = right;	
      	}
      	if (min != i){
      		keyswap(i, min);
      		Heapify(q,min);
      	}
    	
    }
    public T extractMin() {
    	if (q.size()<1){
    		System.exit(1);
    	}
    	T minV = q.get(0).node.value;
    	keyswap(0,q.size()-1);
    	q.get(0).setIndex(0);
    	q.get(q.size()-1).setIndex(-1);
    	q.remove(q.size()-1);
    	Heapify(q,0);    	
       return minV;
    }

    void keyswap(int a, int b){
    	Handle<T> ta = q.get(a);
    	Handle<T> tb = q.get(b);
    	q.set(a, tb);
    	q.set(b, ta);
    	q.get(a).setIndex(a);
    	q.get(b).setIndex(b);
    }
    
    

    /**
     * Decrease the key to the newKey associated with the Handle.
     *
     * If the pair is no longer in the queue, or if its key <= newKey,
     * do nothing and return false.  Otherwise, replace the key with newkey,
     * fix the ordering of the queue, and return true.
     *
     * @return true if we decreased the key, false otherwise.
     */
    public boolean decreaseKey(Handle<T> h, int newKey) {
    	if(newKey > q.get(h.index).node.key){
    		return false;
    	}
    	q.get(h.index).node.key = newKey;
    	int n = h.index;
    	while (n > 0 && q.get((int)Math.floor(n/2)).node.key>q.get(n).node.key){
    		keyswap(n, (int) Math.floor(n/2));
    		n = (int) Math.floor(n/2);
    	}
       return true;
    }

    /**
     * @return the key associated with the Handle.
     */
    public int handleGetKey(Handle<T> h) {
    	if(h.index != -1){
    		return q.get(h.index).node.key;
    	}
       return (Integer) null;
    }

    /**
     * @return the value associated with the Handle.
     */
    public T handleGetValue(Handle<T> h) {
    	if (h.index != -1){
    		return q.get(h.index).node.value;
    	}
       return null;
    }

    /**
     * Print every element of the queue in the order in which it appears
     * (i.e. the array representing the heap)
     */
    public String toString() {
    	String s = "( ";
    	for (int i =0; i<q.size();i++){
    		s=s+" ("+q.get(i).node.key+","+q.get(i).node.value.toString()+")";
    	}
       return s+" )";
    }
}
