package lab0;

import java.util.Date;
import java.awt.*;

//=================================== Lab0 ===============================
//
// Just check that you can check out, compile code, run code, and check it in again.  
//
//========================================================================

public class Lab0 {

    public static void main(String args[]) {
    	if (args.length != 1) {
    		throw new IllegalArgumentException("Please pass in one number");
    	}
	int input=Integer.parseInt(args[0]);
	System.out.println("The input was " + input);
	int returnVal = Foo.bar(Integer.parseInt(args[0]));
	System.out.println("The output is "+returnVal);
    }

}    
//jesusß