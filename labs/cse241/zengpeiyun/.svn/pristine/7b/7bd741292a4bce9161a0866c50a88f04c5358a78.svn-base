package lab3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestLab3 {

    private static final Random RAND = new Random();

    @Test
    public void basicInsertionMinExtractionTest() {
        PriorityQueue<String> q = new PriorityQueue<String>();
    
        // build up the queue
        q.insert(4, "four");
        q.insert(7, "seven");
        q.insert(1, "one");
        q.insert(6, "six");
        q.insert(12, "twelve");
        q.insert(3, "three");
        q.insert(11, "eleven");
        q.insert(5, "five");
        q.insert(8, "eight");
        q.insert(3, "three-prime");
        q.insert(2, "two");

        assertEquals(1, q.min());
        assertEquals("one", q.extractMin());
        assertEquals(2, q.min());
        assertEquals("two", q.extractMin());
        assertEquals(3, q.min());
        q.extractMin();
        assertEquals(3, q.min());
        q.extractMin();
        assertEquals(4, q.min());
        assertEquals("four", q.extractMin());
        assertEquals(5, q.min());
        assertEquals("five", q.extractMin());
    
        q.insert(1, "one");
        q.insert(15, "fifteen");
        q.insert(5, "five");
        assertEquals(1, q.min());
        assertEquals("one", q.extractMin());
        assertEquals(5, q.min());
        assertEquals("five", q.extractMin());
    }

    @Test
    public void basicHandleAndDecreaseTest() {
        PriorityQueue<String> q = new PriorityQueue<String>();
        Map<String, Handle> valuesToHandles = new HashMap<String, Handle>();
        Map<String, Integer> valuesToKeys = new HashMap<String, Integer>();
        int seq = 0;
        // Generate random numbres for the keys.
        for (int i = 0; i < 20; i++) {
            int key = RAND.nextInt(100);
            String val = Integer.toString(seq); // guarantees that the value is unique.
            seq++;
            valuesToKeys.put(val, key);
        }
        // Keep track of handles and build queue.
        for (Map.Entry<String, Integer> entry : valuesToKeys.entrySet()) {
            int key = entry.getValue();
            String value = entry.getKey();
            Handle h = q.insert(key, value);
            assertEquals(key, q.handleGetKey(h));
            assertEquals(value, q.handleGetValue(h));
            valuesToHandles.put(value, h);
        }

        // Remove some of the elements.
        for (int i = 0; i < 5; i++) {
            String val = q.extractMin();
            valuesToKeys.remove(val);
            valuesToHandles.remove(val);
        }
        
        // Make sure the handles are still valid.
        for (Map.Entry<String, Integer> entry : valuesToKeys.entrySet()) {
            int key = entry.getValue();
            String value = entry.getKey();
            Handle h = valuesToHandles.get(value);
            assertEquals(value, q.handleGetValue(h));
        }
        
        // Add some more elements.
        int limit = seq + 5;
        for (int i = seq; i < limit; i++) {
            int key = RAND.nextInt(100);
            String val = Integer.toString(seq);
            seq++;
            valuesToKeys.put(val, key);
            Handle h = q.insert(key, val);
            valuesToHandles.put(val, h);
        }

        // Decrease keys unnecessarily and verify that they still work.
        for (Map.Entry<String, Integer> entry : valuesToKeys.entrySet()) {
            int key = entry.getValue();
            String value = entry.getKey();
            Handle h = valuesToHandles.get(value);
            q.decreaseKey(h, key + 1);
            assertEquals(key, q.handleGetKey(h));
            assertEquals(value, q.handleGetValue(h));
        }

        // Change keys randomly, and check that the values remain attached to handles.
        for (Map.Entry<String, Integer> entry : valuesToKeys.entrySet()) {
            int key = entry.getValue();
            String value = entry.getKey();
            Handle h = valuesToHandles.get(value);
            int newKey = RAND.nextInt(100);
            q.decreaseKey(h, newKey);
            if (newKey < key) {
                assertEquals(newKey, q.handleGetKey(h));
            } else {
                assertEquals(key, q.handleGetKey(h));
            }
            assertEquals(value, q.handleGetValue(h));
        }
    }
    
    @Test
    public void biggerPriorityQueueTest() {
        
        PriorityQueue<String> q = new PriorityQueue<String>();
        Map<String, Handle> valuesToHandles = new HashMap<String, Handle>();
        Map<String, Integer> valuesToKeys = new HashMap<String, Integer>();
        int seq = 0;
        // Generate random numbres for the keys.
        for (int i = seq; i < 10000; i++) {
            int key = RAND.nextInt(1000000);
            String val = Integer.toString(seq); // guarantees that the value is unique.
            seq++;
            valuesToKeys.put(val, key);
        }
        // Keep track of handles and build queue.
        for (Map.Entry<String, Integer> entry : valuesToKeys.entrySet()) {
            int key = entry.getValue();
            String value = entry.getKey();
            Handle h = q.insert(key, value);
            assertEquals(key, q.handleGetKey(h));
            assertEquals(value, q.handleGetValue(h));
            valuesToHandles.put(value, h);
        }

        // Remove some of the elements.
        for (int i = 0; i < 5000; i++) {
            String val = q.extractMin();
            valuesToKeys.remove(val);
            valuesToHandles.remove(val);
        }

        // Add some more elements.
        for (int i = seq; i < 15000; i++) {
            int key = RAND.nextInt(1000000);
            String val = Integer.toString(seq);
            seq++;
            valuesToKeys.put(val, key);
            Handle h = q.insert(key, val);
            valuesToHandles.put(val, h);
        }

        // Change keys randomly, and check that the values remain attached to handles.
        for (Map.Entry<String, Integer> entry : valuesToKeys.entrySet()) {
            int key = entry.getValue();
            String value = entry.getKey();
            Handle h = valuesToHandles.get(value);
            int newKey = RAND.nextInt(1000000);
            q.decreaseKey(h, newKey);
            if (newKey < key) {
                assertEquals(newKey, q.handleGetKey(h));
            } else {
                assertEquals(key, q.handleGetKey(h));
            }
            assertEquals(value, q.handleGetValue(h));
        }

        // Make sure the handles are still valid.
        for (Map.Entry<String, Integer> entry : valuesToKeys.entrySet()) {
            int key = entry.getValue();
            String value = entry.getKey();
            Handle h = valuesToHandles.get(value);
            assertEquals(value, q.handleGetValue(h));
        }
    }
    
    @Test
    public void trivialShortestPathsTest() {
        Multigraph g = new Multigraph();
        Vertex a = new Vertex(0);
        Vertex b = new Vertex(1);
        Vertex c = new Vertex(2);
        Vertex d = new Vertex(3);
        Edge aToB = new Edge(0, a, b, 1);
        Edge bToC = new Edge(1, b, c, 1);
        Edge cToD = new Edge(2, c, d, 1);
        Edge aToD = new Edge(3, a, d, 1);
        a.addEdge(aToB);
        a.addEdge(aToD);
        b.addEdge(bToC);
        c.addEdge(cToD);
        g.addVertex(a);
        g.addVertex(b);
        g.addVertex(c);
        g.addVertex(d);
        ShortestPaths sp = new ShortestPaths(g, 0);
        int[] one = {3};
        int[] two = {0};
        int[] three = {0, 1};
        assertArrayEquals(one, sp.returnPath(d.id()));
        assertArrayEquals(two, sp.returnPath(b.id()));
        assertArrayEquals(three, sp.returnPath(c.id()));
    }

    // THIS IS NOT AN EXHAUSTIVE TEST.  It creates a random graph and then just checks to make
    // sure that the return path is a real path.  If you create a brute force algorithm,
    // you can check this more easily.  Or you can check it by hand (though you could just use
    // the normal class for that).
    @Test
    public void randomizedSmallShortestPathsTest() {
        Multigraph g = new Multigraph();
        int maxWeight = 10;
        List<Vertex> v = new ArrayList<Vertex>();
        List<Edge> e = new ArrayList<Edge>();
        // Just your basic randomized graph algorithm.
        for (int i = 0; i < 100; i++) {
            v.add(new Vertex(i));
        }
        int seq = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (j != i && RAND.nextDouble() < 0.4) {
                    Edge newEdge = new Edge(seq++, v.get(i), v.get(j), RAND.nextInt(maxWeight) + 1);
                    v.get(i).addEdge(newEdge);
                    e.add(newEdge);
                }
            }
        }
        for (Vertex vertex : v) {
            g.addVertex(vertex);
        }
        ShortestPaths sp = new ShortestPaths(g, 0);
        for (int i = 1; i < 100; i++) {
            int[] returnPath = sp.returnPath(i);
            Vertex current = v.get(0);
            for (int j = 0; j < returnPath.length; j++) {
                Edge currentEdge = e.get(returnPath[j]);
                assertEquals(current, currentEdge.from());
                current = currentEdge.to();
            }
        }
    }

    public static void main(String[] args) {
    	Result result = JUnitCore.runClasses(TestLab3.class);
    	System.out.println("---------------");
    	for (Failure failure : result.getFailures()) {
      		System.out.println(failure.toString());
            System.out.println(failure.getTrace());
      	}
      	if (result.getFailures().size() == 0) {
      		System.out.println("All tests passed!!");
      	} else {
            System.out.println("SOME TESTS FAILED :(");
        }
    }
}
