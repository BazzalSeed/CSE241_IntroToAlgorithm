package lab2;

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

public class TestLab2 {

    private static final int MAX_MAP_SIZE = 1000;

    // Helper method to create n random keys
    private Set<String> generateKeys(int size) {
        Set<String> keys = new HashSet<String>();

        while(keys.size() < size) {
            keys.add(Long.toHexString(Double.doubleToLongBits(Math.random())));
        }
        return keys;
    }

    @Test
    public void testDoubling() {
        StringTable table = new StringTable(10);
        Set<String> keys = generateKeys(10);
        for(String key : keys) {
            Record record = new Record(key);
            assertEquals(true, table.insert(record));
        }
        assertEquals(true, table.size() >= 20);
    }

    @Test
    public void testDefaultConstructor() {
        Set<String> keys = generateKeys(MAX_MAP_SIZE);
        StringTable table = new StringTable();
        for(String key : keys) {
            assertEquals(true, table.insert(new Record(key)));
        }
    }

    @Test
    public void testParametrizedConstructor() {
        StringTable table = new StringTable(20);
        assertEquals(20, table.size());
    }
    
    @Test
    public void testInsertFind() {
        Set<String> keys = generateKeys(MAX_MAP_SIZE);
        Map<String, Record> records = new HashMap<String, Record>();
        StringTable table = new StringTable();
        for (String key : keys) {
            Record record = new Record(key);
            records.put(key, record);
            assertEquals(true, table.insert(record));
        }
        for (String key : keys) {
            assertEquals(records.get(key), table.find(key));
        }
    }

    @Test
    public void testInsertFindRemove() {
        Set<String> keys = generateKeys(MAX_MAP_SIZE);
        Map<String, Record> records = new HashMap<String, Record>();
        StringTable table = new StringTable();
        for(String key : keys) {
            Record record = new Record(key);
            records.put(key, record);
            assertEquals(true, table.insert(record));
        }
        for (String key : keys) {
            assertEquals(records.get(key), table.find(key));
        }
        for (Record record : records.values()) {
            table.remove(record);
        }
        for (String key : keys) {
            assertEquals(null, table.find(key));
        }
    }
    

    @Test
    public void testBaseHash() {
        StringTable table = new StringTable(4 * MAX_MAP_SIZE);
        int collisions = 0;
        boolean[] locations = new boolean[4 * MAX_MAP_SIZE];
        List<Integer> hashes = new ArrayList<Integer>();

        for (String key : generateKeys(MAX_MAP_SIZE)) {
            hashes.add(table.baseHash(table.toHashKey(key)));
        }

        for (int hash : hashes) {
            if (locations[hash % (4 * MAX_MAP_SIZE)]) {
                collisions++;
            } else {
                locations[hash % (4 * MAX_MAP_SIZE)] = true;
            }
        }

        // Only 5% of hashes should be collisions.
        System.out.println(collisions);
        System.out.println("Collision rate: " + ((double) collisions) / (4 * MAX_MAP_SIZE));
        assertEquals(true, collisions <  (4 * MAX_MAP_SIZE / 10));
    }

    
    @Test
    public void testStepHash() {
        StringTable table = new StringTable(4 * MAX_MAP_SIZE);
        int collisions = 0;
        boolean[] locations = new boolean[4 * MAX_MAP_SIZE];
        List<Integer> hashes = new ArrayList<Integer>();

        for (String key : generateKeys(MAX_MAP_SIZE)) {
            hashes.add(table.stepHash(table.toHashKey(key)));
        }

        for (int hash : hashes) {
            if (locations[hash % (4 * MAX_MAP_SIZE)]) {
                collisions++;
            } else {
                locations[hash % (4 * MAX_MAP_SIZE)] = true;
            }
        }

        // Only 10% of hashes should be collisions.
        System.out.println("Collision rate: " + ((double) collisions) / (4 * MAX_MAP_SIZE));
        assertEquals(true, collisions < (4 * MAX_MAP_SIZE / 10));
    }
  public static void main(String[] args) {
    	Result result = JUnitCore.runClasses(TestLab2.class);
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
