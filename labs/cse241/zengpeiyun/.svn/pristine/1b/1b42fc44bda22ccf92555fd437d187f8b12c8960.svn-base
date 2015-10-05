package lab0;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestLab0 {
    @Test
    public void testLab0() {
        long startTime = System.currentTimeMillis();
	    int fooResult = Foo.bar(0);
	    long endTime = System.currentTimeMillis();
	    long duration = endTime - startTime;
	    assertEquals(2, fooResult);
	    System.out.println("Foo.bar() took " + duration + "ms to run.");
    }

  	public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestLab0.class);
        System.out.println("---------------");
    	  for (Failure failure : result.getFailures()) {
      		  System.out.println(failure.toString());
      	}
      	if (result.getFailures().size() == 0) {
      		  System.out.println("All tests passed!!");
      	} else {
            System.out.println("SOME TESTS FAILED :(");
        }
    }
}