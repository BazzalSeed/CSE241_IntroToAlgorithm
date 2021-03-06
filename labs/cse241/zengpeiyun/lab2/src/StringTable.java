package lab2;

import java.lang.reflect.Array;

/**
 * A hash table mapping Strings to their positions in the pattern sequence.
 *
 * Fill in the methods for this class.
 */
public class StringTable {
	public int size;
	public int fakesize;
	public Record[] record;
	public int count;


    /**
     * Create an empty table of size n
     *
     * @param n size of the table
     */
    public StringTable(int n) {
        // TODO: implement this method
    	fakesize=n;
    	size=(int) Math.pow(2.0,Math.floor((Math.log(n)/Math.log(2)+1)));
    	this.record=new Record[size];
    	count=0;
    	
    
    	
    }

   
    /**
     * Create an empty table.  You should use this construction when you are
     * implementing the doubling procedure.
     */
    public StringTable() {
        // TODO: implement this method
    	fakesize=4;
    	this.size=4;
    	this.record=new Record[size];
    	count=0;
    }

    /**
     * Insert a Record r into the table.
     *
     * If you get two insertions with the same key value, return false.
     *
     * @param r Record to insert into the table.
     * @return boolean true if the insertion succeeded, false otherwise
     */
    public boolean insert(Record r) {
        int position;
        
		if(find(r.getKey())!=null&&(find(r.getKey()).getInteger()!=-100)){
			System.out.println("record is "+record);
			return false;
        	
        }
		if(find(r.getKey())!=null&&find(r.getKey()).getInteger()==-100){
			record[this.hash(r.getKey())]=r;
			count=count+1;
			return true;
		}
		count=count+1;	

       if((double)(count)/(double)(size)>0.25){
        	this.doubling();
        }
            position=this.hash(r.getKey());
        
        	record[position]=r;
        
        
       
        	return true;
        	
    }

    /**
     * Delete a record from the table.
     *
     * Note: You'll have to find the record first unless you keep some
     * extra information in the Record structure.
     *
     * @param r Record to remove from the table.
     */
    public void remove(Record r) {
    	int position=this.hash(r.getKey());
    	if(find(r.getKey())!=null){
    	Record dummy= new Record("deleted");
    	dummy.setInteger(-100);
    	record[position]=dummy ;
    	count--;
    	}
    	
    }
        // TODO: implement this method
 

    /**
     * Find a record with a key matching the input.
     *
     * @param key to find
     * @return the matched Record or null if no match exists.
     */
    public Record find(String key) {
          int i=0;
          int k=toHashKey(key);
          int position=this.baseHash(k);
     
          while ((i<size)&&record[position]!=null){ 
          if(record[position].getKey().equals(key)){
        	  return record[position];
        	  
        	  }
 
        	  position=(position+this.stepHash(k))%size;
        	  //System.out.println("position is "+position);
              //System.out.println("size is "+record.length);
        	
              i++;}
          return null;
    }

    /**
     * Return the size of the hash table (i.e. the number of elements
     * this table can hold)
     *
     * @return the size of the table
     */
    public int size() {
        // TODO: implement this method
           return this.fakesize;
    }

    /**
     * Return the hash position of this key.  If it is in the table, return
     * the postion.  If it isn't in the table, return the position it would
     * be put in.  This value should always be smaller than the size of the
     * hash table.
     *
     * @param key to hash
     * @return the int hash
     */
    public int hash(String key) {
        // TODO: implement this method
    	//if(this.find(key)==null){
    		int hashkey=this.toHashKey(key);
    		int position=this.baseHash(hashkey);
    	    int i=0;
    			while(record[position]!=null&&(i<size)){
    				if(record[position].getKey().equals(key)){
    					return position;
    				}
    				position=(position+this.stepHash(hashkey))%size;
    				i++;
    				}
    			   return position;
    	//if(this.find(key)!=null){
    		//return this.find(key).getKey(key)..
    	}
             
    
    	
  public void doubling(){


	  Record[] temp=new Record[size];
	  int j=0;
	  for(int i=0;i<size;i++){
		  if(record[i]!=null&&(record[i].getInteger()!=-100)){
			 temp[j]=record[i];
			 j++;}}
	
	  this.size=2*size;
		fakesize=2*fakesize;
	  record=new Record[size];

	 for(int k=0;k<j;k++){	 
		 if(temp[k]!=null){
	      int position=hash(temp[k].getKey());
	 // System.out.println("position is "+position);
	      record[position]=temp[k];
		 }
	      }
	

	  
  }
  
  
	   
   //}

    /**
     * Convert a String key into an integer that serves as input to hash functions.
     * This mapping is based on the idea of a linear-congruential pseuodorandom
     * number generator, in which successive values r_i are generated by computing
     *    r_i = (A * r_(i-1) + B) mod M
     * A is a large prime number, while B is a small increment thrown in so that
     * we don't just compute successive powers of A mod M.
     *
     * We modify the above generator by perturbing each r_i, adding in the ith
     * character of the string and its offset, to alter the pseudorandom
     * sequence.
     *
     * @param s String to hash
     * @return int hash
     */
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

    /**
     * Computes the base hash of a hash key
     *
     * @param hashKey
     * @return int base hash
     */
    int baseHash(int hashKey) {
        // TODO: implement this method
        	int input=hashKey;
        	double A = (Math.sqrt(5)-1)/2;
        	int m=record.length;
        	int output =(int) (m*(input*A-(int)(input*A)));
        	return output;
   
    }

    /**
     * Computes the step hash of a hash key
     *
     * @param hashKey
     * @return int step hash
     */
    int stepHash(int hashKey) {
        // TODO: implement this method
    	int input=hashKey;
    	double A=(Math.sqrt(5)-1)/2;
    	int m=record.length-1;
    	
    	int output=(int)(m*(input*A-(int)((input)*A)));
    	if(output%2==0){
    		output=output+1;
    	}
        return output;
    }
    
    
}