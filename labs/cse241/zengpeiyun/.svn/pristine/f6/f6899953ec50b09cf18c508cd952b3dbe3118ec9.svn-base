package lab2;

import java.util.*;

/**
 * Record type for string hash table
 *
 * A record associates a certain string (the key value) with
 * a list of sequence positions at which that string occurs
 *
 * Change anything you want about this except the methods we have already.
 */
public class Record {
    private final String key;
    private final ArrayList<Integer> positions;
    private int integer;



    /**
     * Constructs a Record with the given string
     *
     * @param s key of the Record
     */
    public Record(String s) {
        key = s;
        positions = new ArrayList<Integer>(1);
        integer=toHashKey(s);
       
    }

    /**
     * Returns the key associated with this Record.
     */
    public String getKey() {
        return key;
    }
    
    public int getInteger(){
    	return integer;
    }

    public void setInteger(int a){
    	integer=a;
    }
    /**
     * Adds a new position to the positions list.
     *
     * @param position of the key
     */
    public void addPosition(Integer position) {
        positions.add(position);
    }

    /**
     * Returns how many positions we have
     */
    public int getPositionsCount() {
        return positions.size();
    }

    /**
     * Positions accessor
     */
    public Integer getPosition(int index) {
        return positions.get(index);
    }
   
    int toHashKey(String s) {
        int A = 1952786893;
        int B = 367253;
        int v = B;

        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            v = A * (v + (int) c + j) + B;
        }

        if (v < 0) {
            v = -v;
        }
        return v;
    }
}